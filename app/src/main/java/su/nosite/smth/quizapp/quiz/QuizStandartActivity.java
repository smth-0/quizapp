/*
quiz activity for standart mode, recieve Question object, and returns Boolean
*/
package su.nosite.smth.quizapp.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import su.nosite.smth.quizapp.Question;
import su.nosite.smth.waih.R;

public class QuizStandartActivity extends AppCompatActivity {

    QuizSingletonStandartMode instance = QuizSingletonStandartMode.getInstance();
    Boolean isTrue;
    int number=0;


    TextView questionText;
    Button trueButton;
    Button falseButton;
    Button cheatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_standart);

        /////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////

        questionText = findViewById(R.id.QuestionText);
        trueButton = findViewById(R.id.buttonTrue);
        falseButton = findViewById(R.id.buttonFalse);
        cheatButton = findViewById(R.id.buttonCheat);

        /////////////////////////////////////////////////////////////

        questionText.setText(instance.questionList.get(number).getQ());


        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(instance.questionList.get(number).getTrue()){
                    isTrue = true;
                } else {
                    isTrue = false;
                }
                nextQuestion();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!instance.questionList.get(number).getTrue()){
                    isTrue = true;
                } else {
                    isTrue = false;
                }
                nextQuestion();
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(instance.questionList.get(number).getTrue()){
                    Toast.makeText(
                                QuizStandartActivity.this,
                                "answer is true",
                                Toast.LENGTH_LONG)
                            .show();
                } else {
                    Toast.makeText(
                                QuizStandartActivity.this,
                                "answer is false",
                                Toast.LENGTH_LONG)
                            .show();
                }
                isTrue=false;
                nextQuestion();
            }
        });

    }

    private void nextQuestion(){
        AnswersStandartMode.getInstance().answers.add(isTrue);
        if(number<instance.questionList.size()-1) {
            //if (instance.questionList.size() >= 2) { ++number; }
++number;
            questionText.setText(instance.questionList.get(number).getQ());
        } else {
            Intent intent = new Intent(QuizStandartActivity.this, ResultActivity.class);
            //

            //
            startActivity(intent);
        }
    }
    public void onBackPressed() { }
}
