package su.nosite.smth.quizapp.quiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import su.nosite.smth.quizapp.Question;
import su.nosite.smth.waih.R;

public class AddQuestionActivity extends AppCompatActivity {


    public String KEY = "KEY812763";
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
                ArrayList<Question> list = null;
                        list = instance.getList();
                String question = String.valueOf(editText.getText());
                Boolean answer = checkBox.isChecked();
                Log.d("ERROR87676",new Gson().toJson(list));
                list.add(new Question(question, answer));
                Log.d("ERROR87676", String.valueOf(list.get(0).getQ()));

                Type listType = new TypeToken<ArrayList<Question>>(){}.getType();

                //////////////////////////////////
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                Gson gson = new Gson();
                editor
                        .putString(
                                KEY,
                                gson.toJson(list, listType)
                        )
                        .apply();

                String output = sharedPreferences.getString(KEY, "FAIL-FAIL-FAIL");

                Log.d("ERROR87676","output is :"+ output);
                Log.d("ERROR87676", "json is"+ gson.toJson(list, listType));
                Log.d("ERROR87676", "list.toString is:"+ list.toString());
                Log.d("ERROR87676", "first q is :"+ list.get(0).getQ());
                Log.d("ERROR87676",String.valueOf(gson.toJson(QuizSingletonQuestions.getInstance().getList())));
                //////////////////////////////////
                finish();
            }
        });



    }
}
