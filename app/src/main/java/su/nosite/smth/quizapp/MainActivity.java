package su.nosite.smth.quizapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import su.nosite.smth.quizapp.quiz.EnteringToQuizActivity;
import su.nosite.smth.quizapp.quiz.QuizSingletonQuestions;
import su.nosite.smth.waih.R;

public class MainActivity extends AppCompatActivity {


    public String KEY = "KEY812763";
    private Button standartModeButton;
    private Button ratingButton;
    SharedPreferences sharedPreferences;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Type listType = new TypeToken<ArrayList<Question>>() {
        }.getType();

        sharedPreferences = getPreferences(MODE_PRIVATE);
        standartModeButton = findViewById(R.id.buttonEnterStandartMode);
        ratingButton = findViewById(R.id.ratingsButton);

        gson = new Gson();
        String json = sharedPreferences.getString(KEY, "FAIL");
        Log.d("TAG2", json);

        ArrayList<Question> list = null;

        if (json != "FAIL"){
            list = gson.fromJson(json, listType);
        } else{
            Log.e("ERROR87676", "Shared preferences returnet BAD ARGUMENT , json:"+json);
        }
        QuizSingletonQuestions.getInstance().setList(list);


        //////delete it after creating
        ratingButton.setText("coming soon");
        /////

        standartModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EnteringToQuizActivity.class);
                startActivity(intent);
            }
        });

        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MainActivity.this,RatingActivity.class));
            }
        });
    }
}
