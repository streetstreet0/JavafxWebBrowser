package application;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;

public class WebHistoryChangeListener implements ListChangeListener<WebHistory.Entry> {
	private CustomModifiableObservableList<HistoryItem> history;
	private TextField urlTextField;

	public WebHistoryChangeListener(CustomModifiableObservableList<HistoryItem> history, TextField urlTextField) {
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
		HistoryItem newPageItem = new HistoryItem(newPage);
		if (history.contains(newPageItem)) {
			history.remove(newPageItem);
		}
		history.add(newPageItem);
		if (true) {
			urlTextField.setText(newPage.getUrl());
		}
	}

}
