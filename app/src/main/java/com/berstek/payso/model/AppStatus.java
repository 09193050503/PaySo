package com.berstek.payso.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by John on 11/19/2016.
 */

public class AppStatus extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PAYSO_DATABASE";

    public AppStatus(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT setup_complete from APP_SETTINGS ", null);
        if(c.moveToFirst()){
            do{
                status = c.getInt(0);
            }while(c.moveToNext());
        }
        c.close();
        db.close();
    }

    public int getStatus() {
        return status;
    }


    private int status = 0;

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
