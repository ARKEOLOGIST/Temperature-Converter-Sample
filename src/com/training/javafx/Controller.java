package com.training.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInputField;

	@FXML
    public Button convertButton;

	private static final String C_TO_F = "Celsius to Fahrenheit";
	private static final String F_TO_C = "Fahrenheit to Celsius";

	private static boolean isC_TO_F = true;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		choiceBox.getItems().add(C_TO_F);
		choiceBox.getItems().add(F_TO_C);

		choiceBox.setValue(C_TO_F);
		choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
				if (t1.equals(C_TO_F))
				{
					isC_TO_F = true;
				} else {
					isC_TO_F = false;
				}
			}
		});

		convertButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				convert();
			}
		});
	}

	private void convert() {

		String input = userInputField.getText(); //69.6 => "69.6"

		Alert alertDialogz;

		float newTemperature = 0.0f,enteredTemperature = 0.0f;

		try {
			enteredTemperature = Float.parseFloat(input);  //69.6 C
			if (isC_TO_F) {
				newTemperature = (enteredTemperature * 9 / 5) + 32;
			} else {
				newTemperature = (enteredTemperature - 32) * 5 / 9;
			}
			String text = isC_TO_F?"F":"C";
			alertDialogz = new Alert(Alert.AlertType.INFORMATION);
			alertDialogz.setTitle("Result");
			alertDialogz.setHeaderText("Result");
			alertDialogz.setContentText("The resultant temperature is: " +newTemperature+ " " +text);
			alertDialogz.show();

		} catch (Exception e) {
			throwError();
			
		}

	}

	private void throwError() {
		Alert alertDialogt;
		alertDialogt = new Alert(Alert.AlertType.ERROR);
		alertDialogt.setTitle("Error");
		alertDialogt.setHeaderText("Error");
		alertDialogt.setContentText("Please enter a valid number!");
		alertDialogt.show();
	}
}
