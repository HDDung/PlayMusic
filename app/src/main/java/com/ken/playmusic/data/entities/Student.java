package com.ken.playmusic.data.entities;

import android.content.Intent;

/**
 * Created by ken on 01/11/2017.
 */

public class Student {
    String name, school;
    Integer age;

    public Student(String name, String school, Integer age) {
        this.name = name;
        this.school = school;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
