package com.library.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.library.dao.IssueBookDao;
import com.library.model.IssuedBooks;

import javax.swing.JTable;

public class ViewIssuedBooks extends JFrame {

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
					ViewIssuedBooks frame = new ViewIssuedBooks();
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
	public ViewIssuedBooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		String data[][] = null;
		String column[] = { "Call Number", "Student ID", "Date of Issue" };
		try {
			List<IssuedBooks> list = IssueBookDao.show();
			data = new String[list.size()][3];
			for (int i = 0; i < list.size(); i++) {
				data[i][0] = list.get(i).getIssue().getCallno();
				data[i][1] = list.get(i).getIssue().getStudentid();
				data[i][2] = String.valueOf(list.get(i).getDoi());
			}
		} catch (Exception e1) {
			System.out.println(e1);
		}
		table = new JTable(data, column);
		table.setEnabled(false);
		JScrollPane sp = new JScrollPane(table);
		sp.setEnabled(false);
		contentPane.add(sp, BorderLayout.CENTER);
	}

}
