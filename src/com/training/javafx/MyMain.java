package com.training.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	private Controller controller;

	public static void main(String args[]) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		controller = loader.getController();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}


	private MenuBar createMenu() {
		//File menu
		Menu fileMenu = new Menu("File");
		//New menu item
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				controller.userInputField.setText("");
			}
		});
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		//Quit menu item
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Platform.exit();
				System.exit(0);
			}
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		//Help menu
		Menu helpMenu = new Menu("Help");
		//About menu item
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				aboutApp();
			}
		});
		helpMenu.getItems().addAll(aboutApp);

		//Menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first Java Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner in JavaFX!");
		alertDialog.show();
	}


}
