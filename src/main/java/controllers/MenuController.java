package controllers;

import javafx.fxml.FXML;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import models.Question;
import javafx.scene.control.Alert.AlertType;

import util.TriviaApiHandler;

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