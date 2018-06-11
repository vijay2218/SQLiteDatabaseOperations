package com.vijay.kataria.programmingworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "language_table";
    private static final String UID = "_id";
    private static final String NAME = "Languages";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
    private static final String DROP_TABLE = "DROP IF TABLE EXISTS "+TABLE_NAME;
    private Context context;
    public DatabaseHelper(Context context){
        super(context,TABLE_NAME,null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);
        }catch(SQLException e){
            Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try{
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch(SQLException e){
            Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,item);

        Log.d("Vijay","addData: Adding "+item+" to "+TABLE_NAME);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE "+NAME+" = '"+name+"'";
        Cursor data = db.rawQuery(query,null);
        //Log.d("iside dbh",name);
//        Log.d("iside dbh",data.getString());
        return data;
    }

    public void deleteName(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+TABLE_NAME+" WHERE "+NAME+" = '" +name+"'";
        Log.d("Vijay","Query = "+query);
        Log.d("Vijay","Deleting "+name+" from database");
        db.execSQL(query);
    }
}
