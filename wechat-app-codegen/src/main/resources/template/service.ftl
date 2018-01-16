<#include "javadoc-copyright.ftl">
<#import "function.ftl" as func>
<#assign class=model.variables.class>
package com.${vars.company}.${vars.project}.core.service.${vars.module};

import com.github.pagehelper.PageInfo;
import com.${vars.company}.${vars.project}.common.vo.PageVo;
import com.${vars.company}.${vars.project}.core.orm.${vars.module}.domain.${class?cap_first};
import com.${vars.company}.${vars.project}.common.vo.${vars.module}.${class?cap_first}Vo;

<#include "javadoc-file.ftl">
public interface ${class}Service {

	String insert(${class}Vo vo);

	PageInfo<${class}> findAll(PageVo pageVo);

}