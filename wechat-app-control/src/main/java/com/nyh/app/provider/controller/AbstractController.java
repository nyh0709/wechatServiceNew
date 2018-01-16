package com.nyh.app.provider.controller;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nyh.app.common.enums.ExceptionEnum;
import com.nyh.app.common.exception.AbstractException;
import com.nyh.app.common.exception.ServiceException;
import com.nyh.app.common.res.ResponseMessage;

import lombok.extern.slf4j.Slf4j;


/**
 * 抽象Controller
 *
 */
@Slf4j
@SuppressWarnings({ "unchecked", "rawtypes" })
public class AbstractController {

    /**
     * 通用带请求参数和返回值函数式方法
     *
     * @param function 逻辑函数
     * @param param 函数参数
     * @param <T> 函数请求参数类型
     * @param <R> 函数返回类型
     * @return
     */
    public <T, R> ResponseEntity<R> wrapperFunction(Function<T, R> function, T param) {
        try {
            R r = function.apply(param);
            return ResponseEntity.ok(r);
        }catch (ServiceException serviceException) {
            log.info("controller 内部业务异常：{}", serviceException.getMessage(), serviceException);
            return error(serviceException);
        }catch (AbstractException abstractException) {
            log.warn("controller 主动系统异常：{}", abstractException.getMessage(), abstractException);
            return error(abstractException);
        }catch (Exception e) {
            log.error("controller 内部异常：{}", e.getMessage(), e);
            return error();
        }
    }

    /**
     * 通用带请求参数不带返回值函数式方法
     *
     * @param function 逻辑函数
     * @param param 函数参数
     * @param <P> 函数请求参数类型
     * @return
     */
    public <P> ResponseEntity wrapperConsumer(Consumer<P> function, P param) {
        try {
            function.accept(param);
            return ok();
        }catch (ServiceException serviceException) {
            log.info("controller 内部业务异常：{}", serviceException.getMessage(), serviceException);
            return error(serviceException);
        }catch (AbstractException abstractException) {
            log.warn("controller 主动系统异常：{}", abstractException.getMessage(), abstractException);
            return error(abstractException);
        }catch (Exception e) {
            log.error("controller 内部异常：{}", e.getMessage(), e);
            return error();
        }
    }

    /**
     * 通用带返回值不带请求参数的函数式方法
     *
     * @param function 逻辑函数
     * @return
     */
    public <T> ResponseEntity<T> wrapperSupplier(Supplier<T> function) {
        try {
            T t = function.get();
            return ok(t);
        }catch (ServiceException serviceException) {
            log.info("controller 内部业务异常：{}", serviceException.getMessage(), serviceException);
            return error(serviceException);
        }catch (AbstractException abstractException) {
            log.warn("controller 主动系统异常：{}", abstractException.getMessage(), abstractException);
            return error(abstractException);
        } catch (Exception e) {
            log.error("controller 内部异常：{}", e.getMessage(), e);
            return error();
        }
    }

    /**
     * 返回 http 200
     *
     * @return
     */
    public ResponseEntity ok() {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 返回http 200 并携带数据
     *
     * @param body 数据
     * @param <T>
     * @return
     */
    public <T> ResponseEntity ok(T body) {
        return ResponseEntity.ok(body);
    }

    /**
     * 返回 http 500 携带默认错误信息
     *
     * @return
     */
    public ResponseEntity error() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(new ResponseMessage(ExceptionEnum.SYSTEM_EXCEPTION));
    }

    /**
     * 返回http 400 携带指定错误信息
     *
     * @param body
     * @param <T>
     * @return
     */
    public <T> ResponseEntity error(T body) {
        int status = HttpStatus.BAD_REQUEST.value();
        if (body instanceof AbstractException) {
//            status = ((AbstractException) body).getCode();
            ResponseMessage message = new ResponseMessage();
            message.setCode(((AbstractException) body).getCode());
            message.setMessage(((AbstractException) body).getMessage());
            body = (T) message;
        }
        return ResponseEntity.status(status).body(body);
    }

    /**
     * 返回指定 http状态 携带指定信息
     *
     * @param status
     * @param body
     * @param <T>
     * @return
     */
    public <T> ResponseEntity error(HttpStatus status, T body) {
        return ResponseEntity.status(status.value()).body(body);
    }
    
}
