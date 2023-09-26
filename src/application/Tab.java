package application;

import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class Tab {
	private WebView websiteVisual;
	private WebEngine websiteBackEnd;
	private WebHistory websiteHistory;
	private TabButton tabButton;
	
	public Tab(String homePage) {
		this.websiteVisual = new WebView();
		this.websiteBackEnd = websiteVisual.getEngine();
		this.websiteHistory = websiteBackEnd.getHistory();
		websiteBackEnd.load(homePage);
	}
	
	public WebView getWebsiteVisual() {
		return websiteVisual;
	}
	public WebEngine getWebsiteBackEnd() {
		return websiteBackEnd;
	}
	public WebHistory getWebsiteHistory() {
		return websiteHistory;
	}
	public TabButton getTabButton() {
		return tabButton;
	}
	public void setTabButton(TabButton tabButton) {
		this.tabButton = tabButton;
	}
	
	@Override
	public String toString() {
		int index = GridPane.getColumnIndex(tabButton) + 1;
		return index + ": " + websiteBackEnd.getLocation();
	}
}
