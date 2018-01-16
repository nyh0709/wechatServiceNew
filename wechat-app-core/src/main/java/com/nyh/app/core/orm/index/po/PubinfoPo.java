/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: houmin[hou_no1@163.com] 
 * @date: 2017-12-26 22:16:38  
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.nyh.app.core.orm.index.po;

import com.nyh.app.core.orm.AbstractPo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TODO
 *
 * @author houmin[hou_no1@163.com]
 * @date: 2017-12-26 22:16:38
 * @review: houmin[hou_no1@163.com]/2017-12-26 22:16:38
 */
@Data
@EqualsAndHashCode(callSuper=true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PubinfoPo extends AbstractPo{

		/**
		 * 用户id
		 */
		private	String	userId;
		/**
		 * 内容
		 */
		private	String	content;
		/**
		 * 图片保存文件夹
		 */
		private	String	imageUrl;
		/**
		 * 创建日期
		 */
		private	String	createDate;
}