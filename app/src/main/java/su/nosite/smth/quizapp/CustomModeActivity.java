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
        setContentView(R.layout.activity_custom_mode);
        nextButton=findViewById(R.id.nextButtonCustomMode);
        sucOrNot=findViewById(R.id.sucOrNoteCustomMode);
        addQ = findViewById(R.id.addQuestionButton);


        if(number==0) {
            sucOrNot.setText("Are you ready for quiz?");
            nextButton.setText("START");
            addQ.setVisibility(Button.VISIBLE);
        } else {
            Boolean isLastQuestionSuc = AnswersCustomMode.getInstance().answers.get(number);
            nextButton.setText("NEXT QUESTION");
            addQ.setVisibility(View.GONE);
            if(isLastQuestionSuc){
                sucOrNot.setText("SUCCESS");
            } else {
                sucOrNot.setText("FAIL");
            }
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: this
                Intent intent = new Intent(CustomModeActivity.this, QuizActivity.class);

                startActivity(intent);
            }
        });
        addQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomModeActivity.this,AddingQuestionActivity.class);



                startActivity(intent);
            }
        });
    }
}
