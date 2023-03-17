package com.example.java3.week3.aop.interceptor;

import com.example.java3.week3.aop.MethodInvocation;
import com.example.java3.week3.aop.ProxyMethodInvocation;

import java.lang.reflect.Method;
public class AfterReturnMethodInterceptor implements MethodInterceptor {

    private Object aspectObj;
    private Method aspectMethod;

    public AfterReturnMethodInterceptor(Object aspectObj, Method aspectMethod){
        this.aspectObj = aspectObj;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable{

        try{
            return mi.proceed();
        } catch (Exception e){
            return null;
        }





    }


}
