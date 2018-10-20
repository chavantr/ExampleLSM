/**
 * Copyright (C) 2013 MyWings Software Private Limited.
 */
package com.mywings.lovesms.Locally;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tatyabhau Chavan
 * @Created Dec 21, 2014
 */
public class MyDatabase extends SQLiteAssetHelper {

    public MyDatabase(Context context, String name, CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    public List<String> getQuates(String category) {
        List<String> lstQuotes = null;
        Cursor cursor = null;
        SQLiteDatabase db = getReadableDatabase();
        String[] where = {category.trim()};
        SQLiteQueryBuilder query = new SQLiteQueryBuilder();
        query.setTables("TblMalvaniSMS");
        cursor = query.query(db, null,
                "cat"
                        + "=?", where, null, null, null);
        if (null != cursor && cursor.getCount() > 0) {
            lstQuotes = new ArrayList<>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                lstQuotes.add(cursor.getString(cursor.getColumnIndex("sSuvichar1")));
                cursor.moveToNext();
            }
        }
        return lstQuotes;

    }
}
