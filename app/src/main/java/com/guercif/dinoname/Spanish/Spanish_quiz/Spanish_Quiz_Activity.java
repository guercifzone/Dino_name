package com.guercif.dinoname.Spanish.Spanish_quiz;

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

public class Spanish_Quiz_Activity extends AppCompatActivity {
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
                add(new Question("¿Qué son los dinosaurios?", "B", "Un tipo de mamífero que solía vivir en el mar", "Los dinosaurios son una familia de arcosaurios", "Un tipo de ave de rapiña", "Microorganismos"));
                add(new Question("¿Por qué los dinosaurios eran tan grandes?", "C", "Porque no siguió una dieta", "Para protegerlo de la lluvia y los meteoros", "El enorme tamaño de los dinosaurios, incluido el enorme tamaño de la vegetación de la que se alimentaban los dinosaurios", "Para recorrer largas distancias en un poco tiempo"));
                add(new Question("¿Cuándo vivieron los dinosaurios?", "A", "Alrededor de 230 millones de años", "Alrededor de 5000 años", "Alrededor de 20 años", "Antes de AD"));
                add(new Question("¿Cómo evolucionaron los dinosaurios?", "D", "De la Atlántida oculta", "De las rocas duras", "De las aves", "Los primeros dinosaurios evolucionaron a partir de los arcosaurios"));
                add(new Question("¿Cómo son realmente los dinosaurios?", "C", "animal foca", "delfines", "prácticamente reptiles", "dragones legendarios"));
                add(new Question("¿Cómo criaban los dinosaurios a sus crías?", "A", "Los dinosaurios cuidaban a sus crías, con la capacidad de sobrevivir en sus crías", "Los dinosaurios sacrificaban a sus crías", "Ella la estaba amamantando y cuidando", "Los dinosaurios no crían niños"));
                add(new Question("¿Qué tan inteligentes eran los dinosaurios?", "B", "La comida proporcionada hizo que los dinosaurios fueran incapaces de cazar", "He alcanzado una etapa de inteligencia en la caza colectiva", "La presa era más inteligente que el depredador", "Los dinosaurios son criaturas estúpidas que no tienen métodos de caza colectiva"));
                add(new Question("¿Qué comían los dinosaurios?", "D", "organización mundial de la alimentación", "comer al azar", "dieta", "comía su propia especie, plantas, etc., según el tipo de dinosaurio"));
                add(new Question("¿Cómo cazan los dinosaurios a sus presas?", "C", "Pesca con caña", "francotiradores con armas", "caza masiva", "sobrepesca"));
                add(new Question("¿Dónde vivían los dinosaurios?", "A", "en todos los rincones de la tierra", "África", "Asia", "Europa"));

            }
        };
        loadQuestion();
    }
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