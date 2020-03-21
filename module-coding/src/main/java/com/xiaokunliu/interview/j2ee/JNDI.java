package com.xiaokunliu.interview.j2ee;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import java.util.Hashtable;
import java.util.Properties;

/**
 * project:java-code
 * file:JNDI
 * package:com.xiaokunliu.j2ee
 * date:2018/10/2 上午10:00
 * author:keithl
 */
public class JNDI {

    // JNDI：Java Naming Directory Interface，java命名目录接口  -- 类似接口发布/暴露

    /**
     * JNDI应用：应用服务器通过上下文对象Context来进行查找对应的资源对象，context.lookup(jndi_name)
     * 目录服务是命名服务的扩展，目录服务不仅需要保存名称和对象之间的关联，而且还会保存对象的各种属性，允许开发者操作对象的属性，包括查询，修改，增加或删除对象属性
     * 目录服务的典型例子就是电话簿，它记录了用户名和用户对象之间的对应关系，地址和电话号码称为属性，对应值称为属性值
     * 常用命名，目录服务系统除了JNDI，还有LDAP（Lightweight Directory Access Protocol）以及MAD（Microsoft Active Directory）
     */

    /**
     * LDAP：目录中的信息是按照树型结构组织的，具体一个信息存储在一种条目的数据结构之中，条目相当于关系数据库中表的记录，条目由一个名称DN和多个属性组成，DN用于引用条目，
     * DN相当于数据库表中的关键字primary key，属性则由类型Type和一个或多个值组成，相当于关系数据库表中的Field由字段名和数据类型组成
     */


    // JNDI：面向接口API编程方式

    // JNDI编程
    /**
     * binding（绑定）：为对象起一个名字就是绑定，专业说法就是将一个名字绑定了对象
     * Context（上下文）：它是一组绑定关系的集合，在一个Context内，所有绑定的名称都必须是唯一的，这样程序就可在指定的Context内根据名称找到与之绑定的对象，以一个文件系统为例，
     * 一个目录就是一个context，其内容就是文件名（名称）和实际文件（对象）的绑定关系的集合，一个Context还有SubContext，就像目录还有子目录一样
     * Naming System（命名系统）：命名系统就是遵循某种命名规则的绑定系统，例如，文件系统就是一种命名系统
     * Naming Service（命名服务）：命名服务就是命名系统对外提供的功能和服务，命名服务的最大功能就是允许通过名字来访问与之绑定的对象
     * Directory Service（目录服务）：目录服务是命名服务的扩展，它不仅需要将名字和对象绑定在一起，还为对象记录一个或者多个属性
     */

    // 使用JNDI需要以下的支持

    /**
     * 1. JNDI API：jdk已默认提供支持
     * 2. JNDI SPI；应程序面向统一的JNDI API以一致的方式来编程，而底层的命名，目录服务则通过SPI来提供服务 -- 需要下载额外jar包
     * 3. 目录，命名服务器：需要安装对应的SPI
     */


    public static void jndiCoding() throws Exception {

        // 获取系统属性
        Properties properties = System.getProperties();
        for (String name : properties.stringPropertyNames()) {
            System.out.println(String.format("name:%s,value:%s", name, properties.getProperty(name)));
        }

        // 创建方式一
        Context context = new InitialContext();

        // 创建方式二
        Hashtable<String, String> env = new Hashtable<>();
        // 初始化Context工厂类
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        // 为Context服务提供URL，在磁盘/home/ubuntu/keithl/published/路径作为初始化路径，在允许程序必须保证该目录下是存在的，即在该文件路径作为Context上下文
        env.put(Context.PROVIDER_URL, "file:/home/ubuntu/keithl/published/");
        Context context1 = new InitialContext(env);

        // 查找对象
        ServiceBean serviceBean = (ServiceBean) context1.lookup("service");
        // 绑定对象,为obj对象起了一个name名称
        ServiceBean serviceBean2 = new ServiceBean();
        context1.bind("service", serviceBean2);
        // 重新绑定，将原先绑定过的名称重新绑定到新的对象上
        context1.rebind("service", serviceBean2);


        // 列出当前Context下的所有绑定关系
        NamingEnumeration<Binding> binds = context1.listBindings("");
        while (binds.hasMore()) {
            Binding binding = binds.next();
            System.out.println(String.format("name:%s,object:%s", binding.getName(), binding.getObject()));
        }

        //列出当前Context指定的SubContext，每一个文件夹就是一个Context
        String dirName = "";
        context1.listBindings(dirName);
        // 遍历绑定关系同上

        // 创建SubContext -- 实际上就是创建个子目录
        String newDirs = "";
        context1.createSubcontext(newDirs);

        // 将当前的Context下指定的绑定名称进行重新命名
        context1.rename("older", "newer");

        // 删除SubContext
        context1.destroySubcontext(newDirs);
    }
}


class ServiceBean {

}