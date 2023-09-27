package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class ZoomChangeEventHandler implements EventHandler<ActionEvent> {
	private TabVBox mainBox;
	private Text zoomText;
	private CustomModifiableObservableList<Tab> tabs;
	private double[] zoomValues;
	private IndexStorer zoomIndexStorer;
	private ZoomDirection zoomDirection;
	
	public ZoomChangeEventHandler(TabVBox mainBox, CustomModifiableObservableList<Tab> tabs,
			double[] zoomValues, IndexStorer zoomIndexStorer, ZoomDirection zoomDirection, Text zoomText) {
		this.mainBox = mainBox;
		this.zoomText = zoomText;
		this.tabs = tabs;
		this.zoomValues = zoomValues;
		this.zoomIndexStorer = zoomIndexStorer;
		this.zoomDirection = zoomDirection;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (zoomDirection == ZoomDirection.Out) {
			zoomIndexStorer.setIndex(Math.max(zoomIndexStorer.getIndex()-1, 0));
		}
		else if (zoomDirection == ZoomDirection.In) {
			zoomIndexStorer.setIndex(Math.min(zoomIndexStorer.getIndex()+1, zoomValues.length-1));
		}
		double zoom = zoomValues[zoomIndexStorer.getIndex()];
		for (Tab tab : tabs) {
			tab.getWebsiteVisual().setZoom(zoom);
		}
		mainBox.setZoom(zoomValues[zoomIndexStorer.getIndex()]);
		zoomText.setText(((int)(zoom * 100)) + "%");
	}
}
