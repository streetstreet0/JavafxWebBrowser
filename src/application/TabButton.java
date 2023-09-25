package application;

import javafx.scene.control.Button;

public class TabButton extends Button {
	private Tab tab;
	
	public TabButton(Tab tab) {
		this.tab = tab;
		this.setText(tab.getWebsiteBackEnd().getTitle());
	}
	
	public Tab getTab() {
		return tab;
	}
}
