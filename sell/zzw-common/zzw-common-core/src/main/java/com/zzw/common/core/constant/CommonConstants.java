package com.zzw.common.core.constant;

/**
 * @author liuyf
 * @date 2019/3/18
 */
public interface CommonConstants {
	/**
	 * 成功标记
	 */
	Integer SUCCESS_CODE = 0;
	/**
	 * 失败标记
	 */
	Integer FAIL_CODE = 1;

	/**
	 * 成功信息
	 */
	String SUCCESS_MSG= "SUCCESS";

	/**
	 * 失败信息
	 */
	String FAIL_MSG= "FAIL";

	String TOKEN = "token";

	String TOKEN_TEMPLATE = "token_%s";

	String OPENID = "openid";
	/**
	 * 过期时间(单位：s)
	 */
	Integer expire = 7200;


}
