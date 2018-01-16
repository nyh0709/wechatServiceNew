package com.nyh.app.common.exception;

import com.nyh.app.common.enums.ExceptionEnum;

/**
 * 业务异常
 *
 */
public class ServiceException  extends AbstractException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 构造器
     */
    public ServiceException() {
        super(ExceptionEnum.SERVICE_EXCEPTION);
    }

    /**
     * 构造器
     * @param exceptionEnum
     */
    public ServiceException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
    
    public ServiceException(String message) {
        super(ExceptionEnum.SERVICE_EXCEPTION.getCode(), message);
    }
}
