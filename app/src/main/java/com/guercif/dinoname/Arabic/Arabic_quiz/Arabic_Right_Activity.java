package com.guercif.dinoname.Arabic.Arabic_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import com.guercif.dinoname.R;

public class Arabic_Right_Activity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.right_activity);
        textView = findViewById(R.id.Right_answer);
        textView.setText("أحسنت الإجابة");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        MediaPlayer audio = MediaPlayer.create(this, R.raw.right);
        audio.start();
        thread.start();
    }
}