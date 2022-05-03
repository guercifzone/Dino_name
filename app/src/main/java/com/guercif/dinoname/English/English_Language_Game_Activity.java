package com.guercif.dinoname.English;

import androidx.appcompat.app.AppCompatActivity;

import com.guercif.dinoname.Arabic.Arabic_Language_Game_Activity;
import com.guercif.dinoname.Arabic.Arabic_quiz.Arabic_Quiz_Activity;
import com.guercif.dinoname.English.English_quiz.English_Quiz_Activity;
import com.guercif.dinoname.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class English_Language_Game_Activity extends AppCompatActivity {
    Button quiz, game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_data);
        quiz = findViewById(R.id.Quiz);
        game = findViewById(R.id.Puzzil);
        quiz.setText("QUIZ");
        game.setText("PAINT");
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(English_Language_Game_Activity.this, English_Quiz_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}