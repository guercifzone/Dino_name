package com.guercif.dinoname.Fransh.Fransh_quiz;

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

public class Fransh_Quiz_Activity extends AppCompatActivity {
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
                add(new Question("Que sont les dinosaures ?", "B", "Un type de mammifère qui vivait dans la mer", "Les dinosaures sont une famille d'archosaures", "Un type d'oiseau de proie", "Micro-organismes"));
                add(new Question("Pourquoi les dinosaures étaient-ils si gros ?", "C", "Parce qu'elle n'a pas suivi de régime", "To protect it from rain and meteors", "The huge size of the dinosaurs, including the huge size of the vegetation that the dinosaurs ate on", "To go long distances in a short time"));
                add(new Question("Quand vivaient les dinosaures ?", "A", "Environ 230 millions d'années","Environ 5 000 ans", "environ 20 ans", "Avant AD" ));
                add(new Question("Comment les dinosaures ont-ils évolué ?", "D", "De l'Atlantide cachée","de roches dures", "d'oiseaux", "Les premiers dinosaures ont évolué à partir d'archosaures"));
                add(new Question("A quoi ressemblent vraiment les dinosaures ?", "C", "phoque","Dauphins", "Assez de reptiles", "dragons légendaires"));
                add(new Question("Comment les dinosaures élevaient-ils leurs petits ?", "A", "Les dinosaures ont pris soin de leurs petits"," avec la capacité de survivre dans leurs petits ", " Les dinosaures ont sacrifié leurs petits ", " Elle l'allaitait et prenait soin d'elle ", " Les dinosaures n'élèvent pas d'enfants "));
                add(new Question("À quel point les dinosaures étaient-ils intelligents ?", "B", "La nourriture fournie a rendu les dinosaures incapables de chasser","J'ai atteint un stade d'intelligence dans la chasse collective", "La proie était plus intelligente que le prédateur", "Les dinosaures sont des créatures stupides qui n'ont pas de méthodes de chasse collectives"));
                add(new Question("Que mangeaient les dinosaures ?", "D", "organisation mondiale de l'alimentation", "J'ai atteint un stade d'intelligence dans la chasse collective", "La proie était plus intelligente que le prédateur", "Les dinosaures sont des créatures stupides qui n'ont pas de méthodes de chasse collectives"));
                add(new Question("Comment les dinosaures chassent-ils leurs proies ?", "C", "Pêche à la ligne","tirs embusqués avec des fusils", "par chasse massive", "surpêche" ));
                add(new Question("Où vivaient les dinosaures ?", "A", "à tous les coins de la terre","Afrique", "Asie", "Europe" ));

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