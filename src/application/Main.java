package application;
	
import java.io.*;

import javafx.application.Application;
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
import javafx.scene.web.WebView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;


public class Main extends Application {
	private static final double buttonSize = 10;
	private static final String imagePath = "images/";
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ImageView backArrow = new ImageView(new Image(new FileInputStream(new File(imagePath + "backArrow.png"))));
			backArrow.setFitWidth(buttonSize);
			backArrow.setFitHeight(buttonSize);
			Button backButton = new Button("", backArrow);
			
			
			ImageView forwardArrow = new ImageView(new Image(new FileInputStream(new File(imagePath + "forwardArrow.png"))));
			forwardArrow.setFitWidth(buttonSize);
			forwardArrow.setFitHeight(buttonSize);
			Button forwardButton = new Button("", forwardArrow);
			
			TextField websiteInputField = new TextField();
			websiteInputField.setPromptText("Search with DuckDuckGo or enter address");
			
			Button launchButton = new Button();
			launchButton.setText("launch");
			
			GridPane controlPane = new GridPane();
			controlPane.getChildren().add(backButton);
			controlPane.getChildren().add(forwardButton);
			controlPane.getChildren().add(websiteInputField);
			controlPane.getChildren().add(launchButton);
			GridPane.setColumnIndex(backButton, 0);
			GridPane.setColumnIndex(forwardButton, 1);
			GridPane.setColumnIndex(websiteInputField, 2);
			GridPane.setColumnIndex(launchButton, 3);
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize*3));
			controlPane.getColumnConstraints().add(new ColumnConstraints(buttonSize*3));
			controlPane.getColumnConstraints().add(new ColumnConstraints(400));
			controlPane.getColumnConstraints().add(new ColumnConstraints(80));
			
			
			HBox controlPanel = new HBox();
			controlPanel.getChildren().add(controlPane);
			
			// web view is the visual representation of the website
			WebView currentWebsite = new WebView();
			// web engine is the back end loading of the website
			currentWebsite.getEngine().load("https://www.duckduckgo.com");
			
			VBox root = new VBox();
			root.getChildren().add(controlPanel);
			root.getChildren().add(currentWebsite);
			
			// apparently growth parameters are important
			VBox.setVgrow(currentWebsite, Priority.ALWAYS);
			HBox.setHgrow(websiteInputField, Priority.ALWAYS);
			
			
			Scene scene = new Scene(root);
			
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
