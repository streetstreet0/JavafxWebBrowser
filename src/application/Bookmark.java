package application;

public class Bookmark {
	private String name;
	private String url;
	
	public Bookmark(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
