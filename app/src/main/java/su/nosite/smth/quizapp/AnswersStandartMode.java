package su.nosite.smth.quizapp;

import java.util.ArrayList;

class AnswersStandartMode {
    private static AnswersStandartMode ourInstance;
    ArrayList<Boolean>answers;

    static AnswersStandartMode getInstance() {
        if(ourInstance==null){
            ourInstance=new AnswersStandartMode();
            ourInstance.answers=new ArrayList<>();
        }
        return ourInstance;
    }

    private AnswersStandartMode() {
    }
}
