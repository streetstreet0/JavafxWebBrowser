package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;

public class LoadEventHandler implements EventHandler<ActionEvent> {
	private TextField textField;
	private WebEngine websiteBackEnd;

	public LoadEventHandler(TextField textField, WebEngine websiteBackEnd) {
		this.textField = textField;
		this.websiteBackEnd = websiteBackEnd;
	}

	@Override
	public void handle(ActionEvent event) {
		String url = textField.getText();
		if (url.startsWith("http:/") || url.startsWith("https:/")) {
			// its easier to understand this if statement when this is the first case
			// nothing occurs heres
		}
		else if (url.startsWith("www.")) {
			url = "https:/" + url;
		}
		else {
			// need to encode all of the symbols before we can search
			url = url.replace("%", "%25");
			// % needs to be the first symbol
			// the other symbols are in order going left to right/top to bottom on the keyboard
			// does all the symbols that need shift key first for that row, then those that don't use shift key
			// ~ does not need encoding
			url = url.replace("!", "%21");
			url = url.replace("@", "%40");
			url = url.replace("#", "%23");
			url = url.replace("$", "%24");
			url = url.replace("^", "%5E");
			url = url.replace("&", "%26");
			url = url.replace("*", "%2A");
			url = url.replace("(", "%28");
			url = url.replace(")", "%29");
			url = url.replace("(", "%28");
			// _ does not need encoding
			url = url.replace("+", "%2B");
			url = url.replace("`", "%60");
			// - does not need encoding
			url = url.replace("=", "%3D");
			url = url.replace("{", "%7B");
			url = url.replace("}", "%7D");
			url = url.replace("|", "%7C");
			url = url.replace("[", "%5B");
			url = url.replace("]", "%5D");
			// note: \\ means \. \ has another meaning in strings, so single \ won't work
			url = url.replace("\\", "%5C");
			url = url.replace(":", "%3A");
			// note: \" puts " inside a string
			url = url.replace("\"", "%22");
			url = url.replace(";", "%3B");
			// note: \' puts ' inside a string
			url = url.replace("\'", "%27");
			url = url.replace("<", "%3C");
			url = url.replace(">", "%3E");
			url = url.replace("?", "%3F");
			url = url.replace(",", "%2C");
			// . does not need encoding
			url = url.replace("/", "%2F");
			url = url.replace(" ", "%20");
			// now try to search
			url = "https:/www.duckduckgo.com/?t=ffab&q=" + url + "&ia=web";
		}
		websiteBackEnd.load(url);
		textField.setText(websiteBackEnd.getLocation());
	}

}
