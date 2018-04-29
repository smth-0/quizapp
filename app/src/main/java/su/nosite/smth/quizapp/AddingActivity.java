package su.nosite.smth.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import su.nosite.smth.waih.R;


public class AddingActivity extends AppCompatActivity {

    EditText question;
    CheckBox isTrueCheckBox;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



    }
}
