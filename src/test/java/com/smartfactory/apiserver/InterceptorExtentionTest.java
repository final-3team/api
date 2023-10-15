package com.smartfactory.apiserver;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Slf4j
public class InterceptorExtentionTest implements InvocationInterceptor {
    private int count = 10;

    @Override
    public <T> T interceptTestClassConstructor(Invocation<T> invocation, ReflectiveInvocationContext<Constructor<T>> invocationContext, ExtensionContext extensionContext) throws Throwable {

        return InvocationInterceptor.super.interceptTestClassConstructor(invocation, invocationContext, extensionContext);
    }

    public void interceptTestMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext,
                                     ExtensionContext extensionContext) throws Throwable {
        String methodName = invocationContext.getExecutable().getName();
        System.out.println("메소드 이름 : " + methodName);
        invocation.proceed();
    }
}
