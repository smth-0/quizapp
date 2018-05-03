package su.nosite.smth.quizapp;

import java.util.ArrayList;

class AnswersCustomMode {
    private static AnswersCustomMode ourInstance;
    ArrayList<Boolean>answers;

    static AnswersCustomMode getInstance() {
        if(ourInstance==null){
            ourInstance=new AnswersCustomMode();
            ourInstance.answers=new ArrayList<>();
        }
        return ourInstance;
    }

    private AnswersCustomMode() {
    }
}
