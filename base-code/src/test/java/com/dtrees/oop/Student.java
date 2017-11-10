package com.dtrees.oop;

/**
 * Created by keithl on 2017/11/5.
 */

public class Student extends Person{

    public final static String NAME = "STUDENT";

    public String name = "student";

    public Student(){
        super("xxx");
        System.out.println("execute student constructors ...");
    }

    public void showStudentName() {
        System.out.println("student show name ...");
    }

    @Override
    public void showName() {
        System.out.println("override parent class show name method ...");;
    }
}
