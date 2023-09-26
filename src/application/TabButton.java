package application;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class TabButton extends Button {
	private Tab tab;
	
	public TabButton(Tab tab, TabVBox mainBox) {
		this.tab = tab;
		tab.setTabButton(this);
		this.setText("temp");
		this.setOnAction(new ChangeTabEventHandler(tab, mainBox));
		this.setOnMouseClicked(new AltClickTabEventHandler(tab, mainBox));
	}
	
	public Tab getTab() {
		return tab;
	}
	
}
