<#include "javadoc-copyright.ftl">
<#import "function.ftl" as func>
<#assign class=model.variables.class>
package com.${vars.company}.${vars.project}.common.vo.${vars.module};

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

<#include "javadoc-file.ftl">
@Data
@EqualsAndHashCode
@ToString
public class ${class}Vo {

<#list model.columnList as columnModel>
	<#if columnModel.humpColumnName?uncap_first != 'uuid'>
		/**
		 * ${columnModel.comment}
		 */
		private	${columnModel.colType}	${columnModel.humpColumnName?uncap_first};
	</#if>
</#list>
}