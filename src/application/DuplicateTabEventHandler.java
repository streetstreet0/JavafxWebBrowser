package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

/**
 * @deprecated
 * This Class cannot work because tabs cannot be cloned
 */
public class DuplicateTabEventHandler implements EventHandler<ActionEvent> {
	private ModifiableObservableTabList tabs;
	private Button addTabButton;
	private GridPane tabPane;
	private TabVBox mainBox;
	private ComboBox<Tab> selectTabBox;
	private Tab tab;

	public DuplicateTabEventHandler(Tab tab, TabVBox mainBox) {
		this.addTabButton = mainBox.getAddTabButton();
		this.tabPane = mainBox.getTabPane();
		this.mainBox = mainBox;
		this.tabs = mainBox.getTabs();
		this.selectTabBox = mainBox.getSelectTabBox();
		this.tab = tab;
	}

	@Override
	public void handle(ActionEvent event) {
//		Tab newTab = tab.clone();
//		// tabButton automatically assigns itself at newTab's button
//		TabButton tabButton = new TabButton(newTab, mainBox);
//		tabPane.getChildren().add(tabButton);
//		// need to add newTab to the list after setting its column index
//		GridPane.setColumnIndex(tabButton, tabs.size());
//		GridPane.setColumnIndex(addTabButton, tabs.size()+1);
//		GridPane.setColumnIndex(selectTabBox, tabs.size()+2);
//		tabs.add(newTab);
//		mainBox.switchTab(newTab);
	}
}
