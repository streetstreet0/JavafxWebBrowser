package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class AltClickTabEventHandler implements EventHandler<MouseEvent> {
	private Tab tab;
	private TabVBox mainBox;
	private GridPane tabPane;
	private Button addTabButton;
	private ComboBox<Tab> selectTabBox;
	private ModifiableObservableTabList tabs;
	private AddTabEventHandler addTabHandler;
	
	public AltClickTabEventHandler(Tab tab, TabVBox mainBox) {
		this.tab = tab;
		this.mainBox = mainBox;
		this.tabPane = mainBox.getTabPane();
		this.addTabButton = mainBox.getAddTabButton();
		this.selectTabBox = mainBox.getSelectTabBox();
		this.tabs = mainBox.getTabs();
		this.addTabHandler = new AddTabEventHandler(mainBox);
	}
	

	@Override
	public void handle(MouseEvent event) {
		if (event.getButton().toString().equals("MIDDLE")) {
			new DeleteTabEventHandler(tab, mainBox).handle(new ActionEvent());
		}
		else if (event.getButton().toString().equals("SECONDARY")) {
			TabButton tabButton = tab.getTabButton();
			tab.getTabButton().getContextMenu().show(tabButton, tabButton.getLayoutX(), tabButton.getLayoutY());
		}
	}
}
