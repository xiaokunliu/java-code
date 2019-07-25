package com.xiaokunliu.javase.io.test.stu;

import com.xiaokunliu.javase.bean.StudentBean;

import java.util.Comparator;

public class StuDemoCompator implements Comparator<StudentBean>{

	@Override
	public int compare(StudentBean o1, StudentBean o2) {

		int temp=o1.getMath()-o2.getMath();
		return temp==0?o1.getSum()-o2.getSum():temp;
	}

}
