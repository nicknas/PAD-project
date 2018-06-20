package com.booknow.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BookNow.db";

    public UserDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UserContract.UserEntry.LOGIN + " TEXT NOT NULL UNIQUE,"
                + UserContract.UserEntry.TELEFONO + " INTEGER,"
                + UserContract.UserEntry.PASSWORD + " TEXT NOT NULL,"
                + UserContract.UserEntry.EMAIL + " TEXT NOT NULL UNIQUE" + " )");

        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.LOGIN, "nick");
        values.put(UserContract.UserEntry.TELEFONO, 648182926);
        values.put(UserContract.UserEntry.PASSWORD, "nick");
        values.put(UserContract.UserEntry.EMAIL, "nalcaine@ucm.es");
        db.insert(UserContract.UserEntry.TABLE_NAME, null, values);
    }

    public User getUserByLogin(String login){
       User u = null;
       Cursor c = getReadableDatabase().query(UserContract.UserEntry.TABLE_NAME, null, UserContract.UserEntry.LOGIN + " LIKE ?", new String[]{login}, null, null, null);
       if (c.getCount() > 0){
           c.moveToFirst();
           u = new User(c.getInt(c.getColumnIndex(UserContract.UserEntry._ID)), c.getString(c.getColumnIndex(UserContract.UserEntry.LOGIN)),
                   c.getInt(c.getColumnIndex(UserContract.UserEntry.TELEFONO)), c.getString(c.getColumnIndex(UserContract.UserEntry.PASSWORD)),
                   c.getString(c.getColumnIndex(UserContract.UserEntry.EMAIL)));
       }
       if (c != null && !c.isClosed()){
           c.close();
       }
       return u;
    }

    public boolean isUserLogged(String login, String password){
        Cursor c = getReadableDatabase().query(UserContract.UserEntry.TABLE_NAME, null, UserContract.UserEntry.LOGIN + " LIKE ?" + " AND " + UserContract.UserEntry.PASSWORD + " LIKE ?", new String[]{login, password}, null, null, null);
        if (c.getCount() == 1){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
