package com.example.java3.week3.aop.interceptor;

import com.example.java3.week3.aop.MethodInvocation;

import java.lang.reflect.Method;


public class AfterExceptionMethodInterceptor implements MethodInterceptor{

    private Object aspectObj;
    private Method aspectMethod;

    public AfterExceptionMethodInterceptor(Object aspectObj, Method aspectMethod){
        this.aspectMethod = aspectMethod;
        this.aspectObj  = aspectObj;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable{
        try{
            return mi.proceed();
        } catch(Exception e){
            aspectMethod.setAccessible(true);
            aspectMethod.invoke(aspectObj);
        }
        return null;


    }
}
