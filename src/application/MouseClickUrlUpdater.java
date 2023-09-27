package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MouseClickUrlUpdater implements EventHandler<MouseEvent> {
	private Tab tab;
	private TextField textField;

	public MouseClickUrlUpdater(Tab tab, TextField textField) {
		this.tab = tab;
		this.textField = textField;
	}

	@Override
	public void handle(MouseEvent event) {
		textField.setText(tab.getWebsiteBackEnd().getLocation());
	}
	
}
