package application;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BookmarkAddEventHandler implements EventHandler<ActionEvent> {
	private File bookmarksFile;
	private TabStorer currentTabStorer;
	
	public BookmarkAddEventHandler(String bookmarksFileName, TabStorer currentTabStorer) {
		this.bookmarksFile = new File(bookmarksFileName);
		this.currentTabStorer = currentTabStorer;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			ArrayList<String> outputStrings = new ArrayList<String>();
			
			if (!bookmarksFile.createNewFile()) {
				Scanner scanner = new Scanner(bookmarksFile);
				while (scanner.hasNext()) {
					outputStrings.add(scanner.nextLine());
				}
				scanner.close();
			}
			
			
			// need to ask for user to name file here
			String bookmarkName = "tempName";
			String bookmarkUrl = currentTabStorer.getTab().getWebsiteBackEnd().getLocation();
			outputStrings.add(bookmarkUrl + " " + bookmarkName);
			
			
			PrintStream outputStream = new PrintStream(bookmarksFile);
			for (String outputString : outputStrings) {
				outputStream.println(outputString);
			}
			outputStream.close();
		}
		catch (Exception error) {
			System.out.println("Warning: Unable to edit the bookmarks");
		}
	}
	
	
}
