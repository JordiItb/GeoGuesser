package cat.itb.geoguesser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView questionText;
    public TextView questionProgText;
    public ProgressBar progressBar;
    public Button aButton;
    public Button bButton;
    public Button cButton;
    public Button dButton;
    public Button hintButton;
    public int hintCont = 0;
    public int cont;
    public static int[] questionOrder = new int[10];

    static QuestionBank[] questions = {

            new QuestionBank(R.string.qt1, true, R.string.h1),
            new QuestionBank(R.string.qt2, true, R.string.h2),
            new QuestionBank(R.string.qt3, true, R.string.h3),
            new QuestionBank(R.string.qt4, true, R.string.h4),
            new QuestionBank(R.string.qt5, true, R.string.h5),
            new QuestionBank(R.string.qt6, true, R.string.h6),
            new QuestionBank(R.string.qt7, true, R.string.h7),
            new QuestionBank(R.string.qt8, true, R.string.h8),
            new QuestionBank(R.string.qt9, true, R.string.h9),
            new QuestionBank(R.string.qt10, true, R.string.h10),

    };

    static ButtonBank[] buttonA = {

            new ButtonBank(R.string.a1, false),
            new ButtonBank(R.string.a2, false),
            new ButtonBank(R.string.a3, false),
            new ButtonBank(R.string.a4, true),
            new ButtonBank(R.string.a5, true),
            new ButtonBank(R.string.a6, true),
            new ButtonBank(R.string.a7, false),
            new ButtonBank(R.string.a8, true),
            new ButtonBank(R.string.a9, true),
            new ButtonBank(R.string.a10, false),

    };

    static ButtonBank[] buttonB = {

            new ButtonBank(R.string.b1, true),
            new ButtonBank(R.string.b2, true),
            new ButtonBank(R.string.b3, false),
            new ButtonBank(R.string.b4, false),
            new ButtonBank(R.string.b5, false),
            new ButtonBank(R.string.b6, false),
            new ButtonBank(R.string.b7, false),
            new ButtonBank(R.string.b8, false),
            new ButtonBank(R.string.b9, false),
            new ButtonBank(R.string.b10, false),

    };

    static ButtonBank[] buttonC = {

            new ButtonBank(R.string.c1, false),
            new ButtonBank(R.string.c2, false),
            new ButtonBank(R.string.c3, true),
            new ButtonBank(R.string.c4, false),
            new ButtonBank(R.string.c5, false),
            new ButtonBank(R.string.c6, false),
            new ButtonBank(R.string.c7, true),
            new ButtonBank(R.string.c8, false),
            new ButtonBank(R.string.c9, false),
            new ButtonBank(R.string.c10, true),

    };

    static ButtonBank[] buttonD = {

            new ButtonBank(R.string.d1, false),
            new ButtonBank(R.string.d2, false),
            new ButtonBank(R.string.d3, false),
            new ButtonBank(R.string.d4, false),
            new ButtonBank(R.string.d5, false),
            new ButtonBank(R.string.d6, false),
            new ButtonBank(R.string.d7, false),
            new ButtonBank(R.string.d8, false),
            new ButtonBank(R.string.d9, false),
            new ButtonBank(R.string.d10, false)

    };

    static int questionNumber;

    static int[] progress = {
            R.string.q1,
            R.string.q2,
            R.string.q3,
            R.string.q4,
            R.string.q5,
            R.string.q6,
            R.string.q7,
            R.string.q8,
            R.string.q9,
            R.string.q10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        if(savedInstanceState != null){

            cont = savedInstanceState.getInt("cont");

        }else{

            cont = 1;

            for (int i = 0; i < 10; i++) {

                questionNumber = (int) Math.floor(Math.random() * 10);

                if(questionOrder[i] == questionNumber){

                    i--;

                }else {

                    questionOrder[i] = questionNumber;

                }
            }

        }

        questionText = findViewById(R.id.questionText);
        questionProgText = findViewById(R.id.questionProgress);
        progressBar = findViewById(R.id.progressBar);
        aButton = findViewById(R.id.aButton);
        bButton = findViewById(R.id.bButton);
        cButton = findViewById(R.id.cButton);
        dButton = findViewById(R.id.dButton);
        hintButton = findViewById(R.id.hintButton);

        aButton.setOnClickListener(this);
        bButton.setOnClickListener(this);
        cButton.setOnClickListener(this);
        dButton.setOnClickListener(this);
        hintButton.setOnClickListener(this);

        questionText.setText(questions[questionOrder[cont-1]].getQuestion());
        questionProgText.setText(progress[cont-1]);
        aButton.setText(buttonA[questionOrder[cont-1]].getAnswerText());
        bButton.setText(buttonB[questionOrder[cont-1]].getAnswerText());
        cButton.setText(buttonC[questionOrder[cont-1]].getAnswerText());
        dButton.setText(buttonD[questionOrder[cont-1]].getAnswerText());



    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.aButton:

                if(questions[questionOrder[cont-1]].isAnswer() == buttonA[questionOrder[cont-1]].isAnswer()){
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                increaseProg(cont);

                break;

            case R.id.bButton:

                if(questions[questionOrder[cont-1]].isAnswer() == buttonB[questionOrder[cont-1]].isAnswer()){
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    increaseProg(cont);
                }else{
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                    increaseProg(cont);
                }

                break;

            case R.id.cButton:

                if(questions[questionOrder[cont-1]].isAnswer() == buttonC[questionOrder[cont-1]].isAnswer()){
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    increaseProg(cont);
                }else{
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                    increaseProg(cont);
                }

                break;

            case R.id.dButton:

                if(questions[questionOrder[cont-1]].isAnswer() == buttonD[questionOrder[cont-1]].isAnswer()){
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    increaseProg(cont);
                }else{
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                    increaseProg(cont);
                }


                break;
            case R.id.hintButton:

                hintCont++;

                Toast.makeText(this, questions[questionOrder[cont-1]].getButton(), Toast.LENGTH_SHORT).show();

                if(hintCont == 3){
                    hintButton.setVisibility(View.INVISIBLE);
                }

                break;

        }

    }

    public void increaseProg(int cont){

        cont++;

        progressBar.setProgress(cont * 10);

        questionProgText.setText(progress[cont-1]);

        questionText.setText(questions[questionOrder[cont-1]].getQuestion());

        aButton.setText(buttonA[questionOrder[cont-1]].getAnswerText());
        bButton.setText(buttonB[questionOrder[cont-1]].getAnswerText());
        cButton.setText(buttonC[questionOrder[cont-1]].getAnswerText());
        dButton.setText(buttonD[questionOrder[cont-1]].getAnswerText());


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {

        outState.putInt("cont", cont);

    }
}