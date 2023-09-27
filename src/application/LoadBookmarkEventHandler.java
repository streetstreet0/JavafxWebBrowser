package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoadBookmarkEventHandler implements EventHandler<ActionEvent> {
	private TabStorer currentTabStorer;
	private Alert selectBookmarkAlert;
	private ComboBox<Bookmark> bookmarkBox;
	private CustomModifiableObservableList<Bookmark> bookmarks;
	
	
	public LoadBookmarkEventHandler(TabStorer currentTabStorer, Stage owner, CustomModifiableObservableList<Bookmark> bookmarks) {
		this.currentTabStorer = currentTabStorer;
		this.bookmarks = bookmarks;
		generateAlert();
	}

	public void generateAlert() {
		selectBookmarkAlert = new Alert(Alert.AlertType.CONFIRMATION);
		VBox selectTabVBox = new VBox();
		bookmarkBox = new ComboBox<Bookmark>(bookmarks);
		selectTabVBox.getChildren().add(bookmarkBox);
		selectBookmarkAlert.setTitle("Select Bookmark");
		selectBookmarkAlert.setHeaderText("");
		selectBookmarkAlert.setGraphic(selectTabVBox);
	}
	
	public void setOwner(Stage owner) {
		selectBookmarkAlert.initOwner(owner);
	}

	@Override
	public void handle(ActionEvent event) {
		selectBookmarkAlert.showAndWait();
		Bookmark bookmark = bookmarkBox.getValue();
		if (selectBookmarkAlert.getResult().getText().equals("Cancel") || bookmark == null) {
			return;
		}
		currentTabStorer.getTab().getWebsiteBackEnd().load(bookmark.getUrl());
	}
}
