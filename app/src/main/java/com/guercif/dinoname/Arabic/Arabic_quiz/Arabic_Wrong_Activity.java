package com.guercif.dinoname.Arabic.Arabic_quiz;

import androidx.appcompat.app.AppCompatActivity;
import com.guercif.dinoname.R;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class Arabic_Wrong_Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wrong_activity);
        textView = findViewById(R.id.Wrong_answer);
        textView.setText("الإجابة خاطئة");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        MediaPlayer audio = MediaPlayer.create(this, R.raw.wrong);
        audio.start();
        thread.start();
    }
}