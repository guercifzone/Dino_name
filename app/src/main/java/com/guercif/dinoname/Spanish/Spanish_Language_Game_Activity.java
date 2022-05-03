package com.guercif.dinoname.Spanish;

import androidx.appcompat.app.AppCompatActivity;

import com.guercif.dinoname.Fransh.Fransh_Language_Game_Activity;
import com.guercif.dinoname.Fransh.Fransh_quiz.Fransh_Quiz_Activity;
import com.guercif.dinoname.R;
import com.guercif.dinoname.Spanish.Spanish_quiz.Spanish_Quiz_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Spanish_Language_Game_Activity extends AppCompatActivity {
    Button quiz, game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_data);
        quiz = findViewById(R.id.Quiz);
        game = findViewById(R.id.Puzzil);
        quiz.setText("EXAMEN");
        game.setText("PINTURA");
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Spanish_Language_Game_Activity.this, Spanish_Quiz_Activity.class);
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