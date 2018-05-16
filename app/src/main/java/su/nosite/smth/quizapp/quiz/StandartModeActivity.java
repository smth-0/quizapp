package su.nosite.smth.quizapp.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import su.nosite.smth.waih.R;

public class StandartModeActivity extends AppCompatActivity {

    Button nextButton;
    Button addButton;
    TextView sucOrNot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standart_mode);
        nextButton=findViewById(R.id.nextButtonStandartMode);
        sucOrNot=findViewById(R.id.sucOrNoteCustomMode);
        addButton=findViewById(R.id.addbutton);

        sucOrNot.setText("Are you ready for quiz?");
        nextButton.setText("START");


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StandartModeActivity.this, QuizStandartActivity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StandartModeActivity.this,AddQuestionActivity.class);
                startActivity(intent);
            }
        });

    }
    public void onBackPressed() { }
}
