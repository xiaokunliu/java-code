package com.dtrees.study.springinaction.assembly.identifier;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by keithl on 2017/11/15.
 */
@Component
//@Primary
//@Qualifier("cake")
@Sweet
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Cake implements Dessert{}
