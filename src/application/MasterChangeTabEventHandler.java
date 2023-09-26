package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class MasterChangeTabEventHandler implements EventHandler<ActionEvent> {
	private ComboBox<Tab> selectTabBox;
	private TabStorer currentTabStorer;

	public MasterChangeTabEventHandler(ComboBox<Tab> selectTabBox, TabStorer currentTabStorer) {
		this.selectTabBox = selectTabBox;
		this.currentTabStorer = currentTabStorer;
	}

	@Override
	public void handle(ActionEvent event) {
		Tab selectedTab = selectTabBox.getValue();
		if (selectedTab != null && !selectedTab.equals(currentTabStorer.getTab())) {
			selectedTab.getTabButton().getOnAction().handle(event);
		}
	}
}
