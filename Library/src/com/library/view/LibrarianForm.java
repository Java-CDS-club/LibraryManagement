package com.library.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.library.dao.LibrarianDao;
import com.library.model.Librarian;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class LibrarianForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static LibrarianForm frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianForm();
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
	public LibrarianForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblAddLibrarian = new JLabel("Add Librarian");
		lblAddLibrarian.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddLibrarian.setForeground(Color.GRAY);
		lblAddLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblName = new JLabel("Name:");

		JLabel lblPassword = new JLabel("Password:");

		JLabel lblEmail = new JLabel("Email:");

		JLabel lblAddress = new JLabel("Address:");

		JLabel lblCity = new JLabel("City:");

		JLabel lblContactNo = new JLabel("Contact No:");

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JButton btnAddBooks = new JButton("Add Librarian");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String email = textField_1.getText();
				String address = textField_2.getText();
				String city = textField_3.getText();
				String contact = textField_4.getText();

				try {
					LibrarianDao.insert(new Librarian(name.trim(), password, email, address, city, contact));
					JOptionPane.showMessageDialog(LibrarianForm.this, "Librarian added successfully!");
					AdminSuccess.main(new String[] {});
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(LibrarianForm.this, "Sorry, unable to save!");
				}
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[] {});
				frame.dispose();
			}
		});

		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(50)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblContactNo, GroupLayout.PREFERRED_SIZE, 110,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 170,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
												.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 110,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
												.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 110,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAddress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(
														lblCity, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 110,
														Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField, GroupLayout.DEFAULT_SIZE, 170,
																Short.MAX_VALUE)
														.addComponent(passwordField)
														.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 170,
																Short.MAX_VALUE)
														.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 170,
																Short.MAX_VALUE)
														.addComponent(textField_3)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(115)
																.addComponent(btnBack))))))
						.addComponent(lblAddLibrarian, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(135).addComponent(btnAddBooks,
								GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(30)
				.addComponent(lblAddLibrarian, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE).addGap(30)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblName).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblPassword).addComponent(passwordField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblEmail).addComponent(
						textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblAddress).addComponent(
						textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCity).addComponent(
						textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblContactNo)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE).addComponent(btnBack).addGap(13)
				.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(43)));
		contentPane.setLayout(gl_contentPane);
	}
}
