package controllers;

import javafx.fxml.FXML;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;


public class MenuController {

    
    
    @FXML
	private void showGameView(ActionEvent event){
		ScreenController.goGameView(getClass(), event);
	}
	
	/**
	 * Save and exit the application
	 * @param event
	 */
	@FXML
	private void quitButtonClick(ActionEvent event) throws IOException{
		//model.save();
		Platform.exit();
	}
    
}