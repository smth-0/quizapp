package su.nosite.smth.quizapp;

import java.util.ArrayList;

class QuizSingleton {
    private static QuizSingleton Instance = null;
    ArrayList<Question>questionList;


    public static QuizSingleton getInstance() {
        if(Instance==null){
           Instance = new QuizSingleton();
        }
        return Instance;
    }

    private QuizSingleton() {
        questionList=new ArrayList<>();
    }
}
