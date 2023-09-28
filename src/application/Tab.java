package application;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;

public class Tab {
	private WebView websiteVisual;
	private WebEngine websiteBackEnd;
	private WebHistory websiteHistory;
	private TabButton tabButton;
	
	public Tab(String homePage, TextField urlTextField, ObservableList<WebHistory.Entry> history) {
		this.websiteVisual = new WebView();
		this.websiteBackEnd = websiteVisual.getEngine();
		this.websiteHistory = websiteBackEnd.getHistory();
//		websiteVisual.setOnMouseClicked(new MouseClickUrlUpdater(this, urlTextField));
//		websiteVisual.setOnKeyPressed(new EnterKeyUrlUpdater(this, urlTextField));
		websiteHistory.getEntries().addListener(new WebHistoryChangeListener(history, urlTextField, this));
		websiteBackEnd.load(homePage);
	}
	
// 	.clone() is not supported in WebView, so this method cannot work
//	private Tab(WebView websiteVisual) {
//		this.websiteVisual = websiteVisual.clone();
//		this.websiteBackEnd = websiteVisual.getEngine();
//		this.websiteHistory = websiteBackEnd.getHistory();
//		this.tabButton = null;
//	}
	
//	.clone() is not supported in WebView, so this method 
//	@Override
//	public Tab clone() {
//		return new Tab(websiteVisual);
//	}
	
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
