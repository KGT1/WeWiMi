package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import util.TriviaApiHandler;
import util.ConvIndexToMoney;
import models.Question;


public class GameController {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 100;
    Question[] Qeasy;
    private int currentQindex;
	@FXML private Text question;
	@FXML private Button Answer1;
    @FXML private Button Answer2;
    @FXML private Button Answer3;
    @FXML private Button Answer4;
    @FXML private Button FiFi;
    @FXML private ListView<Text> levelListView;

    public void setNewquestion(int x) {
        question.setText(Qeasy[x].getQuestion());

        question.setWrappingWidth(MAX_WIDTH);
        question.setFont(Font.font(25));
        // Adjust font size and wrap text to fit within the maximum width
        while (question.getBoundsInLocal().getWidth() > MAX_WIDTH
                || question.getBoundsInLocal().getHeight() > MAX_HEIGHT
                && question.getFont().getSize() > 1) {
            question.setFont(Font.font(question.getFont().getSize() - 1));
        }
        System.out.println(question.getFont());
        
        Answer1.setText(Qeasy[x].getAnswers()[0]);
        Answer2.setText(Qeasy[x].getAnswers()[1]);
        Answer3.setText(Qeasy[x].getAnswers()[2]);
        Answer4.setText(Qeasy[x].getAnswers()[3]);
    }
    @FXML
    public void initialize() {
		TriviaApiHandler tApiH = new TriviaApiHandler();
		try{
			Qeasy = tApiH.getQuestions("easy",15);
			//question[] Qmedium = tApiH.getquestions("medium",5);
			//question[] Qhard d = tApiH.getquestions("hard",5);
            setNewquestion(0);
		} catch (Exception e) {
            e.printStackTrace();
        }
        Answer1.setOnAction((evt) -> clickQButton(0, evt));
        Answer2.setOnAction((evt) -> clickQButton(1, evt));
        Answer3.setOnAction((evt) -> clickQButton(2, evt));
        Answer4.setOnAction((evt) -> clickQButton(3, evt));
        FiFi.setOnAction((evt) -> ScreenController.reRender(getClass(),evt));
        for (int i = 0; i < 15; i++) {
            levelListView.getItems().add(new Text(ConvIndexToMoney.convIndexToMoney(i)));
        }
    }
    @FXML
    public void onEnter(){
        System.out.println("pressed Enter");
    }

    @FXML
    public void centerButton(){
        System.out.println("pressed center button");

    }

    @FXML
    public void clickQButton(int x, ActionEvent event){
        System.out.println("Button: "+ x);
        if(x==Qeasy[currentQindex].getCorrectAnswerIndex()){
            Alert alert = new Alert(AlertType.INFORMATION,
            "Correct Answer"
            );
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("result");
            alert.setHeaderText(null);
            alert.showAndWait();


            levelListView.getItems().get(currentQindex).setFont(new Font(0.1));

            setNewquestion(++currentQindex);
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION,
            "Wrong Answer"
            );
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("result");
            alert.setHeaderText(null);
            alert.showAndWait();
            ScreenController.goMainMenu(getClass(), event);
        }
    }
}
