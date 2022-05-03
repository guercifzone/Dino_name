package com.guercif.dinoname.Arabic.Arabic_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.guercif.dinoname.Adapter.Question;
import com.guercif.dinoname.R;

import java.util.ArrayList;
import java.util.List;

public class Arabic_Quiz_Activity extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView lblQuestion,lblStatus,lblScore;
    RadioButton optionA,optionB,optionC,optionD;
    Button confirm;
    String rightAnswer;
    String Answer;
    List<Question> questions;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_desplay_activity);
        lblQuestion = findViewById(R.id.txtquestion);
        lblScore = findViewById(R.id.txtScore);
        lblStatus =findViewById(R.id.txtStatus);
        confirm = findViewById(R.id.confirm);
        optionA = findViewById(R.id.questionA);
        optionB = findViewById(R.id.questionB);
        optionC = findViewById(R.id.questionC);
        optionD = findViewById(R.id.questionD);
        score = 0;
        radioGroup = findViewById(R.id.radiogroup);
        ViewCompat.setLayoutDirection(findViewById(R.id.radiogroup),ViewCompat.LAYOUT_DIRECTION_RTL);
        questions = new ArrayList<Question>() {
            {
                add(new Question("ما هي الديناصورات ؟", "B", "نوع من التدييات التي كانت تعيش  في البحر", "الديناصورات هي سلالة الأركوصورات", "نوع من الطيور الجارحة", "كائنات مجهرية"));
                add(new Question("لماذا كانت الديناصورات كبيرة جدا؟", "C", "لانها لم تكن تتبع حمية غذائية", "لحمايتها من الامطار والنيازك", "حجم الديناصورات الهائل ومنها الحجم الهائل للغطاء النباتي الذي كانت تتغذى عليه الديناصورات", "لكي تقطع مسافات طويلة في وقت وجيز"));
                add(new Question("متى كانت تعيش الديناصورات ؟", "A", "حوالي 230 مليون سنة", "حوالي 5الاف سنة", "حوالي 20 سنة", "قبل التاريخ  الميلادي"));
                add(new Question("كيف تتطورت الديناصورات ؟", "D", "من اطلنطس  الخفية", "من الصخور الجامدة", "من العصافير", "الديناصورات الاولى تطورت  من الاركوصور"));
                add(new Question("ماذا تشبه الديناصورات حقا ؟", "C", "الفقمة ", "الدلافين", "الزواحف الى حد كبير", "التنانين  الاسطورية"));
                add(new Question("كيف قامت الديناصورات بتربية صغارها ؟", "A", "الديناصورات كانت تعتني بصغارها مع وجود قدرات للبقاء في صغارها", "الديناصورات كانت تضحي بصغارها", "كانت تقوم بارضاعها والعناية بها", "الديناصورات لا تربي الاطفال"));
                add(new Question("كيف كانت الديناصورات ذكية ؟", "B", "وفرت الغذاء جعلة الديناصورات غير قادرة على الصيد", "وصلت الى  مرحلة من الذكاء في الصيد الجماعي", "الفريسة كانت اذكى من المفترس", "الديناصورات كائنات غبية ليس لديها طرق صيد جماعية"));
                add(new Question("ماذا كانت تأكل الديناصورات ؟", "D", "منظمة الغذاء العالمية", "الاكل  العشوائي", "الحمية الغذائية", "كانت تاكل بني جنسها والنباتات وغيرها حسب نوع الديناصور"));
                add(new Question("كيف تصطاد الديناصورات فرائسها ؟", "C", "الصيد بالصنارة", "القنص بالبنادق", "عبر الصيد  الجماعي", "الصيد الجائر"));
                add(new Question("أين كانت تعيش الديناصورات ؟", "A", "عبر جميع اقطار الارض", "افريقيا", "اسيا", "اوروبا"));

            }
        };
loadQuestion();

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        loadQuestion();
    }

    private void loadQuestion() {
        if (questions.size() > 0) {
            Question q = questions.remove(0);
            lblQuestion.setText(q.getQuestion());
            List<String> answers = q.getAnswers();

            optionA.setText(answers.get(0));
            optionB.setText(answers.get(1));
            optionC.setText(answers.get(2));
            optionD.setText(answers.get(3));

            rightAnswer = q.getRightAnswer();

        } else {
            Intent intent = new Intent(this, Arabic_Score_Activity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }

    public void loadAnswer(View v) {
 int op  = radioGroup.getCheckedRadioButtonId();
 switch (op){
     case R.id.questionA:
         Answer = "A";
         break;
     case R.id.questionB:
         Answer = "B";
         break;
     case R.id.questionC:
         Answer = "C";
         break;
     case R.id.questionD:
         Answer = "D";
         break;
     default:
         return;
 }
 radioGroup.clearCheck();
 this.startActivity(isRightOrWrong(Answer));
    }

    private Intent isRightOrWrong(String Answer){
        Intent screen;
        if(Answer.equals(rightAnswer)) {
            this.score += 1;
            screen = new Intent(this, Arabic_Right_Activity.class);

        }else {
            screen = new Intent(this, Arabic_Wrong_Activity.class);
        }

        return screen;
    }

}
