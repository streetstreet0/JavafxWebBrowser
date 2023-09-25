package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class AddTabEventHandler implements EventHandler<ActionEvent> {
	private ArrayList<TabButton> tabButtons;
	private String homePage;
	private Button addTabButton;
	private GridPane tabPane;
	private TabVBox mainBox;

	public AddTabEventHandler(ArrayList<TabButton> tabButtons, String homePage, GridPane tabPane, Button addTabButton, TabVBox mainBox) {
		this.tabButtons = tabButtons;
		this.homePage = homePage;
		this.addTabButton = addTabButton;
		this.tabPane = tabPane;
		this.mainBox = mainBox;
	}

	@Override
	public void handle(ActionEvent event) {
		TabButton tabButton = new TabButton(new Tab(homePage), mainBox);
		tabButtons.add(tabButton);
		tabPane.getChildren().add(tabButton);
		GridPane.setColumnIndex(tabButton, tabButtons.size()-1);
		GridPane.setColumnIndex(addTabButton, tabButtons.size());
	}

}
