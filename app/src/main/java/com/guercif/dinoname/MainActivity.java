package com.guercif.dinoname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.guercif.dinoname.Arabic.Arabic_Language_Game_Activity;
import com.guercif.dinoname.English.English_Language_Game_Activity;
import com.guercif.dinoname.Fransh.Fransh_Language_Game_Activity;
import com.guercif.dinoname.Spanish.Spanish_Language_Game_Activity;

public class MainActivity extends AppCompatActivity {
private ImageButton arabic_leng,fransh_leng,spanish_leng,english_leng;
   Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arabic_leng  =  findViewById(R.id.arabic);
        fransh_leng  =  findViewById(R.id.fransh);
        spanish_leng =  findViewById(R.id.spanish);
        english_leng =  findViewById(R.id.english);

arabic_leng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(1000);
                            finish();
                        }catch (Exception x){
                            x.printStackTrace();
                        }finally {
                            Intent intent = new Intent(MainActivity.this, Arabic_Language_Game_Activity.class);
                            startActivity(intent);
                        }
                    }
                };thread.start();
            }
        });
fransh_leng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(1000);
                            finish();
                        }catch (Exception x){
                            x.printStackTrace();
                        }finally {
                            Intent intent = new Intent(MainActivity.this, Fransh_Language_Game_Activity.class);
                            startActivity(intent);
                        }
                    }
                };thread.start();
            }
        });
spanish_leng.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                    finish();
                }catch (Exception x){
                    x.printStackTrace();
                }finally {
                    Intent intent = new Intent(MainActivity.this, Spanish_Language_Game_Activity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
});
english_leng.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                    finish();
                }catch (Exception x){
                    x.printStackTrace();
                }finally {
                    Intent intent = new Intent(MainActivity.this, English_Language_Game_Activity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
});


    }

    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}