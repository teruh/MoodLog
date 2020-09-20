package me.zacl.moodlog.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import me.zacl.moodlog.R;
import me.zacl.moodlog.db.MoodContract;
import me.zacl.moodlog.db.MoodDatabaseHelper;

public class AddMoodActivity extends AppCompatActivity {

   private SeekBar  rateMoodSeekbar;
   private EditText notesEditText;
   private Button   saveButton;

   private SQLiteDatabase database;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_add_mood);

      MoodDatabaseHelper databaseHelper = new MoodDatabaseHelper(this);
      database = databaseHelper.getWritableDatabase();

      rateMoodSeekbar = findViewById(R.id.moodRatingSeekbar);
      notesEditText = findViewById(R.id.notesEditText);
      saveButton = findViewById(R.id.saveButton);

      saveButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            new SaveMoodTask().execute((Void[]) null);
         }
      });
   }

   private class SaveMoodTask extends AsyncTask<Void, Void, Void> {

      @Override
      protected Void doInBackground(Void... voids) {
         saveMoodEntry();
         return null;
      }

      @Override
      protected void onPostExecute(Void result) {
         finish(); // return to the previous Activity
      }

      private void saveMoodEntry() {
         ContentValues contentValues = new ContentValues();

         contentValues.put(MoodContract.Mood.COLUMN_NAME_RATING, rateMoodSeekbar.getProgress());
         contentValues.put(MoodContract.Mood.COLUMN_NAME_NOTES, notesEditText.getText().toString());

         database.insert(MoodContract.Mood.TABLE_NAME, null, contentValues);
      }
   }
}