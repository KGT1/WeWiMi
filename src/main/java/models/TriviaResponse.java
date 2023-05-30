package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TriviaResponse {
    private TriviaResponseResult[] trr;
    private int response_code; 

    public TriviaResponse(@JsonProperty("results") TriviaResponseResult[] trr,@JsonProperty("response_code") int response_code){
        this.trr=trr;
        this.response_code=response_code;
    }

    public Question getResult(int index){
        return trr[index].getCovertedQuestion();
    }

    public int getResponseCode(){
        return response_code;
    }

}