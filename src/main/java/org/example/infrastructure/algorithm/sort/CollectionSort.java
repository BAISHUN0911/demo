package org.example.infrastructure.algorithm.sort;

import org.example.infrastructure.algorithm.sort.po.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 * 对集合排序，例如排序ArrayList、Map集合
 *
 * @Author BAISHUN
 * @Date: 2024/7/11 17:34
 */
public class CollectionSort {
    public static void main(String[] args) throws ParseException {
        // ArrayList中存放Student对象，要求定制排序这个集合，按照学生成绩降序，成绩相同按照名字升序，名字相同按照id升序
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Student student = new Student(1011L, "jack", 600, format.parse("2007-01-01 13:00:00"));
        Student student1 = new Student(1012L, "jack", 600, format.parse("2008-01-01 13:00:00"));
        Student student2 = new Student(1013L, "abc", 601, format.parse("2009-01-01 13:00:00"));
        Student student3 = new Student(1010L, "jackc", 600, format.parse("2008-01-01 13:00:00"));
        Student student4 = new Student(1010L, "jackc", 600, format.parse("2009-01-01 13:00:00"));
        Student student5 = new Student(1010L, "bob", 620, format.parse("2009-01-01 13:00:00"));
        ArrayList<Student> list = new ArrayList<>();
        list.add(student);list.add(student1);list.add(student2);list.add(student3);list.add(student4);list.add(student5);
        System.out.println("默认添加元素后，集合情况：");
        for (Student s : list) {
            System.out.println(s);
        }
        System.out.println("Collections.sort(list)后，集合情况：");
        Collections.sort(list); // Student类实现了Comparable<T>接口
        for (Student s : list) {
            System.out.println(s);
        }
        System.out.println("使用Collections外部排序后，集合情况：");
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getTotalPoints() != o2.getTotalPoints()) {
                    return o2.getTotalPoints() - o1.getTotalPoints();
                }else if (!o1.getName().equals(o2.getName())) {
                    return o1.getName().compareTo(o2.getName());
                }else {
                    return o1.getId().compareTo(o2.getId());
                }
            }
        });
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
