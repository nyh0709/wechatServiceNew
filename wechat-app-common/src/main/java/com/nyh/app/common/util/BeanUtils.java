package com.nyh.app.common.util;

import org.springframework.cglib.beans.BeanCopier;

/**  
 * bean工具类
 */
public class BeanUtils {
    public static void copyToPo(Object srcObj,Object destObj) {
        if(srcObj==null){
            return;
        }
         BeanCopier copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), false);
         copier.copy(srcObj, destObj, null);
    }
}
