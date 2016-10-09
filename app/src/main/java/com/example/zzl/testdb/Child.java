package com.example.zzl.testdb;

/**
 * Created by zzl on 16/8/26.
 */
public class Child extends Entity {

    public String name ;
    public int age;
    public String sex;

    public Child() {
    }

    public Child(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Child{" +
                "_id='" + _id + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
