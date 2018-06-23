/*
quiz activity for standart mode, recieve Question object, and returns Boolean
*/
package su.nosite.smth.quizapp.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import su.nosite.smth.waih.R;

public class QuizActivity extends AppCompatActivity {

    QuizSingletonQuestions instance = QuizSingletonQuestions.getInstance();
    Boolean isTrue;
    int number=0;

    SharedPreferences sharedPreferences;

    TextView questionText;
    Button trueButton;
    Button falseButton;
    Button cheatButton;
    private int RESULT_REQ_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_standart);

        /////////////////////////////////////////////////////////////
//        sharedPreferences  = getPreferences(MODE_PRIVATE);
//        QuizSingletonQuestions.getInstance().getList() = new Gson()
//        .fromJson(sharedPreferences.getString("q",""),Question.class);

        /////////////////////////////////////////////////////////////

        questionText = findViewById(R.id.QuestionText);
        trueButton = findViewById(R.id.buttonTrue);
        falseButton = findViewById(R.id.buttonFalse);
        cheatButton = findViewById(R.id.buttonCheat);

        /////////////////////////////////////////////////////////////

            questionText.setText(instance.getList().get(number).getQ());


        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(instance.getList().get(number).getTrue()){
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
                if(!instance.getList().get(number).getTrue()){
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
                if(instance.getList().get(number).getTrue()){
                    Toast.makeText(
                                QuizActivity.this,
                                "answer is true",
                                Toast.LENGTH_LONG)
                            .show();
                } else {
                    Toast.makeText(
                                QuizActivity.this,
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
        QuizSingletonAnswers.getInstance().answers.add(isTrue);
        if(number<instance.getList().size()-1) {
            //if (instance.getList().size() >= 2) { ++number; }
++number;
            questionText.setText(instance.getList().get(number).getQ());
        } else {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            //

            //
            startActivityForResult(intent, RESULT_REQ_CODE);
        }
    }
    public void onBackPressed() { }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_REQ_CODE) {
            finish();
        }
    }
}
