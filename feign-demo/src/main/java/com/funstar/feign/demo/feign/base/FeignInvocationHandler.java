package com.funstar.feign.demo.feign.base;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class FeignInvocationHandler implements InvocationHandler {

    private Class<?> type;

    private Object obj;

    public FeignInvocationHandler(Object obj,Class<?> type){
        this.obj = obj;
        this.type = type;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Objects.requireNonNull(obj);
            return method.invoke(obj, args);
        } catch (FeignException e) {
            return feignExceptionHandle(method, e);
        } catch (InvocationTargetException e) {
            Throwable target = e.getTargetException();
            if (target instanceof FeignException) {
                return feignExceptionHandle(method, (FeignException) target);
            } else {
                throw e;
            }
        } finally {
            //pass
        }
    }

    private Object feignExceptionHandle(Method method, FeignException e) {
        Method originalMethod = getOriginalMethod(method);
        if (null == originalMethod) {
            throw e;
        }
        Class<?> returnType = originalMethod.getReturnType();

        FeignExHandleType handleType = getExHandleType(originalMethod);

        if (handleType == FeignExHandleType.THROW) {
            throw e;
        }

        if (handleType == FeignExHandleType.RETURN_NULL) {
            log.debug("", e);
            return null;
        }

        if (handleType == FeignExHandleType.AUTO_RETURN) {
            if (e.getMessage().contains("status 404")) {
                log.debug(method.getName() + " response status 404");
            } else {
                log.debug("", e);
            }
            if (List.class.equals(returnType)) {
                return Collections.emptyList();
            }
            if (Map.class.equals(returnType)) {
                return Collections.emptyMap();
            }
            return null;
        }

        throw e;
    }

    private Method getOriginalMethod(Method method) {
        try {
            String methodName = method.getName();
            if ("toString".equals(methodName) || "equals".equals(methodName)) {
                return null;
            }
            return this.type.getDeclaredMethod(method.getName(), method.getParameterTypes());
        } catch (NoSuchMethodException e) {
            log.error("", e);
            return null;
        }
    }

    private FeignExHandleType getExHandleType(Method method) {
        if (null == method) {
            return null;
        }
        FeignExHandle feignExHandle = method.getDeclaredAnnotation(FeignExHandle.class);
        if (null == feignExHandle) {
            feignExHandle = this.type.getDeclaredAnnotation(FeignExHandle.class);
        }
        if (null == feignExHandle) {
            return null;
        }
        return feignExHandle.handleType();
    }
}
