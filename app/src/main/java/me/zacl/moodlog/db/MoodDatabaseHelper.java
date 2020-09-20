package me.zacl.moodlog.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class MoodDatabaseHelper extends SQLiteOpenHelper {
   private static final String TEXT_TYPE = " TEXT";
   private static final String INT_TYPE  = " INT";
   private static final String COMMA_SEP = ",";

   public static final int    DATABASE_VERSION = 1;
   public static final String DATABASE_NAME    = "MoodLogs";

   // SQL command to create database
   private static final String SQL_CREATE_ENTRIES =
       "CREATE TABLE " + MoodContract.Mood.TABLE_NAME + " (" +
           MoodContract.Mood._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
           MoodContract.Mood.COLUMN_NAME_RATING + INT_TYPE + COMMA_SEP +
           MoodContract.Mood.COLUMN_NAME_NOTES + TEXT_TYPE + " );";

   // SQL command to delete database
   private static final String SQL_DELETE_ENTRIES =
       "DROP TABLE IF EXISTS " + MoodContract.Mood.TABLE_NAME;

   public MoodDatabaseHelper(Context context) {
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
      db.execSQL(SQL_CREATE_ENTRIES);
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL(SQL_DELETE_ENTRIES);
      onCreate(db);
   }

   public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      onUpgrade(db, oldVersion, newVersion);
   }
}
