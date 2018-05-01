package su.nosite.smth.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import su.nosite.smth.waih.R;

public class StandartModeActivity extends AppCompatActivity {

    Button nextButton;
    TextView sucOrNot;
    int number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standart_mode);
        nextButton=findViewById(R.id.nextButtonStandartMode);
        sucOrNot=findViewById(R.id.sucOrNoteStandartMode);

        if(number==0) {
            sucOrNot.setText("Are you ready for quiz?");
            nextButton.setText("START");
        } else{
            Boolean isLastQuestionSuc = AnswersStandartMode.getInstance().answers.get(number);
            nextButton.setText("NEXT QUESTION");
            if(isLastQuestionSuc){
                sucOrNot.setText("SUCCES");
            } else {
                sucOrNot.setText("FAIL");
            }
        }
        number++;
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StandartModeActivity.this, QuizActivity.class);
                if(QuizSingletonStandartMode.getInstance().questionList.size()!=0) {
                    intent.putExtra("keyNumber", QuizSingletonStandartMode.getInstance().questionList.get(number).getQ());
                    intent.putExtra("isNoQuestion",false);
                } else {
                    intent.putExtra("keyNumber", "error");
                    intent.putExtra("isNoQuestion",true);
                }
                intent.putExtra("isStandart",new Boolean(true));
                intent.putExtra("i",number);
                startActivity(intent);
            }
        });


    }
}
