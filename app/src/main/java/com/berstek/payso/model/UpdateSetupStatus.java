package com.berstek.payso.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by John on 11/19/2016.
 */

public class UpdateSetupStatus extends SQLiteOpenHelper {

    public UpdateSetupStatus(Context context) {
        super(context, "PAYSO_DATABASE", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SETUP_COMPLETE", 1);

        // updating row
        db.update("APP_SETTINGS", values, "MARKER" + " = ?",
                new String[] { String.valueOf("MARKER") });
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
