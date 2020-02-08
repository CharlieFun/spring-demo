package com.funstar.test;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * XXX
 *
 * @author funstar
 * @date 2019/12/5
 */
public class Person {

    @JacksonXmlProperty(localName = "person_name")
    @JSONField(name = "person_name")
    private String personName;

    @JacksonXmlProperty(localName = "person_age")
    @JSONField(name = "person_age")
    private int personAge;

    protected String print(){
        return getName();
    }

    protected String getName() {
        return "person";
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }
}
