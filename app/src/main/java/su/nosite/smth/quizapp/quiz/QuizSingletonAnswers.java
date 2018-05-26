package su.nosite.smth.quizapp.quiz;

import java.util.ArrayList;

public class QuizSingletonAnswers {
    private static QuizSingletonAnswers ourInstance;
    ArrayList<Boolean>answers;

    static QuizSingletonAnswers getInstance() {
        if(ourInstance==null){
            ourInstance=new QuizSingletonAnswers();
            ourInstance.answers=new ArrayList<>();
        }
        return ourInstance;
    }

    private QuizSingletonAnswers() {
    }
}
