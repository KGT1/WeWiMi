package models;
import java.util.ArrayList;

public class Question {
    private String question;
    private String difficulty;
    private String categorie;
    private int correctAnswerIndex;
    private String[] Answers= new String[4];
    
    public Question(String question, String difficutly, String categorie, int correctAnswerIndex, String[] Answers){
        this.question=question;
        this.categorie=categorie;
        this.correctAnswerIndex=correctAnswerIndex;
        this.Answers=Answers;
        this.difficulty=difficutly;
    }

    public int getCorrectAnswerIndex(){
        return correctAnswerIndex;
    }

    public String getQuestion(){
        return question;
    }

    public String[] getAnswers(){
        return Answers;
    }
    
    public String getCategorie(){
        return categorie;
    }
}