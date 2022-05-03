package com.guercif.dinoname.Fransh.Fransh_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.guercif.dinoname.MainActivity;
import com.guercif.dinoname.R;

public class Fransh_Score_Activity extends AppCompatActivity {
    TextView TxtScore;
    TextView TxtStatus;
    MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);
        TxtScore = findViewById(R.id.txtScore);
        TxtStatus = findViewById(R.id.txtStatus);
        Intent intent = getIntent();
        String scores = String.valueOf(intent.getIntExtra("score", 0));

        TxtScore.setText(scores);
        TxtStatus.setText(SetStatus(scores));
        audio.start();
    }
    private String SetStatus(String scores) {
        int score = Integer.parseInt(scores);
        if (score >= 8) {
            audio = MediaPlayer.create(this, R.raw.high_score);
            return "Tu as fait un excellent travail";
        }
        if (score >= 5) {
            audio = MediaPlayer.create(this, R.raw.medium_score);
            return "travail moyen continué";
        }
        audio = MediaPlayer.create(this, R.raw.low_score);
        return "Fais plus d'efforts la prochaine fois";
    }
    public void goToHome(View v){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
        finish();
    }
}