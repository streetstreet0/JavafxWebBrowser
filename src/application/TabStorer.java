package application;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class TabStorer {
	private Tab tab;
	
	public TabStorer() {
		//empty constructor
	}

	public TabStorer(Tab tab) {
		super();
		this.tab = tab;
	}

	public Tab getTab() {
		return tab;
	}

	public void setTab(Tab tab) {
		this.tab = tab;
	}
	
	
}
