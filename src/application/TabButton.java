package application;

import javafx.scene.control.Button;

public class TabButton extends Button {
	private Tab tab;
	
	public TabButton(Tab tab, TabVBox mainBox) {
		this.tab = tab;
		tab.setTabButton(this);
		this.setText("temp");
		this.setOnAction(new ChangeTabEventHandler(tab, mainBox));
	}
	
	public Tab getTab() {
		return tab;
	}
	
}
