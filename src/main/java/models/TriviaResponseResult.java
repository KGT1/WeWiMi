package models;
import java.lang.Math;

import models.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.commons.text.StringEscapeUtils;

public class TriviaResponseResult {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String correct_answer;
    private String[] incorrect_answers = new String[3];

    @JsonCreator
    public TriviaResponseResult(@JsonProperty("category") String category, @JsonProperty("type") String type, @JsonProperty("difficulty") String difficulty, @JsonProperty("question") String question, @JsonProperty("correct_answer") String correct_answer, @JsonProperty("incorrect_answers") String[] incorrect_answers) {
        this.category = category;
        this.type = type;
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }


    public Question getCovertedQuestion () {
        String[] answers= new String[4];
        int correctAnswerIndex = (int) (Math.random() * (answers.length));

        for (int i = 0, j = 0; i < answers.length; i++) {
            if (i == correctAnswerIndex) {
                answers[i] = StringEscapeUtils.unescapeHtml4(correct_answer);
            } else {
                answers[i] = StringEscapeUtils.unescapeHtml4(incorrect_answers[j]);
                j++;
            }
        }
        
        return new Question(
            StringEscapeUtils.unescapeHtml4(question),
            StringEscapeUtils.unescapeHtml4(difficulty),
            StringEscapeUtils.unescapeHtml4(category),
            correctAnswerIndex,
            answers);
    }
}
