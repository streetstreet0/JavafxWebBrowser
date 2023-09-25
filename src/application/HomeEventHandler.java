package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;

public class HomeEventHandler implements EventHandler<ActionEvent> {
	private TextField websiteInputField;
	private TabStorer currentTabStorer;
	private String homePage;

	public HomeEventHandler(TabStorer currentTabStorer, String homePage, TextField websiteInputField) {
		this.websiteInputField = websiteInputField;
		this.currentTabStorer = currentTabStorer;
		this.homePage = homePage;
	}

	@Override
	public void handle(ActionEvent event) {
		WebEngine websiteBackEnd = currentTabStorer.getTab().getWebsiteBackEnd();
		websiteBackEnd.load(homePage);
		websiteInputField.setText(homePage);
	}

}
