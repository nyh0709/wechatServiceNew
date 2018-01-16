/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: houmin[hou_no1@163.com] 
 * @date: 2017-12-26 22:16:39  
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.nyh.app.core.orm.index.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nyh.app.core.orm.index.po.PubinfoPo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
 * TODO
 *
 * @author houmin[hou_no1@163.com]
 * @date: 2017-12-26 22:16:39
 * @review: houmin[hou_no1@163.com]/2017-12-26 22:16:39
 */
@Data
@EqualsAndHashCode(callSuper=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true, includeFieldNames = true)
public class Pubinfo extends PubinfoPo {

	private	String	avatarUrl;//用户头像
	private	String	nickName;//用户昵称
	private	String[]	picUrls;//信息图片
	
	
}