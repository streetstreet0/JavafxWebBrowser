package application;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.event.ActionEvent;

public class HistoryEventHandler implements EventHandler<ActionEvent> {
	private TabStorer currentTabStorer;
	private Direction direction;
	private TextField textField;
	
	public HistoryEventHandler(TabStorer currentTabStorer, Direction direction, TextField textField) {
		this.currentTabStorer = currentTabStorer;
		this.direction = direction;
		this.textField = textField;
	}
	
	@Override
	public void handle(ActionEvent event) {
		WebEngine websiteBackEnd = currentTabStorer.getTab().getWebsiteBackEnd();
		WebHistory history = websiteBackEnd.getHistory();
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
