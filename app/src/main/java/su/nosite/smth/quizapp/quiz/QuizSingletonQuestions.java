package su.nosite.smth.quizapp.quiz;

import android.util.Log;

import java.util.ArrayList;

import su.nosite.smth.quizapp.Question;

public class QuizSingletonQuestions {
    private static QuizSingletonQuestions Instance;
    private ArrayList<Question>questionList=new ArrayList<>();

    public static QuizSingletonQuestions getInstance() {
        if (Instance == null){
            Instance = new QuizSingletonQuestions();
        }
        // Log.e("QSQ", String.valueOf(Instance.getList() == null));
        return Instance;
    }

    public ArrayList<Question> getList() {
        if (questionList == null)
            questionList = new ArrayList<>();
        return questionList;
    }

    private QuizSingletonQuestions() {
    }

    public void setList(ArrayList<Question> list) {
        this.questionList = list;
    }
}
