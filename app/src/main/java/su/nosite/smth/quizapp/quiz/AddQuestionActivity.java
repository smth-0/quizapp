package su.nosite.smth.quizapp.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import su.nosite.smth.quizapp.Question;
import su.nosite.smth.waih.R;

public class AddQuestionActivity extends AppCompatActivity {

    CheckBox checkBox;
    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        checkBox=findViewById(R.id.checkBox);
        editText=findViewById(R.id.editTextQuestion);
        button=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizSingletonStandartMode
                        .getInstance()
                        .questionList
                        .add(
                                new Question(
                                        editText
                                                .getText()
                                                .toString(),
                                        checkBox
                                                .isChecked()
                                )
                        );
                finish();
            }
        });



    }
}
