package application;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;


public class SelectTabEventHandler implements EventHandler<ActionEvent> {
	private Alert selectTabAlert;
	private Stage owner;
	private ComboBox<Tab> tabs;
	private TabStorer currentTabStorer;
	
	public SelectTabEventHandler(ComboBox<Tab> tabs, Stage owner, TabStorer currentTabStorer) {
		this.tabs = tabs;
		this.owner = owner;
		this.currentTabStorer = currentTabStorer;
		generateAlert();
	}
	
	public void generateAlert() {
		selectTabAlert = new Alert(Alert.AlertType.CONFIRMATION);
		VBox selectTabVBox = new VBox();
		selectTabVBox.getChildren().add(tabs);
		selectTabAlert.setTitle("Select Tab");
		selectTabAlert.setHeaderText("");
		selectTabAlert.setGraphic(selectTabVBox);
	}
	
	public void setOwner(Stage owner) {
		selectTabAlert.initOwner(owner);
	}

	@Override
	public void handle(ActionEvent event) {
		selectTabAlert.showAndWait();
		Tab tab = tabs.getValue();
		if (tab != null && !selectTabAlert.getResult().getText().equals("Cancel") && !tab.equals(currentTabStorer.getTab())) {
			tab.getTabButton().getOnAction().handle(event);
		}
	}
}
