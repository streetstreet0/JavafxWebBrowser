package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;

public class ReloadEventHandler implements EventHandler<ActionEvent> {
	private TextField websiteInputField;
	private WebEngine websiteBackEnd;

	public ReloadEventHandler(TextField websiteInputField, WebEngine websiteBackEnd) {
		this.websiteInputField = websiteInputField;
		this.websiteBackEnd = websiteBackEnd;
	}

	@Override
	public void handle(ActionEvent event) {
		String currentPage = websiteBackEnd.getLocation();
		websiteBackEnd.load(currentPage);
		websiteInputField.setText(currentPage);
	}

}
