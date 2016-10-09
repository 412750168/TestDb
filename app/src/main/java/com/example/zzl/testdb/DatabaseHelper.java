package com.example.zzl.testdb;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zzl on 16/8/26.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "TestDB.db";

    public static final String TABLE_NAME = "PersonTable";
    public static final String TABLE_CHILD_NAME = "ChildTable";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("CREATE TABLE [" + TABLE_NAME + "] (");
        stringBuffer.append("[_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        stringBuffer.append("[name] TEXT ,");
        stringBuffer.append("[age] INTEGER,");
        stringBuffer.append("[info] TEXT)");

        StringBuffer stringchild = new StringBuffer();

        stringchild.append("CREATE TABLE [" + TABLE_CHILD_NAME + "] (");
        stringchild.append("[_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        stringchild.append("[name] TEXT ,");
        stringchild.append("[age] INTEGER,");
        stringchild.append("[sex] TEXT)");

        sqLiteDatabase.execSQL(stringBuffer.toString());
        sqLiteDatabase.execSQL(stringchild.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_CHILD_NAME);
        LogUtil.LogDebug(this.getClass(),"this is database upgrade!!");

        onCreate(sqLiteDatabase);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        LogUtil.LogDebug(this.getClass(),"this is database open!!!");
    }
}
