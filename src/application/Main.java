package application;
	
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.collections.*;


public class Main extends Application {
	private static final double buttonImageSize = 10;
	private static final double buttonSize = 30;
	private static final String imagePath = "images/";
	private static final String homePage = "https://www.duckduckgo.com";
	private static final String bookmarksFilePath = "misc/bookmarks";
	private CustomModifiableObservableList<Tab> tabsList;
	private TabStorer currentTabStorer;
	private ComboBox<Tab> selectTabBox;
	CustomModifiableObservableList<Bookmark> bookmarks;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			loadBookmarks(bookmarksFilePath);
			// initialise these variables now, add their fields to them later
			currentTabStorer = new TabStorer();
			tabsList = new CustomModifiableObservableList<Tab>();
			TabVBox mainBox = new TabVBox(currentTabStorer, tabsList, homePage);
			
			
			
			
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
			
//			Button launchButton = new Button();
//			launchButton.setText("launch");
			
			ImageView selectTabSymbol = new ImageView(new Image(new FileInputStream(new File(imagePath + "selectTabSymbol.png"))));
			selectTabSymbol.setFitWidth(buttonImageSize);
			selectTabSymbol.setFitHeight(buttonImageSize);
			Button selectTabButton = new Button("", selectTabSymbol);
			
			selectTabBox = new ComboBox<Tab>(tabsList);
			selectTabBox.setPromptText("Select Tab");
			mainBox.setSelectTabBox(selectTabBox);
			
			ImageView addBookmarkSymbol = new ImageView(new Image(new FileInputStream(new File(imagePath + "addBookmarkSymbol.png"))));
			addBookmarkSymbol.setFitWidth(buttonImageSize);
			addBookmarkSymbol.setFitHeight(buttonImageSize);
			Button addBookmarkButton = new Button("", addBookmarkSymbol);
			
			ImageView loadBookmarkSymbol = new ImageView(new Image(new FileInputStream(new File(imagePath + "loadBookmarkSymbol.png"))));
			loadBookmarkSymbol.setFitWidth(buttonImageSize);
			loadBookmarkSymbol.setFitHeight(buttonImageSize);
			Button loadBookmarkButton = new Button("", loadBookmarkSymbol);
			
			ImageView historySymbol = new ImageView(new Image(new FileInputStream(new File(imagePath + "historySymbol.png"))));
			historySymbol.setFitWidth(buttonImageSize);
			historySymbol.setFitHeight(buttonImageSize);
			Button historyButton = new Button("", historySymbol);
			
			ImageView settingsSymbol = new ImageView(new Image(new FileInputStream(new File(imagePath + "settingsSymbol.png"))));
			settingsSymbol.setFitWidth(buttonImageSize);
			settingsSymbol.setFitHeight(buttonImageSize);
			Button settingsButton = new Button("", settingsSymbol);
			
			GridPane controlPane = new GridPane();
			controlPane.getChildren().add(backButton);
			controlPane.getChildren().add(forwardButton);
			controlPane.getChildren().add(homeButton);
			controlPane.getChildren().add(reloadButton);
			controlPane.getChildren().add(websiteInputField);
			controlPane.getChildren().add(addBookmarkButton);
			controlPane.getChildren().add(selectTabButton);
			controlPane.getChildren().add(loadBookmarkButton);
			controlPane.getChildren().add(historyButton);
			controlPane.getChildren().add(settingsButton);
			GridPane.setColumnIndex(backButton, 0);
			GridPane.setColumnIndex(forwardButton, 1);
			GridPane.setColumnIndex(homeButton, 2);
			GridPane.setColumnIndex(reloadButton, 3);
			GridPane.setColumnIndex(websiteInputField, 4);
			GridPane.setColumnIndex(addBookmarkButton, 5);
			GridPane.setColumnIndex(selectTabButton, 6);
			GridPane.setColumnIndex(loadBookmarkButton, 7);
			GridPane.setColumnIndex(historyButton, 8);
			GridPane.setColumnIndex(settingsButton, 9);
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(600));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize));
			
			
			HBox controlPanel = new HBox();
			controlPanel.getChildren().add(controlPane);
			
			backButton.setOnAction(new HistoryEventHandler(currentTabStorer, Direction.BACK, websiteInputField));
			forwardButton.setOnAction(new HistoryEventHandler(currentTabStorer, Direction.FORWARDS, websiteInputField));
			homeButton.setOnAction(new HomeEventHandler(currentTabStorer, homePage, websiteInputField));
			reloadButton.setOnAction(new ReloadEventHandler(currentTabStorer, websiteInputField));
//			launchButton.setOnAction(new LoadEventHandler(currentTabStorer, websiteInputField));
//			websiteInputField.setOnKeyPressed(new LoadEnterEventHandler((LoadEventHandler)launchButton.getOnAction()));
			websiteInputField.setOnKeyPressed(new LoadEnterEventHandler(new LoadEventHandler(currentTabStorer, websiteInputField)));
			
			
			ImageView addTabSymbol = new ImageView(new Image(new FileInputStream(new File(imagePath + "addTabSymbol.png"))));
			addTabSymbol.setFitWidth(buttonImageSize);
			addTabSymbol.setFitHeight(buttonImageSize);
			Button addTabButton = new Button("", addTabSymbol);
			mainBox.setAddTabButton(addTabButton);
			
			
			
			Tab defaultTab = new Tab(homePage, websiteInputField);
			
			GridPane tabPane = new GridPane();
			mainBox.setTabPane(tabPane);
			
			// default tab must be mad after the tabPane is added the mainBox
			TabButton defaultTabButton = new TabButton(defaultTab, mainBox, websiteInputField);
			tabsList.add(defaultTabButton.getTab());
			
			
			tabPane.getChildren().add(defaultTabButton);
			tabPane.getChildren().add(addTabButton);
			GridPane.setColumnIndex(defaultTabButton, 0);
			GridPane.setColumnIndex(addTabButton, 1);
			
			
			HBox tabPanel = new HBox();
			tabPanel.getChildren().add(tabPane);
			
			
			mainBox.getChildren().add(controlPanel);
			mainBox.getChildren().add(tabPanel);
			mainBox.setInitialTab(defaultTab);
			
			addTabButton.setOnAction(new AddTabEventHandler(mainBox, websiteInputField));
			// switches the tab to the default tab
			defaultTabButton.getOnAction().handle(new ActionEvent());
			
			addBookmarkButton.setOnAction(new BookmarkAddEventHandler(bookmarksFilePath, currentTabStorer, primaryStage, bookmarks));
			selectTabButton.setOnAction(new SelectTabEventHandler(selectTabBox, primaryStage, currentTabStorer));
			loadBookmarkButton.setOnAction(new LoadBookmarkEventHandler(currentTabStorer, primaryStage, bookmarks));
			
			// this webview is here just so the window will be the right size
			WebView webVisual = new WebView();
			webVisual.getEngine().load(homePage);
			
			
			
			// apparently growth parameters are important
			VBox.setVgrow(defaultTab.getWebsiteVisual(), Priority.ALWAYS);
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
	
	public void loadBookmarks(String filePath) {
		bookmarks = new CustomModifiableObservableList<Bookmark>();
		try {
			File bookmarksFile = new File(filePath);
			if (!bookmarksFile.createNewFile()) {
				Scanner scanner = new Scanner(bookmarksFile);
				while (scanner.hasNext()) {
					String bookmarkUrl = scanner.next().trim();
					String bookmarkName = scanner.nextLine().trim();
					bookmarks.add(new Bookmark(bookmarkName, bookmarkUrl));
				}
				scanner.close();
			}
		}
		catch (IOException error) {
			Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			errorAlert.setHeaderText("Error: misc folder does not exist.");
			errorAlert.setContentText("You will be unable to edit or open bookmarks until this is fixed.");
			errorAlert.showAndWait();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
