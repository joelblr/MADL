package com.example.medicinereminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBaseConn extends SQLiteOpenHelper {

    public DataBaseConn(Context context) {
        super(context, "Medicinedb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table medDB(MedName Text,MedDate TEXT,MedTime TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean insertvalues(String medname, String meddate, String medtime) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MedName", medname);
        contentValues.put("MedDate", meddate);
        contentValues.put("MedTime", medtime);
        long res = database.insert("MDTable", null, contentValues);
        if (res == -1)
            return false;
        return true;
    }

    public Cursor FetchData(String date,String time) {

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database
            .rawQuery("Select * from medDB where MedDate="+date+" AND MedTime="+time,null);
        return c;
    }
}

/*
    Project Tab->res->values->String.xml (Spinner values)

    <resources>
    <string name="app_name">Medicine</string>
    <string-array name="timeoftheday">
    <item> Morning </item>
    <item> Afternoon </item>
    <item> Evening </item>
    <item> Night </item>
    </string-array>
    </resources>

*/