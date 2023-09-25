package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;

public class ReloadEventHandler implements EventHandler<ActionEvent> {
	private TextField websiteInputField;
	private TabStorer currentTabStorer;

	public ReloadEventHandler(TabStorer currentTabStorer, TextField websiteInputField) {
		this.websiteInputField = websiteInputField;
		this.currentTabStorer = currentTabStorer;
	}

	@Override
	public void handle(ActionEvent event) {
		WebEngine websiteBackEnd = currentTabStorer.getTab().getWebsiteBackEnd();
		String currentPage = websiteBackEnd.getLocation();
		websiteBackEnd.load(currentPage);
		websiteInputField.setText(currentPage);
	}

}
