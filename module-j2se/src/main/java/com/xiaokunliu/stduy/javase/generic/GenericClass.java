package com.xiaokunliu.stduy.javase.generic;

import com.xiaokunliu.stduy.javase.bean.Person;
import com.xiaokunliu.stduy.javase.bean.Student;

import java.util.Collection;


public class GenericClass<G> {

    public static <T> void getMax() {

    }

    public static <T> T get(T t) {
        return t;
    }

    //对象调用的泛型方法
    @SuppressWarnings("hiding")
    public <G> void method(G g) {

    }

    @SuppressWarnings("hiding")
    public <G> G show(G g) {
        return g;
    }

    /*
     * 上限
     */
    public void add(Collection<? extends Person> c) {

    }

    /*
     * 静态方法，必须指明类型，其不依赖于对象
     */

    /*
     * 下限
     */
    public void find(Collection<? super Student> c) {

    }

    /*
     * 通配符？,未知类型
     */
    @SuppressWarnings("hiding")
    public <G> void modify(G g) {

    }

}
