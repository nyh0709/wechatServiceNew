package com.nyh.app.core.service.userInfo;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nyh.app.common.vo.PageVo;
import com.nyh.app.core.orm.userInfo.domain.UserInfo;

/**
 * TODO
 *
 * @author niuxudong[niu_xu_dong@163.com]
 * @date: 2017-12-26 22:03:18
 * @review: niuxudong[niu_xu_dong@163.com]/2017-12-26 22:03:18
 */
public interface UserInfoService {

	Map<String, Object> insert();

	PageInfo<UserInfo> findAll(PageVo pageVo);

	UserInfo findOne(String userId);

}