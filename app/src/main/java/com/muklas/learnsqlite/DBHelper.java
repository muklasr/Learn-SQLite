package com.muklas.learnsqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "dbname.db";
    private static final Integer DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "sqlite";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_ADDRESS = "address";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_PHONE + " TEXT NOT NULL, "
                + COLUMN_ADDRESS + " TEXT NOT NULL "
                + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insert(String name, String phone, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME + " VALUES("
                + "'" + name + "',"
                + "'" + phone + "',"
                + "'" + address + "'"
                + ")";
        db.execSQL(query);
        db.close();
    }

    public void update(String name, String phone, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET "
                + COLUMN_NAME + "='" + name + "', "
                + COLUMN_PHONE + "='" + phone + "', "
                + COLUMN_ADDRESS + "='" + address + "'"
                + ")";
        db.execSQL(query);
        db.close();
    }
}
