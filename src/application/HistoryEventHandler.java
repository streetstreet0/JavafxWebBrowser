package application;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.event.ActionEvent;

public class HistoryEventHandler implements EventHandler<ActionEvent> {
	private WebHistory history;
	private Direction direction;
	private TextField textField;
	private WebEngine websiteBackEnd;
	
	public HistoryEventHandler(WebHistory history, Direction direction, TextField textField, WebEngine websiteBackEnd) {
		this.history = history;
		this.direction = direction;
		this.textField = textField;
		this.websiteBackEnd = websiteBackEnd;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (direction == Direction.FORWARDS) {
			if (history.getCurrentIndex() < history.getEntries().size() - 1) {
				history.go(1);
			}
		}
		else if (direction == Direction.BACK) {
			if (history.getCurrentIndex() > 0) {
				history.go(-1);
			}
		}
		textField.setText(websiteBackEnd.getLocation());
	}

}
