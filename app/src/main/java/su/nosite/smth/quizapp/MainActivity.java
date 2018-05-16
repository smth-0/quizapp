package su.nosite.smth.quizapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import su.nosite.smth.quizapp.quiz.StandartModeActivity;
import su.nosite.smth.waih.R;

public class MainActivity extends AppCompatActivity {

    Button standartModeButton;
    Button ratingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_xml);

        standartModeButton=findViewById(R.id.buttonEnterStandartMode);
        ratingButton=findViewById(R.id.ratingsButton);

        //////delete it after creating
        ratingButton.setText("coming soon");
        /////

        standartModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StandartModeActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed() { }
}


