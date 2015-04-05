package sqlite.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteJDBC {

	private String connProperty = null;
	Connection conn = null;
	List<FilmClass> resultList = new ArrayList<FilmClass>();

	public SQLiteJDBC(String connProperty) throws SQLException {
		// get connection
		this.connProperty = connProperty;
		conn = DriverManager.getConnection(this.connProperty);
	}

	public void closeSQLiteJDBC() throws SQLException {
		// close connection
		conn.close();
	}

	public List<FilmClass> getAllFilms() throws SQLException {
		// reset resultList
		resultList.clear();

		// create a statement
		Statement myStmnt = conn.createStatement();

		// execute SQL query
		String myQuery = "SELECT * FROM T_Film";
		ResultSet myRes = myStmnt.executeQuery(myQuery);

		// process result set
		while (myRes.next()) {
			resultList.add(convertToFilmClass(myRes));
		}

		return resultList;
	}

	public List<FilmClass> searchForFilm(String phrase) throws SQLException {
		// reset resultList
		resultList.clear();

		// prepared statement example
		String myQuery = "SELECT * FROM T_Film WHERE Title like ? ";
		PreparedStatement preparedStmt = conn.prepareStatement(myQuery);
		preparedStmt.setString(1, phrase + "%");
		ResultSet myRes = preparedStmt.executeQuery();

		// process result set
		while (myRes.next()) {
			resultList.add(convertToFilmClass(myRes));
		}

		return resultList;
	}

	public FilmClass convertToFilmClass(ResultSet myRes) {

		FilmClass film = null;

		try {
			int film_ID = myRes.getInt("Film_ID");
			String title = myRes.getString("Title");
			String release = myRes.getString("Release");
			String director = myRes.getString("Director");
			String genre = myRes.getString("Genre");

			film = new FilmClass(film_ID, title, release, director, genre);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return film;
	}

}