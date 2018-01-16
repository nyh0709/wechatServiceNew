package com.nyh.app.common.constant;

public interface AppConstant {
	/**
	 * 微信请求头，用户登录凭证（有效期五分钟）。开发者需要在开发者服务器后台调用 api，使用 code 换取 openid 和 session_key 等信息
	 */
	public static final String WX_HEADER_CODE = "X-WX-Code";
	/**
	 * 微信请求头，包括敏感数据在内的完整用户信息的加密数据
	 */
	public static final String WX_HEADER_ENCRYPTED_DATA = "X-WX-Encrypted-Data";
	/**
	 * 微信请求头，加密算法的初始向量
	 */
	public static final String WX_HEADER_IV = "X-WX-IV";
	/**
	 * 微信请求头，用户表uuid
	 */
	public static final String WX_HEADER_USER_ID = "X-WX-UserId";
	/**
	 * 微信小程序appId
	 */
	public static final String APP_ID = "wx5aa01f4fa28d1886";
	/**
	 * 微信小程序appSecret
	 */
	public static final String APP_SECRET = "3453c9d328f6edea974e395b95f940bb";
	/**
	 * 微信请求头，包括用户绑定微信的手机号的加密数据
	 */
	public static final String WX_HEADER_PHONENUM_ENCRYPTED_DATA = "X-WX-Phonenum-Encrypted-Data";
}
