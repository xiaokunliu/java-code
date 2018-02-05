package com.dtrees.study.spring.core.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by keithl on 2017/11/8.
 */
@Service
@Scope("prototype")
public class PrototypeService {
}
