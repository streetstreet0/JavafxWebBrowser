package application;

import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class Tab {
	private WebView websiteVisual;
	private WebEngine websiteBackEnd;
	private WebHistory websiteHistory;
	
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
}
