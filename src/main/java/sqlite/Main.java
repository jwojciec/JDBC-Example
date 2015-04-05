package sqlite;

import java.awt.EventQueue;

import javax.swing.UIManager;

import sqlite.model.Model;
import sqlite.viewer.GUI;
import sqlite.controller.*;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					GUI frame = new GUI();
					frame.setVisible(true);
					Model model = new Model();

					Controller theController = new Controller(frame, model);
					theController.startController();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
