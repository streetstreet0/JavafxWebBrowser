package application;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class EnterKeyUrlUpdater implements EventHandler<KeyEvent> {
	private Tab tab;
	private TextField textField;

	public EnterKeyUrlUpdater(Tab tab, TextField textField) {
		this.tab = tab;
		this.textField = textField;
	}

	@Override
	public void handle(KeyEvent event) {
		if (event.getCode().toString().equals("ENTER")) {
			textField.setText(tab.getWebsiteBackEnd().getLocation());
		}
	}
}
