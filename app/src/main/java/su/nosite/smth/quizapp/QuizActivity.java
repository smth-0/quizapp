package su.nosite.smth.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import su.nosite.smth.waih.R;

public class QuizActivity extends AppCompatActivity {

    Intent intent;

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
    protected void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        intent = getIntent();
        isStandart = intent.getExtras().getBoolean("isStandart");
        number  = intent.getExtras().getInt("i");

        isNoQuestions = intent.getExtras().getBoolean("isNoQuestion");

        questionText = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.buttonTrue);
        falseButton = findViewById(R.id.buttonFalse);
        cheatButton = findViewById(R.id.buttonCheatSkip);
        progressText = findViewById(R.id.progressTextView);


        if(!isNoQuestions) {
            progressText.setText(number+"/"+ QuizSingletonCustomMode.getInstance().questionList.size());
            final String question = intent.getExtras().getString("keyNumber");
            isQuestionTrue = QuizSingletonCustomMode.getInstance().questionList.get(number).getTrue();

            if(question.length()<20){
                questionText.setTextSize(40);
            } else {
                questionText.setTextSize(25);
            }

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
            cheatButton.setVisibility(View.VISIBLE);
            falseButton.setVisibility(View.VISIBLE);
        } else {
            trueButton.setVisibility(View.INVISIBLE);//invisible
            cheatButton.setVisibility(View.INVISIBLE);
            falseButton.setVisibility(View.INVISIBLE);
        }
    }
}
