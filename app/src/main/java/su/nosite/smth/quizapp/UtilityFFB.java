package su.nosite.smth.quizapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UtilityFFB {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference myRef = database.getReference("rating");

}
