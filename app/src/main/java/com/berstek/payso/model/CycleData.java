package com.berstek.payso.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.berstek.payso.utils.CycleUtils;

import static android.R.attr.country;

/**
 * Created by John on 11/20/2016.
 */

public class CycleData extends SQLiteOpenHelper{

    private double dailyTotalSpending = 0;
    private double totalSpending = 0;

    public double getEstimatedSavings() {
        return (totalBudget - totalSpending) - (dailyTotalSpending * getRemainingDays());
    }

    private int totalDays = 0;
    private String activeCycle = "", startDay = "";
    private double totalBudget = 0;
    private static final String DATABASE_NAME = "PAYSO_DATABASE";
    private String activeCycleQuery = "select * from cycles where status = 1";

    private SQLiteDatabase db;

    public CycleData(Context context) {
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();

        //fetch data of the active cycle in the database
        Cursor c = db.rawQuery(activeCycleQuery, null);
        if(c.moveToFirst()){
            do{
                activeCycle = c.getString(0);
                startDay = c.getString(3);
                totalDays = c.getInt(4);
                totalBudget = c.getDouble(6);
            }while(c.moveToNext());
        }
        c.close();
        Cursor d = db.rawQuery("select cost from CYCLE_" + activeCycle.replace("-", "_"), null);
        if(d.moveToFirst()){
            do{
                totalSpending += d.getDouble(0);
            }while(c.moveToNext());
        }
        d.close();
        db.close();
    }



    public double getTotalBudget() {
        return totalBudget;
    }

    public double getDailyBudget() {
        return (totalBudget - totalSpending) / getRemainingDays();
    }


    public double getDailyTotalSpending() {
        return dailyTotalSpending;
    }


    public int getRemainingDays() {
        return CycleUtils.getRemainingDays(startDay, CycleUtils.getCurrentDay());
    }

    public int getTotalDays() {
        return totalDays;
    }

    public double getTotalSpendings() {
        return totalSpending;
    }

    public String getActiveCycle() {
        return activeCycle;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
