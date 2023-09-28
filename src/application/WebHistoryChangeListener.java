package application;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;

public class WebHistoryChangeListener implements ListChangeListener<WebHistory.Entry> {
	private ObservableList<WebHistory.Entry> history;
	private TextField urlTextField;
	private Tab tab;

	public WebHistoryChangeListener(ObservableList<Entry> history, TextField urlTextField, Tab tab) {
		this.history = history;
		this.urlTextField = urlTextField;
		this.tab = tab;
	}

	@Override
	public void onChanged(Change<? extends Entry> event) {
		if (!event.wasAdded()) {
			return;
		}
		WebHistory.Entry newPage = event.getAddedSubList().get(0);
		if (history.contains(newPage)) {
			history.remove(newPage);
		}
		history.add(newPage);
		if (true) {
			urlTextField.setText(newPage.getUrl());
			tab.getTabButton().setText(newPage.getTitle());
		}
	}

}
