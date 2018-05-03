package su.nosite.smth.quizapp;

import java.util.ArrayList;

class QuizSingletonCustomMode {
    private static QuizSingletonCustomMode Instance = null;
    ArrayList<Question>questionList;


    public static QuizSingletonCustomMode getInstance() {
        if(Instance==null){
            Instance = new QuizSingletonCustomMode();
        }
        return Instance;
    }

    private QuizSingletonCustomMode() {
        questionList=new ArrayList<>();
    }
}
