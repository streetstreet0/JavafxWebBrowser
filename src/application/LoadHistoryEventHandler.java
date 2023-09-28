package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;

public class LoadHistoryEventHandler implements EventHandler<ActionEvent> {
	private TabStorer currentTabStorer;
	private ComboBox<HistoryItem> historyBox;
	private Alert loadHistoryAlert;
	
	public LoadHistoryEventHandler(TabStorer currentTabStorer, CustomModifiableObservableList<HistoryItem> history) {
		this.currentTabStorer = currentTabStorer;
		generateAlert(history);
	}

	private void generateAlert(CustomModifiableObservableList<HistoryItem> history) {
		loadHistoryAlert = new Alert(Alert.AlertType.CONFIRMATION);
		loadHistoryAlert.setTitle("Load History");
		loadHistoryAlert.setHeaderText("");
		VBox alertBox = new VBox();
		loadHistoryAlert.setGraphic(alertBox);
		
		historyBox = new ComboBox<HistoryItem>(history);
		historyBox.setPromptText("Select Url");
		alertBox.getChildren().add(historyBox);
	}

	@Override
	public void handle(ActionEvent event) {
		loadHistoryAlert.showAndWait();
		if (loadHistoryAlert.getResult().getText().toString().equals("Cancel") || historyBox.getValue() == null) {
			return;
		}
		currentTabStorer.getTab().getWebsiteBackEnd().load(historyBox.getValue().getUrl());
	}

}
