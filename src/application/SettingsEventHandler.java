package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SettingsEventHandler implements EventHandler<ActionEvent> {
	private Alert settingsAlert;
	private Stage owner;
	private TabVBox mainBox;
	private double buttonSize;
	private CustomModifiableObservableList<Tab> tabs;
	private static final double[] zoomValues = {0.3, 0.5, 0.67, 0.8, 0.9, 1.0, 1.1, 1.2, 1.33, 1.5, 1.7, 2.0, 
			2.4, 3.0, 4.0, 4.1, 4.2, 4.3, 4.4, 4.5, 4.6, 4.7, 4.8, 4.9, 5.0};
	private IndexStorer zoomIndexStorer = new IndexStorer(5);
	
	public SettingsEventHandler(Stage owner, TabVBox mainBox, double buttonSize) {
		this.owner = owner;
		this.mainBox = mainBox;
		this.buttonSize = buttonSize;
		this.tabs = mainBox.getTabs();
		generateAlert();
	}
	
	public void generateAlert() {
		settingsAlert = new Alert(Alert.AlertType.CONFIRMATION);
		
		GridPane zoomPane = new GridPane();
		Button zoomOutButton = new Button("-");
		Text zoomText = new Text("100%");
		Button zoomInButton = new Button("+");
		zoomPane.getChildren().add(zoomOutButton);
		zoomPane.getChildren().add(zoomText);
		zoomPane.getChildren().add(zoomInButton);
		GridPane.setColumnIndex(zoomOutButton, 0);
		GridPane.setColumnIndex(zoomText, 1);
		GridPane.setColumnIndex(zoomInButton, 2);
		zoomPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
		zoomPane.getColumnConstraints().add(new ColumnConstraints(50));
		zoomPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
		
		zoomOutButton.setOnAction(new ZoomChangeEventHandler(mainBox, tabs, zoomValues, zoomIndexStorer, ZoomDirection.Out, zoomText));
		zoomInButton.setOnAction(new ZoomChangeEventHandler(mainBox, tabs, zoomValues, zoomIndexStorer, ZoomDirection.In, zoomText));
		
		
		GridPane homePagePane = new GridPane();
		TextField homePageField = new TextField();
		homePageField.setText(mainBox.getHomePage());
		Button setHomePageButton = new Button();
		setHomePageButton.setText("Set Homepage");
		homePagePane.getChildren().add(homePageField);
		homePagePane.getChildren().add(setHomePageButton);
		GridPane.setColumnIndex(homePageField, 0);
		GridPane.setColumnIndex(setHomePageButton, 1);
		zoomPane.getColumnConstraints().add(new ColumnConstraints(100));
		zoomPane.getColumnConstraints().add(new ColumnConstraints(50));
		
		setHomePageButton.setOnAction(null);
		
		
		VBox selectTabVBox = new VBox();
		selectTabVBox.getChildren().add(zoomPane);
		selectTabVBox.getChildren().add(homePageField);
		
		settingsAlert.setTitle("Settings");
		settingsAlert.setHeaderText("");
		settingsAlert.setGraphic(selectTabVBox);
	}
	
	public void setOwner(Stage owner) {
		settingsAlert.initOwner(owner);
	}

	@Override
	public void handle(ActionEvent event) {
		settingsAlert.showAndWait();
		
	}
}
