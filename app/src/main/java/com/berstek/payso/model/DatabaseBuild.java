package com.berstek.payso.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by John on 11/19/2016.
 */

public class DatabaseBuild extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PAYSO_DATABASE";

    private static final String TABLE_APPSETTINGS = "APP_SETTINGS";
    private static final String COL_MARKER = "MARKER";
    private static final String COL_CURRENCY = "CURRENCY";
    private static final String COL_COUNTRY = "COUNTRY";
    private static final String COL_SYMBOL = "SYMBOL";
    private static final String COL_ISO = "ISO";
    private static final String COL_CYCLE_TYPE = "CYCLE_TYPE";
    private static final String COL_CYCLE_START = "CYCLE_START";
    private static final String COL_BUDGET = "BUDGET";
    private static final String COL_SETUP_COMPLETE = "SETUP_COMPLETE";


    public DatabaseBuild(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(appSettingsSQL);
        db.execSQL(insertInitData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static final String appSettingsSQL = "create table " + TABLE_APPSETTINGS + "(" +
            COL_MARKER + " text primary key not null, " +
            COL_CURRENCY + " text, " +
            COL_COUNTRY + " text, " +
            COL_ISO + " text, " +
            COL_SYMBOL + " text, " +
            COL_CYCLE_TYPE + " text, " +
            COL_CYCLE_START + " text, " +
            COL_BUDGET + " double, " +
            COL_SETUP_COMPLETE + " integer)";

    private static final String insertInitData = "insert into " + TABLE_APPSETTINGS + " values ('" +
            "MARKER" + "','" +
            "" + "','" +
            "" + "','" +
            "" + "','" +
            "" + "','" +
            "" + "','" +
            "" + "','" +
            "" + "','" +
            "0" + "')";
}
