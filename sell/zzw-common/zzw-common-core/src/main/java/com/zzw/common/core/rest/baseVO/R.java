package com.zzw.common.core.rest.baseVO;

import com.zzw.common.core.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 响应信息主体
 *
 * @param <T>
 * @author liuyf
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class R<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int code = CommonConstants.SUCCESS_CODE;

	@Getter
	@Setter
	private String msg = CommonConstants.SUCCESS_MSG;


	@Getter
	@Setter
	private T data;

	public R() {
		super();
	}

	public R(T data) {
		super();
		this.data = data;
	}

	public R(T data, String msg) {
		super();
		this.data = data;
		this.msg = msg;
	}

	public R(Throwable e) {
		super();
		this.msg = e.getMessage();
		this.code =CommonConstants.SUCCESS_CODE;
	}

	public R(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}


	public static <T> R<T> fail(String msg) {
		return new R<T>(CommonConstants.FAIL_CODE, msg, null);
	}

	public static <T> R<T> fail(T result) {
		return new R<T>(CommonConstants.FAIL_CODE, CommonConstants.FAIL_MSG, result);
	}

	public static <T> R<T> fail(String msg, T result) {
		return new R<T>(CommonConstants.FAIL_CODE, msg, result);
	}

}
