package com.xiaokunliu.blogs.thread.final2code;

/**
 * date:2020/1/25 20:31
 * author:keithl
 * desc: business desc etc.
 */
public class FinalSharedClass {

    public final static int num;
    public final static DefineFinalObject defineFinalObject;
    public static int x;

    static {
        //    静态代码块，保证在加载类信息的时候也完成上述静态数据变量的初始化赋值的操作
        num = 10;
        defineFinalObject = new DefineFinalObject();
        System.out.printf("have finished static code for num=%d and obj=%s...\n", num, defineFinalObject);
    }

    {
        // 默认代码块
//        num = 10;
//        defineFinalObject = new DefineFinalObject();
    }

    static void writer() {
        // final 修饰的无法修改，将会编译报错提示已经分配值操作
//        num = 20;
//        defineFinalObject = new DefineFinalObject();
        x = 10;
        defineFinalObject.setAge(10);
    }

    static void reader() {
        // must be same with the end of static code
        System.out.printf("read final static num: %d \n", num);
        System.out.printf("read final static defineFinalObject: %s \n", defineFinalObject);

        // may be 0 or 10
        System.out.printf("read static x: %d \n", x);
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                FinalSharedClass finalSharedClass = new FinalSharedClass();
            }
        }.start();
//

        new Thread() {
            @Override
            public void run() {
                FinalSharedClass finalSharedClass = new FinalSharedClass();
            }
        }.start();

    }
}
