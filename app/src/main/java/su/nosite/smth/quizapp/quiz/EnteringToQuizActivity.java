package su.nosite.smth.quizapp.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import su.nosite.smth.waih.R;

public class EnteringToQuizActivity extends AppCompatActivity {

    Button nextButton;
    Button addButton;
    Button exitButton;
    TextView sucOrNot;
    QuizSingletonQuestions instance = QuizSingletonQuestions.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standart_mode);
        nextButton = findViewById(R.id.nextButtonStandartMode);
        sucOrNot = findViewById(R.id.sucOrNoteCustomMode);
        addButton = findViewById(R.id.addbutton);
        exitButton = findViewById(R.id.exitButton);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnteringToQuizActivity.this, QuizActivity.class);

                if (!instance.getList().isEmpty()) {
                    startActivityForResult(intent, 2);
                } else {
                    Toast.makeText(EnteringToQuizActivity.this, "add some questions before", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnteringToQuizActivity.this, AddQuestionActivity.class);
                startActivity(intent);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
