package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class ScreenController {
    
	/**
	 * Main Menu Utility Method to go to the main menu
	 * @param controllerClass
	 * @param event of button
	 */
	public static void goMainMenu(Class<?> controllerClass, ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(controllerClass.getResource("/fxml/MenuView.fxml"));
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(new Scene(parent));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void goGameView(Class<?> controllerClass, ActionEvent event){
		try {
			Parent parent = FXMLLoader.load(controllerClass.getResource("/fxml/GameView.fxml"));
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(new Scene(parent));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void reRender(Class<?> controllerClass, ActionEvent event){
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.hide();
		window.show();
	}
}
