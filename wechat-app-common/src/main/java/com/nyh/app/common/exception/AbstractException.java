package com.nyh.app.common.exception;


import com.nyh.app.common.enums.ExceptionEnum;

/**
 * 异常基类
 */
public class AbstractException extends RuntimeException  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 异常码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 构造器
     */
    public AbstractException() {
        super();
    }

    /**
     * 构造器
     */
    public AbstractException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    /**
     * 构造器
     * 
     * @param message
     */
    public AbstractException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * 构造器
     * 
     * @param code
     * @param message
     */
    public AbstractException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 获取code
     * 
     * @return
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取message
     * 
     * @return
     */
    public String getMessage() {
        return message;
    }
}
