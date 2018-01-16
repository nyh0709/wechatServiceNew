package com.nyh.app.core.orm.userInfo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nyh.app.core.orm.userInfo.po.UserInfoPo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
 * TODO
 *
 * @author niuxudong[niu_xu_dong@163.com]
 * @date: 2017-12-26 22:03:18
 * @review: niuxudong[niu_xu_dong@163.com]/2017-12-26 22:03:18
 */
@Data
@EqualsAndHashCode(callSuper=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true, includeFieldNames = true)
public class UserInfo extends UserInfoPo {

	 
	
}