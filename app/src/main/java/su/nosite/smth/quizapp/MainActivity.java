package su.nosite.smth.quizapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import su.nosite.smth.waih.R;

public class MainActivity extends AppCompatActivity {

    Button standartModeButton;
    Button customModeButton;
    Button ratingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_xml);

        standartModeButton=findViewById(R.id.buttonEnterStandartMode);
        customModeButton=findViewById(R.id.buttonEnterCustomMode);
        ratingButton=findViewById(R.id.ratingsButton);

        //////delete it after fix
        customModeButton.setText("coming soon");
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

}


