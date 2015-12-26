package com.example.zahid.brtc.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by ZAHID on 11/23/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "infoManager";

    // Contacts table name
    private static final String TABLE_Info = "info";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_VEHICLEID = "vehicleId";

    private static final String KEY_TIRE = "tire";
    private static final String KEY_GEARBOX = "gearBox";
    private static final String KEY_MOBIL = "mobil";
    private static final String KEY_OIL = "oil";
    private static final String KEY_ENGINE = "engine";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_Info + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_VEHICLEID + " TEXT," + KEY_TIRE + " TEXT," + KEY_GEARBOX + " TEXT," +
                KEY_MOBIL + " TEXT," + KEY_OIL + " TEXT,"
                + KEY_ENGINE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Info);

        // Create tables again
        onCreate(db);

    }

    public void addInfo(Helper helper) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_VEHICLEID, helper.getVehicleNo());
        values.put(KEY_TIRE, helper.getTire());
        values.put(KEY_GEARBOX, helper.getGearBox());
        values.put(KEY_MOBIL, helper.getMobil());
        values.put(KEY_OIL, helper.getOil());
        values.put(KEY_ENGINE, helper.getEngine());

        // Inserting Row
        db.insert(TABLE_Info, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public ArrayList[] getInfo() {
        ArrayList<String> vehicleNo = new ArrayList<>();
        ArrayList<String> vehicleIds = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + KEY_ID + ", " + KEY_VEHICLEID + " FROM " + TABLE_Info + " WHERE 1";
        Cursor c = db.rawQuery(query, null);

        c.moveToFirst();

        //  Log.i(TAG, String.valueOf(c.getCount()));

        for (int i = 0; i < c.getCount(); i++) {
            c.moveToPosition(i);
            if (c.getString(c.getColumnIndex(KEY_ID)) != null && c.getString(c.getColumnIndex(KEY_VEHICLEID)) != null) {
                //Log.i(TAG, c.getString(c.getColumnIndex(COLUMN_NAME)));
                vehicleNo.add(c.getString(c.getColumnIndex(KEY_VEHICLEID)));
                vehicleIds.add(c.getString(c.getColumnIndex(KEY_ID)));
            }
        }

        db.close();
        return new ArrayList[]{vehicleNo, vehicleIds};
    }


    public String[] getVehicleDetails(String vehicleNo, int _id) {
        String[] vehicleDetails = new String[7];
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_Info + " WHERE " +
                KEY_ID + "=\"" + _id + "\" AND " + KEY_VEHICLEID + "=\"" + vehicleNo + "\";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if (c.getCount() == 1) {
            if (c.getString(c.getColumnIndex(KEY_VEHICLEID)) != null &&
                    c.getString(c.getColumnIndex(KEY_TIRE)) != null &&
                    c.getString(c.getColumnIndex(KEY_GEARBOX)) != null &&
                    c.getString(c.getColumnIndex(KEY_ENGINE)) != null &&
                    c.getString(c.getColumnIndex(KEY_MOBIL)) != null &&
                    c.getString(c.getColumnIndex(KEY_OIL)) != null) {

                vehicleDetails[0] = c.getString(c.getColumnIndex(KEY_VEHICLEID));
                vehicleDetails[1] = c.getString(c.getColumnIndex(KEY_TIRE));
                vehicleDetails[2] = c.getString(c.getColumnIndex(KEY_GEARBOX));
                vehicleDetails[3] = c.getString(c.getColumnIndex(KEY_ENGINE));
                vehicleDetails[4] = c.getString(c.getColumnIndex(KEY_MOBIL));
                vehicleDetails[5] = c.getString(c.getColumnIndex(KEY_OIL));
                vehicleDetails[6] = c.getString(c.getColumnIndex(KEY_ID));

            }
        }
        db.close();
        return vehicleDetails;
    }

    public void delete(String vehicleNo, int _id) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM " + TABLE_Info + " WHERE " +
                KEY_ID + "=\"" + _id + "\" AND " + KEY_VEHICLEID + "=\"" + vehicleNo + "\";";
        db.execSQL(query);
        db.close();

    }

}