package com.dobi.day14_Hash_Table;

import java.util.HashMap;
import java.util.HashSet;

/**
 * java中的hashCode
 */
public class Day14_3 {

    public static void main(String[] args) {

        //整数的hashcode是他本身，得到hashCode后再由哈希表将键转成索引
        int a =42;
        //对象才有hashCode方法
        System.out.println(((Integer)a).hashCode());

        int b =-42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415;
        System.out.println(((Double)c).hashCode());

        String d ="du";
        System.out.println(d.hashCode());

        Student student = new Student("hesu",21);
        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet.add(student);

        HashMap<Student,Integer> studentIntegerHashMap = new HashMap<>();
        studentIntegerHashMap.put(student,100);

    }



}


class Student{

    private String name;
    private int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    /**
     * 复写hashcode
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}