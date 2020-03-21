package com.xiaokunliu.interview.j2se.javase.io.test.stu;

import com.xiaokunliu.interview.j2se.javase.bean.StudentBean;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class StudentTest {

    public static void main(String[] args) throws IOException {

        ReadAndWriteTool tool = ReadAndWriteTool.getReadAndWriteTool();
		/*
		 *  	aa,89,78,78
			bb,90,89,78
			cc,79,80,70
			dd,78,78,90
			ee,80,78,87
		 */
        //总分从低到高排序
//		Set<StudentBean> set=tool.getStudent();
//		for (StudentBean studentBean : set) {
//			System.out.println(studentBean);
//		}
//		demo(tool);
        //实现数学分数从高到低排列
        Comparator<StudentBean> comp = Collections.reverseOrder(new StuDemoCompator());
        Set<StudentBean> set = tool.getStudent(comp);
//		for (StudentBean studentBean : set) {
//			System.out.println(studentBean);
//		}
        tool.write2File(set, new File(".//src//com//wind//io//test//stu//stu2.txt"));
        tool.close();


    }

    public static void demo(ReadAndWriteTool tool) throws IOException {
        //实现总分从高到低
        Comparator<StudentBean> comp = Collections.reverseOrder();
        Set<StudentBean> set = tool.getStudent(comp);
//		for (StudentBean studentBean : set) {
//			System.out.println(studentBean);
//		}
        tool.write2File(set, new File(".//src//com//wind//io//test//stu//stu.txt"));
        tool.close();
    }
}
