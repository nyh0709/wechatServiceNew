package com.nyh.app.common.exception;

import com.nyh.app.common.enums.ExceptionEnum;

public class SystemException extends AbstractException{

	/**
	 *  系统异常
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 构造器
     */
    public SystemException() {
        super(ExceptionEnum.SYSTEM_EXCEPTION);
    }

    /**
     * 构造器
     * @param exceptionEnum
     */
    public SystemException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
    
    public SystemException(String message) {
        super(ExceptionEnum.SYSTEM_EXCEPTION.getCode(), message);
    }
}
