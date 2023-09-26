package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class LoadEnterEventHandler implements EventHandler<KeyEvent> {
	private LoadEventHandler loadEventHandler;
	
	public LoadEnterEventHandler(LoadEventHandler loadEventHandler) {
		this.loadEventHandler = loadEventHandler;
	}
	

	@Override
	public void handle(KeyEvent event) {
		if (event.getCode().toString().equals("ENTER")) {
			loadEventHandler.handle(new ActionEvent());
		}
	}

}
