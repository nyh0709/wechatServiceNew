<#include "javadoc-copyright.ftl">
<#import "function.ftl" as func>
<#assign class=model.variables.class>
<#assign company=vars.company>
<#assign project=vars.project>
<#assign module=vars.module>
<#assign type="com."+company+"."+project+".core.orm."+module+".domain."+class>
<#assign tableName=model.tableName>
<#assign colList=model.columnList>
<#assign commonList=model.commonList>
<#assign pk=func.getPk(model) >
<#assign pkType=func.getPkType(model) >
<#assign pkVar=func.getPkVar(model) >
package com.${vars.company}.${vars.project}.core.orm.${vars.module}.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.${vars.company}.${vars.project}.core.orm.${vars.module}.domain.${class?cap_first};
com.${vars.company}.${vars.project}.core.orm.${vars.module}.po.${class?cap_first}Po;
<#include "javadoc-file.ftl">
@Repository
public interface ${class?cap_first}Mapper {

	@Insert("INSERT INTO ${tableName}" +
		"(<#list colList as col>${col.columnName}<#if col_has_next>,</#if></#list>)" +
		"VALUES" +
		"(<#list colList as col><#if col.humpColumnName?uncap_first == 'uuid'>REPLACE(UUID(),'-','')</#if><#if col.humpColumnName?uncap_first != 'uuid'><#noparse>#{</#noparse>${col.humpColumnName?uncap_first}<#noparse>}</#noparse></#if><#if col_has_next>, </#if></#list>)")
	@SelectKey(statement = "select REPLACE(UUID(),'-','') uuid", keyProperty = "uuid", before = true, resultType = ${class}.class, keyColumn = "UUID" )
    void insert(${class?cap_first}Po po);

    @Select("SELECT * FROM ${tableName}")
	List<${class?cap_first}> findAll();

}