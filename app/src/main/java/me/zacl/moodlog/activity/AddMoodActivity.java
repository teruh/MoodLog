package me.zacl.moodlog.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import me.zacl.moodlog.R;

public class AddMoodActivity extends AppCompatActivity {

   private SeekBar  rateMoodSeekbar;
   private EditText notesEditText;
   private Button   saveButton;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_add_mood);

      rateMoodSeekbar = findViewById(R.id.moodRatingSeekbar);
      notesEditText = findViewById(R.id.notesEditText);
      saveButton = findViewById(R.id.saveButton);
   }
}