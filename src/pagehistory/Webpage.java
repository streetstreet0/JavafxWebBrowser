package pagehistory;

/**
 * Webpage is used to stores the url in a PageList
 * <p>
 * 
 * Webpage stores the url of the website and the Webpage object for the next website in the history list. 
 * If next is null, this is the current website.
 */
public class Webpage {
	private String url;
	private Webpage next;
	
	/**
	 * Creates a new Webpage object.
	 * 
	 * @param url The String for the url of the website.
	 */
	public Webpage(String url) {
		this.url = url;
		this.next = null;
	}

	/**
	 * Sets the value of the next Webpage.
	 * 
	 * @param next The next Webpage.
	 * @return The old value for the next Webpage.
	 */
	public Webpage setNext(Webpage next) {
		Webpage oldNext = this.next;
		this.next = next;
		return oldNext;
	}
	
	/**
	 * Sets the value of the url.
	 * 
	 * @param url The url to be set.
	 * @return The old value for the url.
	 */
	public String setUrl(String url) {
		String oldUrl = this.url;
		this.url = url;
		return oldUrl;
	}
	
	/**
	 * Gets the value of the next Webpage.
	 * 
	 * @return The value for the next Webpage.
	 */
	public Webpage getNext() {
		return this.next;
	}
	
	/**
	 * Gets the value of the url.
	 * 
	 * @return The value for the next Webpage.
	 */
	public String getUrl() {
		return this.url;
	}
}
