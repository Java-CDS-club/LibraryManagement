package com.library.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.library.dao.BookDao;
import com.library.model.Book;

import javax.swing.JTable;

public class ViewBooks extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBooks frame = new ViewBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewBooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		String data[][] = null;
		String column[] = { "Call No.", "Name", "Author", "Publisher", "Quantity", "Issued" };
		try {
			List<Book> list = BookDao.show();
			data = new String[list.size()][6];
			for (int i = 0; i < list.size(); i++) {
				data[i][0] = list.get(i).getCallno();
				data[i][1] = list.get(i).getName();
				data[i][2] = list.get(i).getAuthor();
				data[i][3] = list.get(i).getPublisher();
				data[i][4] = String.valueOf(list.get(i).getQuantity());
				data[i][5] = String.valueOf(list.get(i).getIssued());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		table = new JTable(data, column);
		table.setEnabled(false);
		JScrollPane sp = new JScrollPane(table);
		sp.setEnabled(false);

		contentPane.add(sp, BorderLayout.CENTER);
	}

}
