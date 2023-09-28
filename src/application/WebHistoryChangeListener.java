package application;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;

public class WebHistoryChangeListener implements ListChangeListener<WebHistory.Entry> {
	private ObservableList<WebHistory.Entry> history;
	private TextField urlTextField;

	public WebHistoryChangeListener(ObservableList<Entry> history, TextField urlTextField) {
		this.history = history;
		this.urlTextField = urlTextField;
	}

	@Override
	public void onChanged(Change<? extends Entry> change) {
		change.next();
		if (!change.wasAdded()) {
			return;
		}
		WebHistory.Entry newPage = change.getAddedSubList().get(0);
		if (history.contains(newPage)) {
			history.remove(newPage);
		}
		history.add(newPage);
		if (true) {
			urlTextField.setText(newPage.getUrl());
		}
		System.out.println(history.size());
	}

}
