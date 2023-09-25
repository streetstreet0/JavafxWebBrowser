package application;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class TabVBox extends VBox {
	private Tab currentTab;
	private TabStorer currentTabStorer;
	private TextField textField;
	
	public TabVBox(Tab currentTab, TabStorer currentTabStorer) {
		super();
		this.currentTab = currentTab;
		this.currentTabStorer = currentTabStorer;
	}
	
	public TabVBox(TabStorer currentTabStorer) {
		super();
		this.currentTabStorer = currentTabStorer;
	}
	
	public void setTextField(TextField textField) {
		this.textField = textField;
	}
	
	public void setInitialTab(Tab defaultTab) {
		if (currentTab == null) {
			this.currentTab = defaultTab;
		}
	}
	
	public void switchTab(Tab newTab) {
		if (newTab == currentTab) {
			return;
		}
		Node oldTab = null;
		for (Node child : this.getChildren()) {
			if (child instanceof WebView) {
				oldTab = child;
				break;
			}
		}
		this.getChildren().remove(oldTab);
		this.currentTab = newTab;
		this.currentTabStorer.setTab(newTab);
		this.getChildren().add(newTab.getWebsiteVisual());
		textField.setText(newTab.getWebsiteBackEnd().getLocation());
	}
}
