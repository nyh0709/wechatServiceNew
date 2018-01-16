package com.nyh.app.common.res;

import java.io.Serializable;

import com.nyh.app.common.enums.ExceptionEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ResponseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * code
     */
    private Integer code;

    /**
     * message
     */
    private String message;
    
    public ResponseMessage(ExceptionEnum exceptionEnum){
    	this(exceptionEnum.getCode(), exceptionEnum.getMessage());
    }
}
