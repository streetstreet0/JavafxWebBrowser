package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebHistory;

public class AddTabEventHandler implements EventHandler<ActionEvent> {
	private CustomModifiableObservableList<Tab> tabs;
	private HomePageStorer homePageStorer;
	private Button addTabButton;
	private GridPane tabPane;
	private TabVBox mainBox;
	private ComboBox<Tab> selectTabBox;
	private TextField urlTextField;
	private ObservableList<WebHistory.Entry> history;

	public AddTabEventHandler(TabVBox mainBox, TextField urlTextField, ObservableList<WebHistory.Entry> history) {
		this.urlTextField = urlTextField;
		this.history = history;
		this.homePageStorer = mainBox.getHomePageStorer();
		this.addTabButton = mainBox.getAddTabButton();
		this.tabPane = mainBox.getTabPane();
		this.mainBox = mainBox;
		this.tabs = mainBox.getTabs();
		this.selectTabBox = mainBox.getSelectTabBox();
	}

	@Override
	public void handle(ActionEvent event) {
		Tab newTab = new Tab(homePageStorer.getHomePage(), urlTextField, history);
		newTab.getWebsiteVisual().setZoom(mainBox.getZoom());
		// tabButton automatically assigns itself at newTab's button
		TabButton tabButton = new TabButton(newTab, mainBox, urlTextField);
		tabPane.getChildren().add(tabButton);
		// need to add newTab to the list after setting its column index
		GridPane.setColumnIndex(tabButton, tabs.size());
		GridPane.setColumnIndex(addTabButton, tabs.size()+1);
		tabs.add(newTab);
		selectTabBox.setVisibleRowCount(Math.min(selectTabBox.getItems().size(), 5));
		mainBox.switchTab(newTab);
	}

}
