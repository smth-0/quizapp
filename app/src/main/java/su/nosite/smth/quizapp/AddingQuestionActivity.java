package su.nosite.smth.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import su.nosite.smth.waih.R;


public class AddingQuestionActivity extends AppCompatActivity {

    EditText questionText;
    CheckBox isTrueCheckBox;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_question);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizSingletonStandartMode.getInstance().questionList.add(new Question(questionText.getText().toString(),isTrueCheckBox.isChecked()));
                finish();
            }
        });

    }
}
