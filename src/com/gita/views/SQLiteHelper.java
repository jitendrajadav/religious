package com.gita.views;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

	private static SQLiteHelper instance= null;
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "GeetaDB.db";
	private static final String DICTIONARY_TABLE_NAME = "GeetaInfo";  
	private static final String DICTIONARY_TABLE_CREATE =  "CREATE TABLE IF NOT EXISTS " + DICTIONARY_TABLE_NAME + 
			" (" + "\"LineNo\" Integer, " +  "\"Adhyay\" TEXT ," + "\"ShlokNo\" Number ," +"\"Shlok\" TEXT ," + 
			"\"MBVersion\" TEXT ," + "\"Comment\" TEXT ," + "\"QURAN\" TEXT," + "\"KJVBilbe\" TEXT" +")";  

	
/*	private SQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
*/
	public static SQLiteHelper getInstance(Context context) 
	{
		if(instance == null)
		{
			instance = new SQLiteHelper(context);
		}
		return instance;
		// TODO Auto-generated constructor stub
	}
	
	private SQLiteHelper(Context context) 
	{  
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// TODO Auto-generated method stub
		db.execSQL(DICTIONARY_TABLE_CREATE);
	}

	public long insertData(ContentValues values) 
	{
		SQLiteDatabase db= this.getWritableDatabase();
		long value = db.insert(DICTIONARY_TABLE_NAME, null, values);
		return value;
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) 
	{
		// TODO Auto-generated method stub

	}

	public ArrayList<Todo> getData() 
	{
		ArrayList<Todo> todoList = new ArrayList<Todo>();
		// TODO Auto-generated method stub
		SQLiteDatabase db= this.getReadableDatabase();
		String selectQuery = "SELECT  * FROM " + DICTIONARY_TABLE_NAME;
		Cursor cursor = db.rawQuery(selectQuery, null);
		 // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	        	Todo todo = new Todo();
	        	todo.setLineNo(cursor.getInt(0));
	        	todo.setAdhyay(cursor.getString(1));
	        	todo.setShlokNo(cursor.getInt(2));
	        	todo.setShlok(cursor.getString(3));
	        	todo.setMBVersion(cursor.getString(4));
	        	todo.setComment(cursor.getString(5));
	        	todo.setQuran(cursor.getString(6));
	        	todo.setKJVBilbe(cursor.getString(7));
	            // Adding contact to list
	        	todoList.add(todo);
	        } while (cursor.moveToNext());
	    }
		return todoList;

	}
}
