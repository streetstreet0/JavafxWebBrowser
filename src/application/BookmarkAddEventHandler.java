package application;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookmarkAddEventHandler implements EventHandler<ActionEvent> {
	private File bookmarksFile;
	private TabStorer currentTabStorer;
	private Stage owner;
	private CustomModifiableObservableList<Bookmark> bookmarks;
	
	public BookmarkAddEventHandler(String bookmarksFileName, TabStorer currentTabStorer, Stage owner, CustomModifiableObservableList<Bookmark> bookmarks) {
		this.bookmarksFile = new File(bookmarksFileName);
		this.currentTabStorer = currentTabStorer;
		this.owner = owner;
		this.bookmarks = bookmarks;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			ArrayList<String> outputStrings = new ArrayList<String>();
			for (Bookmark bookmark : bookmarks) {
				outputStrings.add(bookmark.getUrl() + " " + bookmark.getName());
			}
			
			String bookmarkUrl = currentTabStorer.getTab().getWebsiteBackEnd().getLocation();
			// need to ask for user to name file here
			String bookmarkName = addBookmarkAlert(bookmarkUrl);
			if (bookmarkName == null) {
				return;
			}
			
			outputStrings.add(bookmarkUrl + " " + bookmarkName);
			bookmarks.add(new Bookmark(bookmarkName, bookmarkUrl));
			
			PrintStream outputStream = new PrintStream(bookmarksFile);
			for (String outputString : outputStrings) {
				outputStream.println(outputString);
			}
			outputStream.close();
		}
		catch (Exception error) {
			Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			errorAlert.setHeaderText("Error: Bookmarks file destination does not exist.");
			errorAlert.setContentText("You will be unable to edit bookmarks until this is fixed.");
			errorAlert.showAndWait();
		}
	}
	
	public String addBookmarkAlert(String bookmarkUrl) {
		Alert addBookmarkAlert = new Alert(Alert.AlertType.CONFIRMATION); 
		addBookmarkAlert.setTitle("Add Bookmark:");
		addBookmarkAlert.setHeaderText("");
		addBookmarkAlert.initOwner(owner);
		
		
		VBox alertVBox = new VBox();
		GridPane topPane = new GridPane();
		GridPane bottomPane = new GridPane();
		
		
		Text nameText = new Text("Bookmark name:");
		topPane.getChildren().add(nameText);
		Text urlText = new Text("Url:");
		topPane.getChildren().add(urlText);
		GridPane.setColumnIndex(nameText, 0);
		GridPane.setColumnIndex(urlText, 1);
		topPane.getColumnConstraints().add(new ColumnConstraints(200));
		topPane.getColumnConstraints().add(new ColumnConstraints(200));
		
		
		TextField bookmarkNameField = new TextField();
		bookmarkNameField.setPromptText("Bookmark Name");
		bookmarkNameField.setMaxWidth(150);
		bookmarkNameField.setPrefWidth(150);
		bottomPane.getChildren().add(bookmarkNameField);
		Text bookmarkUrlText = new Text(bookmarkUrl);
		bottomPane.getChildren().add(bookmarkUrlText);
		GridPane.setColumnIndex(bookmarkNameField, 0);
		GridPane.setColumnIndex(bookmarkUrlText, 1);
		bottomPane.getColumnConstraints().add(new ColumnConstraints(200));
		bottomPane.getColumnConstraints().add(new ColumnConstraints(200));
		
		
		alertVBox.getChildren().add(topPane);
		alertVBox.getChildren().add(bottomPane);
		alertVBox.setMaxWidth(400);
		alertVBox.setPrefWidth(400);
		addBookmarkAlert.setGraphic(alertVBox);
		addBookmarkAlert.setWidth(400);
		addBookmarkAlert.showAndWait();
		
		while (bookmarkNameField.getText().trim().equals("")) {
			if (addBookmarkAlert.getResult().getText().equals("Cancel")) {
				return null;
			}
			Alert illegalInputAlert = new Alert(Alert.AlertType.ERROR);
			illegalInputAlert.setHeaderText("The name of the bookmark cannot be left blank.");
			illegalInputAlert.initOwner(owner);
			illegalInputAlert.showAndWait();
			addBookmarkAlert.showAndWait();
		}
		
		// this is here in case the user has typed a valid input before clicking cancel
		if (addBookmarkAlert.getResult().getText().equals("Cancel")) {
			return null;
		}
		return bookmarkNameField.getText().trim();
	}
}
