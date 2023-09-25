package application;
	
import java.io.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;


public class Main extends Application {
	private static final double buttonImageSize = 10;
	private static final double buttonSize = 30;
	private static final String imagePath = "images/";
	private static final String homePage = "https://www.duckduckgo.com";
	private ArrayList<TabButton> tabButtons;
	public TabStorer currentTabStorer;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			// initialise these variables now, add their fields to them later
			currentTabStorer = new TabStorer();
			TabVBox mainBox = new TabVBox(currentTabStorer);
			
			
			
			
			ImageView backArrow = new ImageView(new Image(new FileInputStream(new File(imagePath + "backArrow.png"))));
			backArrow.setFitWidth(buttonImageSize);
			backArrow.setFitHeight(buttonImageSize);
			Button backButton = new Button("", backArrow);
			
			
			ImageView forwardArrow = new ImageView(new Image(new FileInputStream(new File(imagePath + "forwardArrow.png"))));
			forwardArrow.setFitWidth(buttonImageSize);
			forwardArrow.setFitHeight(buttonImageSize);
			Button forwardButton = new Button("", forwardArrow);
			
			ImageView homeSymbol = new ImageView(new Image(new FileInputStream(new File(imagePath + "homeSymbol.png"))));
			homeSymbol.setFitWidth(buttonImageSize);
			homeSymbol.setFitHeight(buttonImageSize);
			Button homeButton = new Button("", homeSymbol);
			
			ImageView reloadSymbol = new ImageView(new Image(new FileInputStream(new File(imagePath + "reloadSymbol.png"))));
			reloadSymbol.setFitWidth(buttonImageSize);
			reloadSymbol.setFitHeight(buttonImageSize);
			Button reloadButton = new Button("", reloadSymbol);
			
			TextField websiteInputField = new TextField();
			websiteInputField.setPromptText("Search with DuckDuckGo or enter address");
			mainBox.setTextField(websiteInputField);
			
			Button launchButton = new Button();
			launchButton.setText("launch");
			
			GridPane controlPane = new GridPane();
			controlPane.getChildren().add(backButton);
			controlPane.getChildren().add(forwardButton);
			controlPane.getChildren().add(homeButton);
			controlPane.getChildren().add(reloadButton);
			controlPane.getChildren().add(websiteInputField);
			controlPane.getChildren().add(launchButton);
			GridPane.setColumnIndex(backButton, 0);
			GridPane.setColumnIndex(forwardButton, 1);
			GridPane.setColumnIndex(homeButton, 2);
			GridPane.setColumnIndex(reloadButton, 3);
			GridPane.setColumnIndex(websiteInputField, 4);
			GridPane.setColumnIndex(launchButton, 5);
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(400));
			controlPane.getColumnConstraints().add(new ColumnConstraints(80));
			
			
			HBox controlPanel = new HBox();
			controlPanel.getChildren().add(controlPane);
			
			WebView websiteVisual = new WebView();
			WebEngine websiteBackEnd = websiteVisual.getEngine();
			websiteBackEnd.load(homePage);
			WebHistory history = websiteVisual.getEngine().getHistory();
			
			backButton.setOnAction(new HistoryEventHandler(currentTabStorer, Direction.BACK, websiteInputField));
			forwardButton.setOnAction(new HistoryEventHandler(currentTabStorer, Direction.FORWARDS, websiteInputField));
			homeButton.setOnAction(new HomeEventHandler(currentTabStorer, homePage, websiteInputField));
			reloadButton.setOnAction(new ReloadEventHandler(currentTabStorer, websiteInputField));
			launchButton.setOnAction(new LoadEventHandler(currentTabStorer, websiteInputField));
			
			
			
			
			tabButtons = new ArrayList<TabButton>();
			Tab defaultTab = new Tab(homePage);
			currentTabStorer.setTab(defaultTab);
			mainBox.setInitialTab(defaultTab);
			//mainBox.switchTab(defaultTab);
			TabButton defaultTabButton = new TabButton(defaultTab, mainBox);
			tabButtons.add(defaultTabButton);
			
			ImageView addTabSymbol = new ImageView(new Image(new FileInputStream(new File(imagePath + "addTabSymbol.png"))));
			addTabSymbol.setFitWidth(buttonImageSize);
			addTabSymbol.setFitHeight(buttonImageSize);
			Button addTabButton = new Button("", addTabSymbol);
			
			
			GridPane tabPane = new GridPane();
			tabPane.getChildren().add(defaultTabButton);
			tabPane.getChildren().add(addTabButton);
			GridPane.setColumnIndex(defaultTabButton, 0);
			GridPane.setColumnIndex(addTabButton, 1);
			
			HBox tabPanel = new HBox();
			tabPanel.getChildren().add(tabPane);
			
			
			mainBox.getChildren().add(controlPanel);
			mainBox.getChildren().add(tabPanel);
			mainBox.getChildren().add(websiteVisual);
			
			addTabButton.setOnAction(new AddTabEventHandler(tabButtons, homePage, tabPane, addTabButton, mainBox));
			
			
			
			
			// apparently growth parameters are important
			VBox.setVgrow(websiteVisual, Priority.ALWAYS);
			HBox.setHgrow(websiteInputField, Priority.ALWAYS);
			
			
			Scene scene = new Scene(mainBox);
			
			primaryStage.getIcons().add(new Image(new FileInputStream(new File(imagePath + "icon.gif"))));
			primaryStage.setTitle("Lobster Web Browser");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
