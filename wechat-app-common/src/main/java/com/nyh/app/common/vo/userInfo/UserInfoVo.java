package com.nyh.app.common.vo.userInfo;

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
@EqualsAndHashCode
@ToString
public class UserInfoVo {

		/**
		 * 微信号
		 */
		private	String	wechatId;
		/**
		 * 昵称
		 */
		private	String	nickName;
		/**
		 * 头像
		 */
		private	String	headPortrait;
		/**
		 * 创建日期
		 */
		private	java.util.Date	createDate;
}