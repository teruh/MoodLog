package me.zacl.moodlog.db;

import android.provider.BaseColumns;

public class MoodContract {
   private MoodContract() {}

   public static abstract class Mood implements BaseColumns {
      public static final String TABLE_NAME = "entries";
      public static final String COLUMN_NAME_RATING = "rating";
      public static final String COLUMN_NAME_NOTES = "notes";
   }
}
