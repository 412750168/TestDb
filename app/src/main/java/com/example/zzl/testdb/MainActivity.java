package com.example.zzl.testdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBManager dbManager = new DBManager(MainActivity.this);
        Person person = new Person("zi", 28, "user");
        Person person2 = new Person("yu", 18, "wife");
        Person person3 = new Person("wu", 30, "doctor");

        dbManager.add(person);
        dbManager.add(person2);
        dbManager.add(person3);

        Child child = new Child("yi", 12, "男");
        Child child2 = new Child("hang", 13, "女");
        dbManager.addChild(child);
        dbManager.addChild(child2);

        //dbManager.updateAge(person2);

        List<Person> persons = dbManager.query();
        List<Child> childs = dbManager.queryChild();

        //  List<Person> persons = dbManager.queryTest(null,"28","name","sum(age)>80",null);
        // DESC/ASC: limit:start,count

        // List<Person> persons = dbManager.queryTest(null,"28","name","sum(age)> 50","_id asc","1,1");

        for (Person per : persons) {
            LogUtil.LogDebug(MainActivity.class, per.toString());
        }
        for (Child ch : childs)
            LogUtil.LogDebug(MainActivity.class, ch.toString());

    }
}
