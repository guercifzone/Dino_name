package com.guercif.dinoname.English.English_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.guercif.dinoname.Adapter.Question;
import com.guercif.dinoname.Arabic.Arabic_quiz.Arabic_Right_Activity;
import com.guercif.dinoname.Arabic.Arabic_quiz.Arabic_Score_Activity;
import com.guercif.dinoname.Arabic.Arabic_quiz.Arabic_Wrong_Activity;
import com.guercif.dinoname.R;

import java.util.ArrayList;
import java.util.List;

public class English_Quiz_Activity extends AppCompatActivity {
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
        questions = new ArrayList<Question>() {
            {
                add(new Question("What are dinosaurs?", "B", "A type of mammal that used to live in the sea", "Dinosaurs are a family of archosaurs", "A type of bird of prey", "Microorganisms"));
                add(new Question("Why were dinosaurs so big?", "C", "Because she didn't follow a diet", "To protect it from rain and meteors", "The huge size of the dinosaurs, including the huge size of the vegetation that the dinosaurs ate on", "To go long distances in a short time"));
                add(new Question("When did dinosaurs live?", "A", "About 230 million years", "About 5,000 years", "about 20 years", "Before AD"));
                add(new Question("How did dinosaurs evolve?", "D", "From the hidden Atlantis", "of hard rocks", "of birds", "The first dinosaurs evolved from archosaurs"));
                add(new Question("What do dinosaurs really look like?", "C", "seal animal", "Dolphins", "Pretty much reptile", "legendary dragons"));
                add(new Question("How did dinosaurs raise their young?", "A", "Dinosaurs took care of their young, with the ability to survive in their young", "Dinosaurs sacrificed their young", "She was nursing and taking care of her", "Dinosaurs do not raise children"));
                add(new Question("How smart were dinosaurs?", "B", "Provided food made dinosaurs unable to hunt", "I have reached a stage of intelligence in collective hunting", "The prey was smarter than the predator", "Dinosaurs are stupid creatures that have no collective hunting methods"));
                add(new Question("What did dinosaurs eat?", "D", "world food organization", "random eating", "diet", "It ate its own species, plants, etc., according to the type of dinosaur"));
                add(new Question("How do dinosaurs hunt their prey?", "C", "Angling", "sniping with guns", "by mass hunting", "Overfishing"));
                add(new Question("Where did the dinosaurs live?", "A", "across all corners of the earth", "Africa", "Asia", "Europe"));

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