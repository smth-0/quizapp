package su.nosite.smth.quizapp.quiz;

import java.util.ArrayList;

import su.nosite.smth.quizapp.Question;

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
