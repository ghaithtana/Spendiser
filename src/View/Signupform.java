package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.UserManager;
import Model.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Signupform extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private static String username;
	private static String Password;
	private static String Cpassword;
	private static String Nickname;
	private static String Birthdate;
	private static int gender;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signupform frame = new Signupform();
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
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public Signupform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 293, 513);
		contentPane.add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Signupform.class.getResource("/View/images/SpendiserLogo2.png")));
		label.setBounds(39, 117, 200, 212);
		panel.add(label);

		JLabel label_1 = new JLabel("Welcome To \r\n$pendiser");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Pristina", Font.BOLD, 30));
		label_1.setBounds(20, 329, 263, 104);
		panel.add(label_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(416, 41, 146, 26);
		contentPane.add(textField);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				username = textField.getText();

			}
		});

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(416, 252, 146, 26);
		contentPane.add(textField_3);
		textField_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Nickname = textField_3.getText();

			}
		});

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(416, 326, 146, 26);
		contentPane.add(textField_4);
		textField_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Birthdate = textField_4.getText();

			}
		});

		JLabel label_2 = new JLabel("Username :");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Pristina", Font.BOLD, 14));
		label_2.setBounds(344, 47, 62, 20);
		contentPane.add(label_2);

		JLabel lblPassword = new JLabel("Password :\r\n");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Pristina", Font.BOLD, 14));
		lblPassword.setBounds(344, 115, 62, 20);
		contentPane.add(lblPassword);

		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Pristina", Font.BOLD, 14));
		lblConfirmPassword.setBounds(303, 189, 103, 20);
		contentPane.add(lblConfirmPassword);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(Color.WHITE);
		lblNickname.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNickname.setBounds(344, 258, 62, 20);
		contentPane.add(lblNickname);

		JLabel lblBirthdate = new JLabel("Birthdate :");
		lblBirthdate.setForeground(Color.WHITE);
		lblBirthdate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblBirthdate.setBounds(344, 332, 62, 20);
		contentPane.add(lblBirthdate);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(475, 390, 109, 23);
		contentPane.add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(344, 390, 109, 23);
		contentPane.add(rdbtnFemale);
		if (rdbtnFemale.isSelected() == true) {
			gender = 0;
		} else {
			gender = 1;
		}

		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Cpassword.equals(Password)) {
						if (username != null && Password != null && Cpassword != null && Nickname != null
								&& Birthdate != null
								&& (rdbtnFemale.isSelected() == true || rdbtnMale.isSelected() == true)) {
							User u = new User(username, Password, Nickname, gender, Birthdate);
							UserManager.instance.signUp(u);
							infoBox("Signup has been successfully", "");
							dispose();
							SignInForm si = new SignInForm();
							si.setVisible(true);
						} else {
							infoBox("please fill the textboxes", "");
						}

					} else {
						infoBox("passwords not match", "");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSignup.setBounds(418, 443, 89, 23);
		contentPane.add(btnSignup);

		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setBounds(344, 477, 240, 14);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(416, 113, 146, 26);
		contentPane.add(passwordField);
		passwordField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Password = passwordField.getText();

			}
		});
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(416, 187, 146, 26);
		contentPane.add(passwordField_1);
		passwordField_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cpassword = passwordField_1.getText();

			}
		});

	}
}
