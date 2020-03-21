package com.xiaokunliu.interview.web.infrastructure.model;

/**
 * date:2019/11/22 18:14
 * author:keithl
 * desc: business desc etc.
 */
public class APIResult {

    // 返回的结果如下：
    // 失败直接返回400，凡是所有请求失败都返回400并携带对应的错误信息给到客户端
    // 需要进行认证返回401
    // 请求次数太多返回429
    // 成功直接返回200响应吗即可
    // 注册成功返回201
}
