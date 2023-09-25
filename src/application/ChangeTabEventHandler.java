package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class ChangeTabEventHandler implements EventHandler<ActionEvent> {
	private Tab tab;
	private TabVBox mainBox;

	public ChangeTabEventHandler(Tab tab, TabVBox mainBox) {
		super();
		this.tab = tab;
		this.mainBox = mainBox;
	}

	@Override
	public void handle(ActionEvent arg0) {
		mainBox.switchTab(tab);
	}

}
