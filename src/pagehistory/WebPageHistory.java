package pagehistory;

/** 
 * PageList stores the history of the user in the web browser.
 * <p>
 * 
 * The website history of the user is stored as a recursive list.
 */
public class WebPageHistory {
	/**
	 * The first website the user went to in this session.
	 */
	private Webpage first;
	/**
	 * The current website that the user is on.
	 */
	private Webpage current;
	
	/**
	 * Creates a new WebHistory starting at the current webpage.
	 * 
	 * @param webPage The current webpage the user is on.
	 */
	public WebPageHistory(Webpage webPage) {
		this.first = webPage;
		this.current = webPage;
	}

	/**
	 * Gets the value of the url of the first webpage.
	 * 
	 * @return The url of the first webpage.
	 */
	public String getFirstUrl() {
		return first.getUrl();
	}

	/**
	 * Gets the value of the url of the current webpage.
	 * 
	 * @return The url of the current webpage.
	 */
	public String getCurrentUrl() {
		return current.getUrl();
	}

	/**
	 * Adds a new website to the history.
	 * <p>
	 * Adds a new website to the history right after the current website, any history after the current website is lost.
	 * 
	 * @param nextUrl The url of the website to be added to the history.
	 */
	public void addNext(String nextUrl) {
		Webpage next = new Webpage(nextUrl);
		this.current.setNext(next);
		this.current = next;
	}
	
	/**
	 * Gets the number of websites in the history.
	 * 
	 * 
	 * @return The number of websites in the history
	 */
	public int getSize() {
		Webpage tempCurrent = first.getNext();
		// minimum size is 1.
		int size = 1;
		// the loop will only start if there is at least two webpages
		while (tempCurrent != null) {
			tempCurrent = tempCurrent.getNext();
			size++;
		}
		return size;
	}
	
	/**
	 * Changes the current website to be the next website in the history.
	 * <p>
	 * 
	 * If there is not a next website in the history, then nothing happens.
	 */
	public void goForward() {
		if (current.getNext() != null) {
			current = current.getNext();
		}
	}
	
	/**
	 * Changes the current website to be the next website in the history.
	 * <p>
	 * 
	 * If there is not a previous website in the history, then nothing happens.
	 */
	public void goBack() {
		if (!current.equals(first)) {
			Webpage tempCurrent = first;
			while (!tempCurrent.getNext().equals(current)) {
				tempCurrent = tempCurrent.getNext();
			}
			current = tempCurrent;
		}
	}
}
