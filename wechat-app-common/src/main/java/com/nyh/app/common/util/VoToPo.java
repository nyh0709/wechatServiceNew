package com.nyh.app.common.util;
import java.beans.PropertyDescriptor;
import java.util.Collection;

import org.apache.commons.beanutils.PropertyUtils;

import com.nyh.app.common.exception.SystemException;

import lombok.extern.slf4j.Slf4j;  

@Slf4j
public class VoToPo {

	    /** 
	     * Copy properties of orig to dest Exception the Entity and Collection Type 
	     * 将后面的属性值赋给前面的对象
	     * @param dest 
	     * @param orig 
	     * @return the dest bean 
	     */  
	    public static Object copyProperties(Object dest, Object orig) {  
	        if (dest == null || orig == null) {  
	            return dest;  
	        }  
	  
	        PropertyDescriptor[] destDesc = PropertyUtils.getPropertyDescriptors(dest);  
	        try {  
	            for (int i = 0; i < destDesc.length; i++) {  
	                Class destType = destDesc[i].getPropertyType();  
	                Class origType = PropertyUtils.getPropertyType(orig, destDesc[i].getName());  
	                if (destType != null && destType.equals(origType) && !destType.equals(Class.class)) {  
	                    //判断origType是不是基本数据结构
	                	if (!Collection.class.isAssignableFrom(origType)) {  
	                        try {  
	                            Object value = PropertyUtils.getProperty(orig, destDesc[i].getName());  
	                            PropertyUtils.setProperty(dest, destDesc[i].getName(), value);  
	                        } catch (Exception ex) {}  
	                    }  
	                }  
	            }  
	  
	            return dest;  
	        } catch (Exception ex) {  
	        	log.error("vo转换异常",ex);
	            throw new SystemException("系统繁忙");  
	            // return dest;  
	        }  
	    }  
	  
	    /**   */  
	    /** 
	     * Copy properties of orig to dest Exception the Entity and Collection Type 
	     * ignores中的属性不进行重新赋值
	     * @param dest 
	     * @param orig 
	     * @param ignores 
	     * @return the dest bean 
	     */  
	    public static Object copyProperties(Object dest, Object orig, String[] ignores) {  
	        if (dest == null || orig == null) {  
	            return dest;  
	        }  
	  
	        PropertyDescriptor[] destDesc = PropertyUtils.getPropertyDescriptors(dest);  
	        try {  
	            for (int i = 0; i < destDesc.length; i++) {  
	                if (contains(ignores, destDesc[i].getName())) {  
	                    continue;  
	                }  
	  
	                Class destType = destDesc[i].getPropertyType();  
	                Class origType = PropertyUtils.getPropertyType(orig, destDesc[i].getName());  
	                if (destType != null && destType.equals(origType) && !destType.equals(Class.class)) {  
	                    if (!Collection.class.isAssignableFrom(origType)) {  
	                        Object value = PropertyUtils.getProperty(orig, destDesc[i].getName());  
	                        PropertyUtils.setProperty(dest, destDesc[i].getName(), value);  
	                    }  
	                }  
	            }  
	  
	            return dest;  
	        } catch (Exception ex) {  
	        	log.error("vo转换异常",ex);
	            throw new SystemException("系统繁忙");  
	        }  
	    }  
	  
	    static boolean contains(String[] ignores, String name) {  
	        boolean ignored = false;  
	        for (int j = 0; ignores != null && j < ignores.length; j++) {  
	            if (ignores[j].equals(name)) {  
	                ignored = true;  
	                break;  
	            }  
	        }  
	  
	        return ignored;  
	    }  


}
