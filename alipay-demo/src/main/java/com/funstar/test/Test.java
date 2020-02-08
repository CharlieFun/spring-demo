package com.funstar.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeMap;

/**
 * XXX
 *
 * @author funstar
 * @date 2019/12/5
 */
public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        student.setPersonAge(20);
        student.setPersonName("funstar");
        student.setStudentGrade("五年级");

        System.out.println(JSON.toJSON(student));

        System.out.println(JSON.toJSONString(student));

        String s = "{\"person_age\":20,\"person_name\":\"funstar\",\"student_grade\":\"五年级\"}";
        Student person1 = JSONObject.parseObject(s,Student.class);
        System.out.println(JSON.toJSONString(person1));

        String jsonString = JSON.toJSONString(person1);
        TreeMap<String, String> params = JSONObject.parseObject(jsonString, new TypeReference<TreeMap<String, String>>() {
        });

        Set<String> set = params.keySet();
        for (String str:set){
            System.out.println(str);
        }

    }
}
