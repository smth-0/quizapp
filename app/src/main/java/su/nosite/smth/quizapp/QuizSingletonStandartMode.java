package su.nosite.smth.quizapp;

import java.util.ArrayList;

class QuizSingletonStandartMode {
    private static QuizSingletonStandartMode Instance = null;
    ArrayList<Question>questionList;


    public static QuizSingletonStandartMode getInstance() {
        if(Instance==null){
           Instance = new QuizSingletonStandartMode();
        }
        return Instance;
    }

    private QuizSingletonStandartMode() {
        questionList=new ArrayList<>();
    }
}
