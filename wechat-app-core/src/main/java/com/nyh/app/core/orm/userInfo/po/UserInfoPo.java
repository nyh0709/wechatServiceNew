package com.nyh.app.core.orm.userInfo.po;

import com.nyh.app.core.orm.AbstractPo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TODO
 *
 * @author niuxudong[niu_xu_dong@163.com]
 * @date: 2017-12-26 22:03:17
 * @review: niuxudong[niu_xu_dong@163.com]/2017-12-26 22:03:17
 */
@Data
@EqualsAndHashCode(callSuper=true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoPo extends AbstractPo{

		/**
		 * 用户唯一标识
		 */
		private	String	openId;
		/**
		 * 昵称
		 */
		private	String	nickName;
		/**
		 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
		 */
		private	String	gender;
		/**
		 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效
		 */
		private	String	avatarUrl;
		/**
		 * 用户使用的语言
		 */
		private	String	language;
		/**
		 * 国家
		 */
		private	String	country;
		/**
		 * 省份
		 */
		private	String	province;
		/**
		 * 城市
		 */
		private	String	city;
		/**
		 * 创建日期
		 */
		private	java.util.Date	createDate;
}