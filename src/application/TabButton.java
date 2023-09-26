package application;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class TabButton extends Button {
	private Tab tab;
	
	public TabButton(Tab tab, TabVBox mainBox) {
		this.tab = tab;
		tab.setTabButton(this);
		this.setText("temp");
		createEventHandlers(mainBox);
	}
	
	private void createEventHandlers(TabVBox mainBox) {
		ChangeTabEventHandler changeTabEventhandler = new ChangeTabEventHandler(tab, mainBox);
		this.setOnAction(changeTabEventhandler);
		this.setOnMouseClicked(new AltClickTabEventHandler(tab, mainBox));
		createContextMenu(changeTabEventhandler, mainBox);
	}
	
	private void createContextMenu(ChangeTabEventHandler changeTabEventhandler, TabVBox mainBox) {
		ContextMenu contextMenu = new ContextMenu();
		MenuItem item1 = new MenuItem("Switch to tab");
		item1.setOnAction(changeTabEventhandler);
		MenuItem item2 = new MenuItem("Duplicate tab");
		item2.setOnAction(new DuplicateTabEventHandler(tab, mainBox));
		MenuItem item3 = new MenuItem("Close tab");
		item3.setOnAction(new DeleteTabEventHandler(tab, mainBox));
		contextMenu.getItems().add(item1);
		contextMenu.getItems().add(item2);
		contextMenu.getItems().add(item3);
		this.setContextMenu(contextMenu);
	}
	
	public Tab getTab() {
		return tab;
	}
	
}
