<#include "javadoc-copyright.ftl">
<#import "function.ftl" as func>
<#assign class=model.variables.class>
package com.${vars.company}.${vars.project}.core.orm.${vars.module}.po;

import com.nyh.app.core.orm.AbstractPo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

<#include "javadoc-file.ftl">
@Data
@EqualsAndHashCode(callSuper=true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ${class}Po extends AbstractPo{

<#list model.columnList as columnModel>
	<#if columnModel.humpColumnName?uncap_first != 'uuid'>
		/**
		 * ${columnModel.comment}
		 */
		private	${columnModel.colType}	${columnModel.humpColumnName?uncap_first};
	</#if>
</#list>
}