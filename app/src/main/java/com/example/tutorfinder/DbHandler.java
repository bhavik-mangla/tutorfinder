package com.example.tutorfinder;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE tutors ( Name TEXT,Class1 TEXT, Locality TEXT, PastResults TEXT,  Image1 TEXT, Image2 TEXT, Image3 TEXT,Subject TEXT,PhoneNumber TEXT, Address TEXT, TeachingExperience TEXT)";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"tutors"});
        onCreate(db);

    }
    public void delete(String id)
    {
        String[] args={id};
        getWritableDatabase().delete("tutors", "Name=?", args);
    }
    public  void addTutor(Tutors tutor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values  = new ContentValues();
        values.put("Name",tutor.getName());
        values.put("Class1",tutor.getClass1());
        values.put("Locality",tutor.getLocality());
        values.put("Subject",tutor.getSubject());
        values.put("Image1",tutor.getImage1());
        values.put("Image2",tutor.getImage2());
        values.put("Image3",tutor.getImage3());
        values.put("PastResults",tutor.getPastResults());
        values.put("PhoneNumber",tutor.getPhoneNumber());
        values.put("Address",tutor.getAddress());
        values.put("TeachingExperience",tutor.getTeachingExperience());



        long k = db.insert("tutors",null,values);
        Log.d("mytag", Long.toString(k));
        db.close();

    }

    public Cursor getTutor(String Locality, String Class1, String Subject) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Cursor> arList = new ArrayList<Cursor>();
        Cursor c = db.rawQuery("SELECT * FROM tutors WHERE Locality = '" + Locality + "' and Class1 = '" + Class1 + "'and Subject = '" + Subject + "'", null);

        return c;

    }

}
