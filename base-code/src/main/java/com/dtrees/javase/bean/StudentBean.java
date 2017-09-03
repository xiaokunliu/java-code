package com.dtrees.javase.bean;

import java.io.Serializable;

public class StudentBean implements Comparable<StudentBean>,Serializable{

	
	private String name;
	private int en,zn,math;
	private int sum;
	
	
	
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public StudentBean(String name, int en, int zn, int math) {
		super();
		this.name = name;
		this.en = en;
		this.zn = zn;
		this.math = math;
		this.sum=en+zn+math;
	}


	

	@Override
	public String toString() {
		return "StudentBean [name=" + name + ", en=" + en + ", zn=" + zn
				+ ", math=" + math + ", sum=" + sum + "]";
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getEn() {
		return en;
	}



	public void setEn(int en) {
		this.en = en;
	}



	public int getZn() {
		return zn;
	}



	public void setZn(int zn) {
		this.zn = zn;
	}



	public int getMath() {
		return math;
	}



	public void setMath(int math) {
		this.math = math;
	}



	public int getSum() {
		return sum;
	}



	public void setSum(int sum) {
		this.sum = sum;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + en;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sum;
		result = prime * result + zn;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentBean other = (StudentBean) obj;
		if (en != other.en)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sum != other.sum)
			return false;
		if (zn != other.zn)
			return false;
		return true;
	}



	@Override
	public int compareTo(StudentBean s) {
		
		int temp=this.sum-s.sum;
		
		return temp==0?this.name.compareTo(s.getName()):temp;
	}


}
