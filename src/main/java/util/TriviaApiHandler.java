package util;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import models.TriviaResponse;
import models.Question;

public class TriviaApiHandler {

    public Question[] getQuestions(String difficulty, int amount) throws StreamReadException, DatabindException, MalformedURLException, IOException {
            String url = "https://opentdb.com/api.php?amount=" + amount + "&category=9&difficulty=" + difficulty +"&type=multiple";

            // Create an instance of the ObjectMapper from Jackson library
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON data from the URL and map it to a custom object
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
            TriviaResponse response = objectMapper.readValue(inputStreamReader, TriviaResponse.class);

            // Access the parsed object
            Question[] r = new Question[amount];
            for (int x = 0; x < amount; x++) {
                r[x]=response.getResult(x);
                System.out.println(r[x].getCorrectAnswerIndex());
            }
            return r;
    }
}