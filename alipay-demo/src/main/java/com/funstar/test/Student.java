package com.funstar.test;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * XXX
 *
 * @author funstar
 * @date 2019/12/5
 */
public class Student  extends Person{

    @JSONField(name = "student_grade")
    private String studentGrade;

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    protected String getName() {
        return "student";
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.print());
    }
}
