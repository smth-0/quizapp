

package su.nosite.smth.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import su.nosite.smth.waih.R;

public class QuizActivity extends AppCompatActivity {

    Intent intent = getIntent();

    private Boolean isStandart;
    private int number;
    private Boolean isQuestionTrue;
    private Boolean isNoQuestions;

    private TextView questionText;
    private Button trueButton;
    private Button falseButton;
    private Button cheatButton;
    private TextView progressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        isStandart = intent.getExtras().getBoolean("isStandart");
        number  = intent.getExtras().getInt("i");
        isQuestionTrue = QuizSingletonStandartMode.getInstance().questionList.get(number).getTrue();
        isNoQuestions = intent.getExtras().getBoolean("isNoQuestion");


        questionText = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.buttonTrue);
        falseButton = findViewById(R.id.buttonFalse);
        cheatButton = findViewById(R.id.buttonCheatSkip);
        progressText = findViewById(R.id.progressTextView);

        progressText.setText(number+"/"+ QuizSingletonStandartMode.getInstance().questionList.size());

        if(!isNoQuestions) {
            final String question = intent.getExtras().getString("keyNumber");
            questionText.setText(question);
            changeClickableOfButtons(true);
        } else {
            questionText.setText("sorry, we have a problems. report us with code 4 please.");
            changeClickableOfButtons(false);
        }

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(isStandart){
                   if(isQuestionTrue) {
                       setAnswer(true);
                   } else {
                       setAnswer(false);
                   }
               }
                //add custom show
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isStandart){
                    if(!isQuestionTrue) {
                        setAnswer(true);
                    } else {
                        setAnswer(false);
                    }
                }
                //add custom show
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s;
                if(isQuestionTrue){
                    s="true";
                }
                else{
                    s="false";
                }
                Toast.makeText(getApplicationContext(),"answer is "+s,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setAnswer(Boolean b){
        AnswersStandartMode.getInstance().answers.add(b);
    }
    private void changeClickableOfButtons(Boolean isTurnOn){
        if(isTurnOn) {
            trueButton.setVisibility(View.VISIBLE);//visible
            cheatButton.setVisibility(View.VISIBLE);//visible
            falseButton.setVisibility(View.VISIBLE);//visible
        } else {
            trueButton.setVisibility(View.INVISIBLE);//invisible
            cheatButton.setVisibility(View.INVISIBLE);//invisible
            falseButton.setVisibility(View.INVISIBLE);//invisible
        }
    }
}
