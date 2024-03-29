package application;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebHistory.Entry;

public class TabButton extends Button {
	private Tab tab;
	private CustomModifiableObservableList<HistoryItem> history;
	
	public TabButton(Tab tab, TabVBox mainBox, TextField urlTextField, CustomModifiableObservableList<HistoryItem> history) {
		this.tab = tab;
		this.history = history;
		tab.setTabButton(this);
		this.setText("temp");
		createEventHandlers(mainBox, urlTextField);
	}
	
	private void createEventHandlers(TabVBox mainBox, TextField urlTextField) {
		ChangeTabEventHandler changeTabEventhandler = new ChangeTabEventHandler(tab, mainBox);
		this.setOnAction(changeTabEventhandler);
		this.setOnMouseClicked(new AltClickTabEventHandler(tab, mainBox, urlTextField, history));
		createContextMenu(changeTabEventhandler, mainBox, urlTextField);
	}
	
	private void createContextMenu(ChangeTabEventHandler changeTabEventhandler, TabVBox mainBox, TextField urlTextField) {
		ContextMenu contextMenu = new ContextMenu();
		MenuItem item1 = new MenuItem("Switch to tab");
		item1.setOnAction(changeTabEventhandler);
		//MenuItem item2 = new MenuItem("Duplicate tab");
		//item2.setOnAction(new DuplicateTabEventHandler(tab, mainBox));
		MenuItem item3 = new MenuItem("Close tab");
		item3.setOnAction(new DeleteTabEventHandler(tab, mainBox, urlTextField, history));
		contextMenu.getItems().add(item1);
		//contextMenu.getItems().add(item2);
		contextMenu.getItems().add(item3);
		this.setContextMenu(contextMenu);
	}
	
	public Tab getTab() {
		return tab;
	}
	
}
