package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;

public class HomeEventHandler implements EventHandler<ActionEvent> {
	private TextField websiteInputField;
	private WebEngine websiteBackEnd;
	private String homePage;

	public HomeEventHandler(TextField websiteInputField, WebEngine websiteBackEnd, String homePage) {
		this.websiteInputField = websiteInputField;
		this.websiteBackEnd = websiteBackEnd;
		this.homePage = homePage;
	}

	@Override
	public void handle(ActionEvent event) {
		websiteBackEnd.load(homePage);
		websiteInputField.setText(websiteBackEnd.getLocation());
	}

}
