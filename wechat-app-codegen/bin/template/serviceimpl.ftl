<#import "function.ftl" as func>
<#assign class=model.variables.class>
package com.${vars.company}.${vars.project}.core.service.${vars.module}.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.${vars.company}.${vars.project}.common.vo.PageVo;
import com.${vars.company}.${vars.project}.core.orm.${vars.module}.domain.${class?cap_first};
import com.${vars.company}.${vars.project}.core.orm.${vars.module}.mapper.${class?cap_first}Mapper;
import com.${vars.company}.${vars.project}.core.service.${vars.module}.${class?cap_first}Service;
import com.${vars.company}.${vars.project}.common.vo.${vars.module}.${class?cap_first}Vo;

import lombok.extern.slf4j.Slf4j;

<#include "javadoc-file.ftl">
@Service
@Slf4j
public class ${class}ServiceImpl implements ${class}Service {
	
	@Autowired
	private ${class}Mapper mapper;
	
	@Override
	public String insert(${class}Vo vo) {
		mapper.insert(vo);
		return "success";
	}
	
	@Override
	public PageInfo<${class}> findAll(PageVo pageVo) {
		PageHelper.startPage(pageVo);
		PageInfo<${class}> pageInfo = new PageInfo<${class}>(mapper.findAll());
		return pageInfo;
	}

}