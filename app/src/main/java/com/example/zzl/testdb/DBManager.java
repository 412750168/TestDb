package com.example.zzl.testdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzl on 16/8/26.
 */
public class DBManager {

    private DatabaseHelper helper;
    private SQLiteDatabase database;

    public DBManager(Context context) {

        helper = new DatabaseHelper(context);
        database = helper.getWritableDatabase();
    }

    public void add(List<Person> persons) {

        database.beginTransaction();

        try {

            for (Person person : persons) {
                database.execSQL("INSERT INTO" + DatabaseHelper.TABLE_NAME + "VALUES(null,?,?,?)", new Object[]{person.getName(), person.getAge(), person.getInfo()});

            }
            database.setTransactionSuccessful();

        } finally {
            database.endTransaction();
        }
    }

    public void add(Person person) {

        database.beginTransaction();

        try {
            database.execSQL("INSERT INTO " + DatabaseHelper.TABLE_NAME + " VALUES(null,?,?,?)", new Object[]{person.getName(), person.getAge(), person.getInfo()});

            database.setTransactionSuccessful();

        } finally {
            database.endTransaction();
        }
    }

    public void addChild(Child person) {

        database.beginTransaction();

        try {
            database.execSQL("INSERT INTO " + DatabaseHelper.TABLE_CHILD_NAME + " VALUES(null,?,?,?)", new Object[]{person.getName(), person.getAge(), person.getSex()});

            database.setTransactionSuccessful();

        } finally {
            database.endTransaction();
        }
    }

    public void updateAge(Person person) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("age", person.getAge());
        database.update(DatabaseHelper.TABLE_NAME, contentValues, "name=?", new String[]{person.getName()});

    }

    public void deleteOldPerson(Person person) {

        database.delete(DatabaseHelper.TABLE_NAME, "age >= ?", new String[]{String.valueOf(person.getAge())});
    }

    public List<Person> query() {

        ArrayList<Person> persons = new ArrayList<Person>();
        Cursor c = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, null);

        while (c.moveToNext()) {
            Person person = new Person();
            person.set_id(c.getInt(c.getColumnIndex("_id")));
            person.setName(c.getString(c.getColumnIndex("name")));
            person.setAge(c.getInt(c.getColumnIndex("age")));
            person.setInfo(c.getString(c.getColumnIndex("info")));
            persons.add(person);
        }
        return persons;
    }

    public List<Child> queryChild() {

        ArrayList<Child> persons = new ArrayList<Child>();
        Cursor c = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_CHILD_NAME, null);

        while (c.moveToNext()) {
            Child person = new Child();
            person.set_id(c.getInt(c.getColumnIndex("_id")));
            person.setName(c.getString(c.getColumnIndex("name")));
            person.setAge(c.getInt(c.getColumnIndex("age")));
            person.setSex(c.getString(c.getColumnIndex("sex")));
            persons.add(person);
        }
        return persons;
    }

    public List<Person> queryTest(String name ,String age,String groupby,String having,String orderby,String limit) {

        ArrayList<Person> persons = new ArrayList<Person>();


        String[] columns = {"_id","name","sum(age) AS AGS","info"};//你要的数据
        //String condition= "name= ? and age >= ?";
        String condition = "age >= ?";
        String[] selectionArgs={age};//具体的条件,注意要对应条件字段
        Cursor c=database.query(DatabaseHelper.TABLE_NAME, columns, condition,selectionArgs, groupby, having, orderby, limit);

        //Cursor c = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, );

        while (c.moveToNext()) {
            Person person = new Person();
            person.set_id(c.getInt(c.getColumnIndex("_id")));
            person.setName(c.getString(c.getColumnIndex("name")));
            person.setAge(c.getInt(c.getColumnIndex("AGS")));
            person.setInfo(c.getString(c.getColumnIndex("info")));
            persons.add(person);
        }
        return persons;
    }

}

