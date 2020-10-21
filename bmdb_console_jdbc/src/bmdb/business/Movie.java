package bmdb.business;

public class Movie {

	// Field declaration
	private long id;
	private String title;
	private int year;
	private String rating;
	private String director;

	// Constructors
	private Movie() {
		id = 0;
		title = "";
		year = 0;
		rating = "";
		director = "";
	}

	public Movie(long id, String title, int year, String rating, String director) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.director = director;
	}

	// Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	// Override toString method
	@Override
	public String toString() {
		return "Movie [id= " + id + ", title= " + title + ", year= " + year + ", rating= " + rating + ", director= "
				+ director + "]";
	}

}
