package com.xiaokunliu.blogs.thread.final2code;


/**
 * date:2020/1/25 10:29
 * author:keithl
 * desc: business desc etc.
 */
public class FinalClass {

    static FinalClass finalClass;
    public final int i;
    public final DefineFinalObject defineFinalObject;
    public int j;


    public FinalClass() {
//        int x = i;
//        DefineFinalObject var = defineFinalObject;
        i = 4;
        defineFinalObject = new DefineFinalObject();
        try {
            // code ... may throw exception
//            i = 4;
//            defineFinalObject = new DefineFinalObject();
            j = 9;
            // code ...
        } catch (Exception e) {
        }
    }

    static void writer() {
        finalClass = new FinalClass();
        System.out.println("have init FinalClass");
    }

    static void reader() {
        if (finalClass != null) {
            int x = finalClass.i;
            int y = finalClass.j;
            System.out.printf("get x = %d, and y = %d", x, y);
        }
    }

    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();
        System.out.println(finalClass.defineFinalObject);
        finalClass.defineFinalObject.setAge(10);
        System.out.println(finalClass.defineFinalObject);
    }
}
