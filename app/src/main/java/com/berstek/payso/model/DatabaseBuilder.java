package com.berstek.payso.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.berstek.payso.staticData.AppVersion;

/**
 * Created by John on 11/19/2016.
 */

public class DatabaseBuilder extends SQLiteOpenHelper {

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
    private static final String COL_SETUP_STATUS = "SETUP_STATUS";

    private static final String TABLE_CYCLES = "CYCLES";

    private static final String COL_START = "START";
    private static final String COL_DAYS = "DAYS";
    private static final String COL_STATUS = "STATUS";
    //private static final String COL_BUDGET = "BUDGET";
    //private static final String COL_CYCLE_TYPE = "CYCLE_TYPE";
    private static final String COL_END = "END";

    public DatabaseBuilder(Context context) {
        super(context, DATABASE_NAME, null, AppVersion.getVersion());
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createAppSettingsTable);
        db.execSQL(insertInitSettingsData);
        db.execSQL(createCyclesTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static final String createAppSettingsTable = "create table " + TABLE_APPSETTINGS + "(" +
            COL_MARKER + " text primary key not null, " +
            COL_CURRENCY + " text, " +
            COL_COUNTRY + " text, " +
            COL_ISO + " text, " +
            COL_SYMBOL + " text, " +
            COL_CYCLE_TYPE + " text, " +
            COL_CYCLE_START + " text, " +
            COL_BUDGET + " double, " +
            COL_SETUP_STATUS + " integer)";

    private static final String insertInitSettingsData = "insert into " + TABLE_APPSETTINGS + " values ('" +
            "MARKER" + "','" +
            "" + "','" +
            "" + "','" +
            "" + "','" +
            "" + "','" +
            "" + "','" +
            "" + "','" +
            "0" + "','" +
            "0" + "')";

    private static final String createCyclesTable = "create table " + TABLE_CYCLES + " (" +
            COL_START + " date, " +
            COL_END + " date, " +
            COL_CYCLE_TYPE + " text, " +
            COL_DAYS + " integer, " +
            COL_STATUS + " integer, " +
            COL_BUDGET + " double)";
}
