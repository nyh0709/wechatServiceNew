<#include "javadoc-copyright.ftl">
<#import "function.ftl" as func>
<#assign class=model.variables.class>
<#assign colList=model.columnList>
package com.${vars.company}.${vars.project}.core.orm.${vars.module}.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.${vars.company}.${vars.project}.core.orm.${vars.module}.po.${class}Po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
<#include "javadoc-file.ftl">
@Data
@EqualsAndHashCode(callSuper=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true, includeFieldNames = true)
public class ${class} extends ${class}Po {

	 
	
}