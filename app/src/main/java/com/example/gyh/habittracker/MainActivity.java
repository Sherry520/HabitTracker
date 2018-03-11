package com.example.gyh.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gyh.habittracker.data.HabitDbHelper;
import com.example.gyh.habittracker.data.MedicineContract.MedicineEntry;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);

    }

    private Cursor displayMedicine(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection ={
                MedicineEntry._ID,
                MedicineEntry.COLUMN_MEDICINE_NAME,
                MedicineEntry.COLUMN_MEDICINE_NUMBER
        };
        Cursor cursor = db.query(
                MedicineEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
    private void insertMedicine(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MedicineEntry.COLUMN_MEDICINE_NAME,"阿姆西林");
        values.put(MedicineEntry.COLUMN_MEDICINE_NUMBER,3);
        long rowId = db.insert(MedicineEntry.TABLE_NAME,null,values);
    }
    private void updateMedicine(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MedicineEntry.COLUMN_MEDICINE_NUMBER,2);
        String selection = MedicineEntry._ID+" = 1";
        db.update(MedicineEntry.TABLE_NAME,values,selection,null);
    }
    private void deleteMedicine(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String selection = MedicineEntry.COLUMN_MEDICINE_NUMBER+" = 2";
        db.delete(MedicineEntry.TABLE_NAME,selection,null);
    }
    private void deleteDataBase(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.delete(MedicineEntry.TABLE_NAME,null,null);
    }
}
