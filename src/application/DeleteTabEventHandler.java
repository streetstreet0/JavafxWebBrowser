package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebHistory;

public class DeleteTabEventHandler implements EventHandler<ActionEvent> {
	private Tab tab;
	private TabVBox mainBox;
	private GridPane tabPane;
	private Button addTabButton;
	private ComboBox<Tab> selectTabBox;
	private CustomModifiableObservableList<Tab> tabs;
	private AddTabEventHandler addTabHandler;
	
	public DeleteTabEventHandler(Tab tab, TabVBox mainBox, TextField urlInputField, ObservableList<WebHistory.Entry> history) {
		this.tab = tab;
		this.mainBox = mainBox;
		this.tabPane = mainBox.getTabPane();
		this.addTabButton = mainBox.getAddTabButton();
		this.selectTabBox = mainBox.getSelectTabBox();
		this.tabs = mainBox.getTabs();
		this.addTabHandler = new AddTabEventHandler(mainBox, urlInputField, history);
	}
	

	@Override
	public void handle(ActionEvent event) {
		if (tabs.size() == 1) {
			tabs.remove(0);
			addTabHandler.handle(new ActionEvent());
			return;
		}
		
		int deletedIndex = -1;
		for (int i=0; i<tabs.size(); i++) {
			Tab tabInList = tabs.get(i);
			if (tabInList.equals(tab)) {
				if (mainBox.getCurrentTab().equals(tab)) {
					int newCurrentTabIndex;
					if (i == 0) {
						newCurrentTabIndex = 1;
					}
					else {
						newCurrentTabIndex = i-1;
					}
					mainBox.switchTab(tabs.get(newCurrentTabIndex));
				}
				tabPane.getChildren().remove(tab.getTabButton());
				tabs.remove(i);
				deletedIndex = i;
				break;
			}
		}
		if (deletedIndex == -1) {
			return;
		}
		for (int i=deletedIndex; i<tabs.size(); i++) {
			Tab tab = tabs.get(i);
			GridPane.setColumnIndex(tab.getTabButton(), i);
		}
		GridPane.setColumnIndex(addTabButton, tabs.size());
		selectTabBox.setVisibleRowCount(Math.min(selectTabBox.getItems().size(), 5));
	}
}
