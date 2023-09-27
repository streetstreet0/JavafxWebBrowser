package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;

public class HomeEventHandler implements EventHandler<ActionEvent> {
	private TextField websiteInputField;
	private TabStorer currentTabStorer;
	private HomePageStorer homePageStorer;

	public HomeEventHandler(TabStorer currentTabStorer, HomePageStorer homePageStorer, TextField websiteInputField) {
		this.websiteInputField = websiteInputField;
		this.currentTabStorer = currentTabStorer;
		this.homePageStorer = homePageStorer;
	}

	@Override
	public void handle(ActionEvent event) {
		WebEngine websiteBackEnd = currentTabStorer.getTab().getWebsiteBackEnd();
		websiteBackEnd.load(homePageStorer.getHomePage());
		websiteInputField.setText(homePageStorer.getHomePage());
	}

}
