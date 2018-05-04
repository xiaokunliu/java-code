package com.crazysales.httprest.api;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class ApiBeforeAdvice implements MethodBeforeAdvice{
	
	private final Logger LOG = LoggerFactory.getLogger(ApiBeforeAdvice.class);

	public void before(Method method, Object[] args, Object target) throws Throwable {
		LOG.info("before api");
	}

}
