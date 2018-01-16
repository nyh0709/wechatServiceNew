/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: houmin[hou_no1@163.com] 
 * @date: 2017-12-26 22:16:39  
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.nyh.app.common.vo.publish;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * TODO
 *
 * @author yxchao[yxchao3636@163.com]
 * @date: 2017-12-26 22:16:39
 * @review: yxchao[yxchao3636@163.com]/2017-12-31 22:16:39
 */
@Data
@EqualsAndHashCode
@ToString
public class PublishVo {

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
		 * 图片的名称
		 */
		private String imageName;
		/**
		 * 图片的大小
		 */
		private int  imageSize;
		/**
		 * 图片的类型
		 */
		private String imageType;
		/**
		 * 创建日期
		 */
		private	String	createDate;
}
