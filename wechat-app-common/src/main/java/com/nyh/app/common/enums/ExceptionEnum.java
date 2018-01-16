package com.nyh.app.common.enums;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 异常信息信息枚举
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // 转json
public enum ExceptionEnum {

	UNAUTHORIZED(401,"权限验证不通过"),
    /**
     * 基础异常
     */
    SYSTEM_EXCEPTION(500, "系统异常"),
    
    /**
     * 业务异常
     */
    SERVICE_EXCEPTION(400, "业务异常"),

    /**
     * 验证异常
     */
    VALIDATE_EXCEPTION(1003, "验证异常"),

    /**
     * 新增数据异常
     */
    SAVE_EXCEPTION(1004, "新增数据异常"),

    /**
     * 更新数据异常
     */
    UPDATE_EXCEPTION(1005, "更新数据异常"),

    /**
     * 删除数据异常
     */
    DELETE_EXCEPTION(1006, "删除数据异常"),

    /**
     * 查询数据异常
     */
    FIND_EXCEPTION(1007, "查询数据异常"),
    


    ;
    
    /**
     * 构造方法
     * 
     * @param code
     * @param message
     */
    ExceptionEnum(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }
    
    /**
     * 构造方法
     * 
     * @param code
     * @param message
     */
    ExceptionEnum() {
    }

    /**
     * 通过code获取枚举
     *
     * @param code
     * @return
     */
    public static ExceptionEnum valueOfEnum(int code) {
        ExceptionEnum[] types = values();
        for (ExceptionEnum type : types) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }

    /**
     * code
     */
    private Integer code;

    /**
     * message
     */
    private String message;

    /**
     * 获取code
     * 
     * @return
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置code
     * 
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取message
     * 
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置message
     * 
     * @return
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
