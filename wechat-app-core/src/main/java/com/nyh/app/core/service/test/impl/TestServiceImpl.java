package com.nyh.app.core.service.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nyh.app.common.vo.PageVo;
import com.nyh.app.common.vo.test.TestVo;
import com.nyh.app.core.orm.test.domain.Test;
import com.nyh.app.core.orm.test.mapper.TestMapper;
import com.nyh.app.core.service.test.TestService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;
	
	@Value("${my.name}")
	private String myName;

	@Override
	public String insert(TestVo testVo) {
		testMapper.insert(testVo);
		return "success";
	}

	@Override
	public Test findUserByName(String name) {
		Test findUserByName = testMapper.findUserByName(name);
		log.info("my.name===={}",myName);
		return findUserByName;
	}

	@Override
	public PageInfo<Test> findAll(PageVo pageVo) {
		PageHelper.startPage(pageVo);
		PageInfo<Test> pageInfo = new PageInfo<Test>(testMapper.findAll());
		return pageInfo;
	}

}
