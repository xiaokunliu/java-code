package com.xiaokunliu.interview.j2se.javase.bean;

/**
 * Created by keithl on 2017/9/3.
 */

public class Person implements Comparable<Person> {

    private String name;
    private Integer age;


    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        int temp = this.name.compareTo(p.name);
        return temp == 0 ? this.age - p.age : temp;
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode....");
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals....");
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
