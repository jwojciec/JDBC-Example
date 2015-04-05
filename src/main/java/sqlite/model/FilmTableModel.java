package sqlite.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class FilmTableModel extends AbstractTableModel {

	private static final int FILM_ID = 0;
	private static final int TITLE = 1;
	private static final int RELEASE = 2;
	private static final int DIRECTOR = 3;
	private static final int GENRE = 4;

	private String[] columnNames = { "Film_ID", "Title", "Release", "Director", "Genre" };
	private List<FilmClass> FilmClass;

	public FilmTableModel(List<FilmClass> theFilmClass) {
		FilmClass = theFilmClass;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return FilmClass.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		FilmClass tempFilmClass = FilmClass.get(row);

		switch (col) {
		case FILM_ID:
			return tempFilmClass.getfilm_ID();
		case TITLE:
			return tempFilmClass.gettitle();
		case RELEASE:
			return tempFilmClass.getrelease();
		case DIRECTOR:
			return tempFilmClass.getdirector();
		case GENRE:
			return tempFilmClass.getgenre();
		default:
			return tempFilmClass.gettitle();
		}
	}
}