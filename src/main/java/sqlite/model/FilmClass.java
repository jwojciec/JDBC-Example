package sqlite.model;

public class FilmClass {
	int film_ID = 0;
	String title = null;
	String release = null;
	String director = null;
	String genre = null;

	public FilmClass(int film_ID, String title, String release,
			String director, String genre) {
		super();
		this.film_ID = film_ID;
		this.title = title;
		this.release = release;
		this.director = director;
		this.genre = genre;
	}

	public int getfilm_ID() {
		return film_ID;
	}

	public String gettitle() {
		return title;
	}

	public String getrelease() {
		return release;
	}

	public String getdirector() {
		return director;
	}

	public String getgenre() {
		return genre;
	}

	public void setfilm_ID(int film_ID) {
		this.film_ID = film_ID;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public void setrelease(String release) {
		this.release = release;
	}

	public void setdirector(String director) {
		this.director = director;
	}

	public void setgenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "FilmClass [film_ID=" + film_ID + ", title=" + title
				+ ", release=" + release + ", director=" + director
				+ ", genre=" + genre + "]";
	}
}
