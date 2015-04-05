package sqlite.viewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	JButton btnSearch;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(68, 11, 112, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblSearchText = new JLabel("Film name:");
		lblSearchText.setBounds(10, 14, 61, 14);
		contentPane.add(lblSearchText);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(190, 10, 89, 23);
		contentPane.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 414, 212);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}

	public void addSearchListener(ActionListener searchActionListener) {
		btnSearch.addActionListener(searchActionListener);
	}

	public String getSearchText() {
		return textField.getText();
	}

	public void setTable(TableModel model) {
		table.setModel(model);
	}
}
