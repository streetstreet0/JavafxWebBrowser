package application;

import java.util.Date;

import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;

public class HistoryItem {
	private String url;
	private WebHistory.Entry historyEntry;
	
	public HistoryItem(Entry historyEntry) {
		this.url = historyEntry.getUrl();
		this.historyEntry = historyEntry;
	}
	
	
	public String getUrl() {
		return url;
	}
	public WebHistory.Entry getHistoryEntry() {
		return historyEntry;
	}
	
	public void setHistoryEntry(WebHistory.Entry historyEntry) {
		this.historyEntry = historyEntry;
		this.url = historyEntry.getUrl();
	}
	
	@Override
	public String toString() {
		String timeWords;
		if (historyEntry.getLastVisitedDate() == null) {
			timeWords = new Date().toString();
			System.out.println("null");
		}
		else {
			timeWords = historyEntry.getLastVisitedDate().toString();
		}
		return this.url + " : " + timeWords;
	}
}
