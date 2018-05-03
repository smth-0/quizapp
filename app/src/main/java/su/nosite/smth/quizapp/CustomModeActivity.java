package su.nosite.smth.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import su.nosite.smth.waih.R;

public class CustomModeActivity extends AppCompatActivity {
    Button nextButton;
    Button addQ;
    TextView sucOrNot;
    int number=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standart_mode);
        nextButton=findViewById(R.id.nextButtonStandartMode);
        sucOrNot=findViewById(R.id.sucOrNoteCustomMode);
        addQ = findViewById(R.id.addQuestionButton);

        if(number==0) {
            sucOrNot.setText("Are you ready for quiz?");
            nextButton.setText("START");
            addQ.setVisibility(Button.VISIBLE);

        } else{
            Boolean isLastQuestionSuc = AnswersCustomMode.getInstance().answers.get(number);
            nextButton.setText("NEXT QUESTION");
            addQ.setVisibility(View.GONE);
            if(isLastQuestionSuc){
                sucOrNot.setText("SUCCESS");
            } else {
                sucOrNot.setText("FAIL");
            }
        }
        number++;
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomModeActivity.this, QuizActivity.class);
                if(QuizSingletonCustomMode.getInstance().questionList.size()!=0) {
                    intent.putExtra("keyNumber", QuizSingletonCustomMode.getInstance().questionList.get(number).getQ());
                    intent.putExtra("isNoQuestion",false);
                } else {
                    intent.putExtra("keyNumber", "error");
                    intent.putExtra("isNoQuestion",true);
                }
                intent.putExtra("isStandart",new Boolean(false));
                intent.putExtra("i",number);
                startActivity(intent);
            }
        });
        addQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomModeActivity.this,AddingQuestionActivity.class);
            }
        });


    }
}
