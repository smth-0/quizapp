//TODO: this
package su.nosite.smth.quizapp.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import su.nosite.smth.quizapp.MainActivity;
import su.nosite.smth.waih.R;

public class ResultActivity extends AppCompatActivity {

    ////////////////////////////////////////////////////

    ProgressBar progressBar;
    TextView textView;
    Button button;

    ////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ////////////////////////////////////////////////////

        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.resultTextView);
        button = findViewById(R.id.buttonDoneResult);

        ////////////////////////////////////////////////////

        int questionsCount = AnswersStandartMode
                .getInstance()
                .answers
                .size();
        int trueQuestionsCount = 0;

        for (int i = 0; i < questionsCount; ++i) {
            if (AnswersStandartMode
                    .getInstance()
                    .answers
                    .get(i)) {
                //////////////////
                ++trueQuestionsCount;
            }
        }

        progressBar.setProgress((trueQuestionsCount * 100) / questionsCount);
        textView.setText(trueQuestionsCount + "/" + questionsCount);

        ////////////////////////////////////////////////////

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });
        AnswersStandartMode
                .getInstance()
                .answers
                .clear();
    }

    public void onBackPressed() { }
}