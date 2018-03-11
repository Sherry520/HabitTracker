package com.example.gyh.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by gyh on 2016/10/30.
 */

public class MedicineContract {

    public static abstract class MedicineEntry implements BaseColumns {
        public static final String TABLE_NAME = "medicine";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_MEDICINE_NAME = "name";
        public static final String COLUMN_MEDICINE_NUMBER ="number";
    }
}
