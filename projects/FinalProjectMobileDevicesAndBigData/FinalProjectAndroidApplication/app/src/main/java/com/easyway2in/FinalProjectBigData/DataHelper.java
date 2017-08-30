package com.easyway2in.mysqldbdemo;

/**
 * Created by rahul on 11/23/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by rahul on 11/19/2015.
 */
public class DataHelper extends SQLiteOpenHelper {

    public static final String Database_Name="utility";
    public static final String Table_Pro="appliances";
    public static final int Database_Version=1;
    public static final String Create_Pro="Create table if not exists "+Table_Pro+"(id integer primary key autoincrement, appliance text not null unique,powerconsumption text not null,start text not null,end text not null)";
    public static final String Delete_Pro="Drop table if  exists "+Table_Pro;

    public DataHelper(Context context){
        super(context,Database_Name,null,Database_Version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(Create_Pro);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL(Delete_Pro);
    }
    public void insertProvince(String appliance,String pc,String start,String end){
        SQLiteDatabase db=this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put("appliance", appliance);
            values.put("powerconsumption",pc);
            values.put("start", start);
            values.put("end", end);
            db.insert(Table_Pro, null, values);
            db.setTransactionSuccessful();
        }catch(Exception e)
        {e.printStackTrace();
        }
        finally {
            db.endTransaction();
            db.close();
        }
    }
    public ArrayList<String> getAllAppliances() {
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();
        try {
            String selectQuery = "select * from " + Table_Pro;
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.getCount() > 0) {
                while(cursor.moveToNext()) {
                    String appliance = cursor.getString(cursor.getColumnIndex("appliance"));
                    list.add(appliance);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            db.endTransaction();
            db.close();
        }
        return list;
    }

    /* public ArrayList<String> getStartEnd(String x){
         ArrayList<String> list2 = new ArrayList<String>();
         SQLiteDatabase db = this.getReadableDatabase();
         db.beginTransaction();
         try {
             String selectQuery = "select * from "+Table_Pro+" where appliance = ?";
             //where appliance "+"= "+"fdge
             Cursor cursor = db.rawQuery(selectQuery,new String[]{x});

             if (cursor.getCount() > 0) {
                 while(cursor.moveToNext()) {
                     String start = cursor.getString(cursor.getColumnIndex("start"));
                     String end = cursor.getString(cursor.getColumnIndex("end"));
                     list2.add(start);
                     list2.add(end);
                 }
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         finally{
             db.endTransaction();
             db.close();
         }
         return list2;
     }*/
    public ArrayList<Details1> getStartEnd(String x){
        ArrayList<Details1> list2 = new ArrayList<Details1>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();
        try {
            String selectQuery = "select * from "+Table_Pro+" where appliance = ?";
            //where appliance "+"= "+"fdge
            Cursor cursor = db.rawQuery(selectQuery,new String[]{x});
            Details1 temp=new Details1();
            if (cursor.getCount() > 0) {
                while(cursor.moveToNext()) {
                    String start = cursor.getString(cursor.getColumnIndex("start"));
                    String end = cursor.getString(cursor.getColumnIndex("end"));
                    String pc = cursor.getString(cursor.getColumnIndex("powerconsumption"));
                    temp.setDetails(x,pc, start, end);
                    list2.add(temp);

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            db.endTransaction();
            db.close();
        }
        return list2;
    }
}
