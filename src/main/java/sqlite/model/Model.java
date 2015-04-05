package sqlite.model;

import java.sql.SQLException;

public class Model {

	String connProperty = null;
	PropClass theProperties = new PropClass();
	SQLiteJDBC dataBase = null;
	FilmTableModel model = null;

	public Model() throws SQLException {

		theProperties.getProperies();
		connProperty = theProperties.getConn();
		dataBase = new SQLiteJDBC(connProperty);

	}

	public FilmTableModel updateTableModel(String phrase) throws SQLException {
		if (phrase.equals("")) {
			model = new FilmTableModel(dataBase.getAllFilms());
		}

		else {
			model = new FilmTableModel(dataBase.searchForFilm(phrase));
		}

		return model;
	}
}
