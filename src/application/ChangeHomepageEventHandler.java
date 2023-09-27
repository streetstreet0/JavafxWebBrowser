package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ChangeHomepageEventHandler implements EventHandler<ActionEvent> {
	private TabVBox mainBox;
	private TextField textField;
	
	public ChangeHomepageEventHandler(TabVBox mainBox, TextField textField) {
		this.mainBox = mainBox;
		this.textField = textField;
	}

	@Override
	public void handle(ActionEvent event) {
		mainBox.setHomePage(textField.getText());
		Alert homePageSetAlert = new Alert(Alert.AlertType.INFORMATION);
		homePageSetAlert.setTitle("Homepage Changed Successfully");
		homePageSetAlert.setHeaderText("Homepage has been set to: " + textField.getText());
		homePageSetAlert.showAndWait();
	} 
}
