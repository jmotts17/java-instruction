
public class Album extends Product {

	// Fields
	private String artist;

	// Constructors
	public Album() {
		super();
		artist = "";
		count++;
	}

	// Getters and Setters
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	// toString override
	@Override
	public String toString() {
		return super.toString() + " (" + this.artist + ")";
	}

}
