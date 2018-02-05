package com.dtrees.springmvc.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by keithl on 2017/11/15.
 */
@Component
//@Scope(value = WebApplicationContext.SCOPE_GLOBAL_SESSION)
//@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
//@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Scope(value = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.INTERFACES)
public class OrderBean {}
