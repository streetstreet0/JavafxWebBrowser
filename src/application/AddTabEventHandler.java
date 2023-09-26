package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class AddTabEventHandler implements EventHandler<ActionEvent> {
	private ModifiableObservableTabList tabs;
	private String homePage;
	private Button addTabButton;
	private GridPane tabPane;
	private TabVBox mainBox;
	private ComboBox<Tab> selectTabBox;

	public AddTabEventHandler(TabVBox mainBox) {
		this.homePage = mainBox.getHomePage();
		this.addTabButton = mainBox.getAddTabButton();
		this.tabPane = mainBox.getTabPane();
		this.mainBox = mainBox;
		this.tabs = mainBox.getTabs();
		this.selectTabBox = mainBox.getSelectTabBox();
	}

	@Override
	public void handle(ActionEvent event) {
		Tab newTab = new Tab(homePage);
		// tabButton automatically assigns itself at newTab's button
		TabButton tabButton = new TabButton(newTab, mainBox);
		tabPane.getChildren().add(tabButton);
		// need to add newTab to the list after setting its column index
		GridPane.setColumnIndex(tabButton, tabs.size());
		GridPane.setColumnIndex(addTabButton, tabs.size()+1);
		tabs.add(newTab);
		selectTabBox.setVisibleRowCount(Math.min(selectTabBox.getItems().size(), 5));
		mainBox.switchTab(newTab);
	}

}
