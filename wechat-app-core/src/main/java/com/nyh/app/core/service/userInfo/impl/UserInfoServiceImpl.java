package com.nyh.app.core.service.userInfo.impl;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nyh.app.common.constant.AppConstant;
import com.nyh.app.common.exception.SystemException;
import com.nyh.app.common.util.AesEncryptor;
import com.nyh.app.common.util.HttpsUtil;
import com.nyh.app.common.util.JsonUtil;
import com.nyh.app.common.vo.PageVo;
import com.nyh.app.core.context.WebContext;
import com.nyh.app.core.orm.userInfo.domain.UserInfo;
import com.nyh.app.core.orm.userInfo.mapper.UserInfoMapper;
import com.nyh.app.core.service.userInfo.UserInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author niuxudong[niu_xu_dong@163.com]
 * @date: 2017-12-26 21:50:59
 * @review: niuxudong[niu_xu_dong@163.com]/2017-12-26 21:50:59
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper mapper;
	
	@Value("${wechat.get-session-key.url}")
	private String wechatGetSessionKeyUrl;
	
	/**
	 * 登陆
	 */
	@Override
	public Map<String, Object> insert() {
		HttpServletRequest request = WebContext.getHttpServletRequest();
		String code = request.getHeader(AppConstant.WX_HEADER_CODE);
		String encryptedData = request.getHeader(AppConstant.WX_HEADER_ENCRYPTED_DATA);
		String iv = request.getHeader(AppConstant.WX_HEADER_IV);
		log.info("code={},encryptedData={},iv={}",code,encryptedData,iv);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//获取sessionKey
			String sessionKeyJson = HttpsUtil.post(wechatGetSessionKeyUrl
												.replace("APPID", AppConstant.APP_ID)
												.replace("SECRET", AppConstant.APP_SECRET)
												.replace("JSCODE", code), null, null, null);
			log.info("sessionKeyJson={}",sessionKeyJson);
			String sessionKey = JsonUtil.getValue(sessionKeyJson, "session_key");
			log.info("sessionKey={}",sessionKey);
			//解密微信用户信息密文
			byte[] resultByte  = AesEncryptor.decrypt(Base64.decodeBase64(encryptedData),   
                    Base64.decodeBase64(sessionKey),  
                    Base64.decodeBase64(iv));
			String decrypt = new String(resultByte);
			log.info("decrypt={}",decrypt);
			UserInfo userInfo = JsonUtil.jsonToJavaBean(decrypt,UserInfo.class);
			log.info("userInfo={}",userInfo);
			//校验该用户是否存在
			UserInfo findByOpenId = mapper.findByOpenId(userInfo.getOpenId());
			if (findByOpenId == null) {
				mapper.insert(userInfo);
				map.put("userInfo", userInfo);
			} else {
				map.put("userInfo", findByOpenId);
			}
			map.put("skey", sessionKey);
		} catch (Exception e) {
			log.error("登录异常",e);
			throw new SystemException("微信登录失败，请稍后再试");
		}
		return map;
	}
	
	@Override
	public PageInfo<UserInfo> findAll(PageVo pageVo) {
		PageHelper.startPage(pageVo);
		PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(mapper.findAll());
		return pageInfo;
	}

	@Override
	public UserInfo findOne(String userId) {
		return mapper.findOne(userId);
	}

}