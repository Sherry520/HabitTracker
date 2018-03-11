package com.example.gyh.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static com.example.gyh.habittracker.data.MedicineContract.MedicineEntry;

/**
 * Created by gyh on 2016/10/30.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habit.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_MEDICINE_TABLE = "CREATE TABLE "+MedicineEntry.TABLE_NAME
                +"("+ MedicineEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                MedicineEntry.COLUMN_MEDICINE_NAME+" TEXT NOT NULL,"+
                MedicineEntry.COLUMN_MEDICINE_NUMBER+"TEXT NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_MEDICINE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
