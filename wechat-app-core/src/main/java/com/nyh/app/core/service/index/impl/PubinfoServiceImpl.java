package com.nyh.app.core.service.index.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nyh.app.common.vo.PageVo;
import com.nyh.app.core.orm.index.domain.Pubinfo;
import com.nyh.app.core.orm.index.mapper.PubinfoMapper;
import com.nyh.app.core.service.index.PubinfoService;
import com.nyh.app.common.vo.index.PubinfoVo;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author houmin[hou_no1@163.com]
 * @date: 2017-12-26 22:16:39
 * @review: houmin[hou_no1@163.com]/2017-12-26 22:16:39
 */
@Service
@Slf4j
public class PubinfoServiceImpl implements PubinfoService {
	
	@Autowired
	private PubinfoMapper mapper;
	
	@Override
	public String insert(PubinfoVo vo) {
		mapper.insert(vo);
		return "success";
	}
	
	@Override
	public PageInfo<Pubinfo> findAll(PageVo pageVo) {
		PageHelper.startPage(pageVo);
		PageInfo<Pubinfo> pageInfo = new PageInfo<Pubinfo>(mapper.findAll());
		List<Pubinfo> list = pageInfo.getList();
		for (Pubinfo pubinfo : list) {
			String[] split = pubinfo.getImageUrl().split(",");
			pubinfo.setPicUrls(split);
		}
		return pageInfo;
	}

}