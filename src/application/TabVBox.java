package application;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class TabVBox extends VBox {
	private TabStorer currentTabStorer;
	private CustomModifiableObservableList<Tab> tabs;
	private TextField textField;
	private GridPane tabPane;
	private Button addTabButton;
	private ComboBox<Tab> selectTabBox;
	private String homePage;

	public TabVBox(TabStorer currentTabStorer, CustomModifiableObservableList<Tab> tabs, String homePage) {
		super();
		this.currentTabStorer = currentTabStorer;
		this.tabs = tabs;
		this.homePage = homePage;
	}
	
	
	public String getHomePage() {
		return homePage;
	}
	
	
	public CustomModifiableObservableList<Tab> getTabs() {
		return tabs;
	}
	public void setTabs(CustomModifiableObservableList<Tab> tabs) {
		this.tabs = tabs;
	}

	
	public void setTextField(TextField textField) {
		this.textField = textField;
	}
	public Tab getCurrentTab() {
		return currentTabStorer.getTab();
	}
	
	
	public GridPane getTabPane() {
		return this.tabPane;
	}
	public void setTabPane(GridPane tabPane) {
		this.tabPane = tabPane;
	}
	
	
	public Button getAddTabButton() {
		return addTabButton;
	}
	public ComboBox<Tab> getSelectTabBox() {
		return selectTabBox;
	}

	
	public void setAddTabButton(Button addTabButton) {
		this.addTabButton = addTabButton;
	}
	public void setSelectTabBox(ComboBox<Tab> selectTabBox) {
		this.selectTabBox = selectTabBox;
	}
	
	
	public void setInitialTab(Tab defaultTab) {
		if (currentTabStorer.getTab() == null) {
			currentTabStorer.setTab(defaultTab);
			this.getChildren().add(defaultTab.getWebsiteVisual());
			VBox.setVgrow(defaultTab.getWebsiteVisual(), Priority.ALWAYS);
		}
	}
	
	
	public void switchTab(Tab newTab) {
		if (newTab.equals(currentTabStorer.getTab())) {
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
		this.currentTabStorer.setTab(newTab);
		this.getChildren().add(newTab.getWebsiteVisual());
		textField.setText(newTab.getWebsiteBackEnd().getLocation());
		selectTabBox.setValue(newTab);
	}
}
