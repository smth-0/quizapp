package su.nosite.smth.quizapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import su.nosite.smth.waih.R;

public class MainActivity extends AppCompatActivity {

    Button standartModeButton=findViewById(R.id.buttonEnterStandartMode);
    Button customModeButton=findViewById(R.id.buttonEnterCustomMode);
    Button ratingButton=findViewById(R.id.ratingsButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_xml);




    }

}


