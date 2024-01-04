package com.rrbofficial.contactmanager_sqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.rrbofficial.contactmanager_sqlite.R;
import com.rrbofficial.contactmanager_sqlite.util.Util;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }


    // we create our table

    /*
    Create table_name(id, name, phone_number);
    */


    @Override
    public void onCreate(SQLiteDatabase db) {
     // SQL -- Structured Query Language
        String CREATE_CONTACT_TABLE = "CREATE TABLE" + Util.TABLE_NAME + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NAME + " TEXT," + Util.KEY_PHONE_NUMBER + " TEXT" + ")";


        db.execSQL(CREATE_CONTACT_TABLE);  // Creating our table

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String DROP_TABLE = String.valueOf(R.string.db_drop);
    db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});
        // Create a table again

        onCreate(db);
    }




}
