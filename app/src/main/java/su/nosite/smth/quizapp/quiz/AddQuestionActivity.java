package su.nosite.smth.quizapp.quiz;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

        final QuizSingletonQuestions instance = QuizSingletonQuestions.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Question> list = instance.getList();
                String question = String.valueOf(editText.getText());
                Boolean answer = checkBox.isChecked();
                Log.d("TAG1",new Gson().toJson(list));
                list.add(new Question(question, answer));
Log.d("TAG2", String.valueOf(list.isEmpty()));


                //////////////////////////////////
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                editor.putString("q", gson.toJson(list)).apply();

                Log.d("TAG3",gson.toJson(list));
                //////////////////////////////////
                finish();
            }
        });



    }
}
