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

<#-- mpper_xml -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 

<mapper namespace="com.${vars.company}.${vars.project}.core.orm.${vars.module}.mapper.${class}Mapper">

	<resultMap id="Result" type="${type}">
		<#list colList as col>
			<#if (col.isPK) >
				<id property="${col.humpColumnName?uncap_first}" column="${col.columnName}" />
			<#else>
				<result property="${col.humpColumnName?uncap_first}" column="${col.columnName}" />
			</#if>
		</#list>
	</resultMap>
	
	<sql id="columns">
		<#list colList as col>${col.columnName}<#if col_has_next>,</#if></#list>
	</sql>
	
	<sql id="dynamicWhere">
		<where>
			<#list colList as col>
				<#if (col.colType=="String")>
					<if test="@Ognl@isNotEmpty(${col.humpColumnName?uncap_first})"> AND ${col.columnName}  =<#noparse>#{</#noparse>${col.humpColumnName?uncap_first}} </if>
				<#else>
					<if test="@Ognl@isNotEmpty(${col.humpColumnName?uncap_first})"> AND ${col.columnName}  =<#noparse>#{</#noparse>${col.humpColumnName?uncap_first}} </if>
				</#if>
			</#list>
		</where>
	</sql>

	<insert id="save" parameterType="${type}">
		INSERT INTO ${tableName}
		(<include refid="columns"/>)
		VALUES
		(<#list colList as col><#noparse>#{</#noparse>${col.humpColumnName?uncap_first}<#noparse>}</#noparse><#if col_has_next>, </#if></#list>)
	</insert>
	
	<delete id="delete" parameterType="${pkType}">
		DELETE FROM ${tableName} 
		WHERE ${pk}=<#noparse>#{</#noparse>${pk}}
	</delete>
	
	<update id="update" parameterType="${type}">
		UPDATE ${tableName}
		<set>
			<#list commonList as col>
			<#if (!col.isPK && (col.columnName)??) >
				<if test="@Ognl@isNotEmpty(${col.humpColumnName?uncap_first})"> ${col.columnName}=<#noparse>#{</#noparse>${col.humpColumnName?uncap_first}}<#if col_has_next>, </#if></if>
			</#if>
			</#list>
		</set>
		WHERE ${pk}=<#noparse>#{</#noparse>${pk}}
	</update>
		
	<select id="findOne" parameterType="${pkType}" resultMap="Result">
		SELECT <include refid="columns"/>
		FROM ${tableName}
		WHERE ${pk}=<#noparse>#{</#noparse>${pk}}
	</select>
	
	<select id="findAll" parameterType="${pkType}" resultMap="Result">
		SELECT <include refid="columns"/>
		FROM ${tableName}
		<if test="@Ognl@isNotEmpty(list)">
		WHERE ${pk} IN
		<foreach item="item" index="index" collection="list" open="(" separator="," close=")">  
				<#noparse>#{</#noparse>item}
		</foreach>
		</if>
	</select>
	
	<select id="find" parameterType="${type}" resultMap="Result">
		SELECT <include refid="columns"/>
		FROM ${tableName}
		<include refid="dynamicWhere"/>
	</select>
	
	<select id="count" parameterType="${type}" resultType="Integer">
		SELECT count(*)
		FROM ${tableName}
		<include refid="dynamicWhere"/>
	</select>
</mapper>
