//fix if's with singleton checking

package su.nosite.smth.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import su.nosite.smth.waih.R;

public class quizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        final String question = intent.getExtras().getString("keyNumber");
        final Boolean isStandart = intent.getExtras().getBoolean("isStandart");
        final int number = intent.getExtras().getInt("i");

        TextView questionText = findViewById(R.id.questionTextView);
        Button trueButton = findViewById(R.id.buttonTrue);
        final Button falseButton = findViewById(R.id.buttonFalse);
        Button cheatButton = findViewById(R.id.buttonCheatSkip);

        questionText.setText(question);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(isStandart){
                   AnswersStandartMode.getInstance().answers.add(true);
               }
                //add custom show
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isStandart){
                    AnswersStandartMode.getInstance().answers.add(false);
                }
                //add custom show
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean cheatActionBool = QuizSingleton.getInstance().questionList.get(number).getTrue();
                String s;
                if(cheatActionBool){
                    s="true";
                }
                else{
                    s="false";
                }
                Toast.makeText(getApplicationContext(),"answer is "+s,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
