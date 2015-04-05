package sqlite.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import sqlite.viewer.GUI;
import sqlite.model.*;

public class Controller {
	GUI frame;
	Model model;

	public Controller(GUI frame, Model model) {
		this.frame = frame;
		this.model = model;
	}

	public void startController() {

		ActionListener searchActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent searchAE) {
				try {
					String phrase = frame.getSearchText();
					frame.setTable(model.updateTableModel(phrase));

				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unknown error: " + e.getMessage());
				}
			}
		};

		frame.addSearchListener(searchActionListener);

	}

}
