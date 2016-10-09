package com.example.zzl.testdb;

/**
 * Created by zzl on 16/8/26.
 */
public class Person extends Entity{

    public  String name;
    public int age;
    public String info;

    public Person() {
    }

    public Person(String name, int age, String info) {
        this.name = name;
        this.age = age;
        this.info = info;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", info='" + info + '\'' +
                '}';
    }
}
