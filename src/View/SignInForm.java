package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.WindowEvent;
import com.sun.javafx.tk.Toolkit;

import Controller.UserManager;
import Model.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Label;

public class SignInForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String username;
	private String password;
	static SignInForm frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SignInForm();
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

	public SignInForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 601);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(308, 110, 62, 20);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Pristina", Font.BOLD, 14));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(312, 210, 69, 20);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(396, 107, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				username = textField.getText();

			}
		});
		passwordField = new JPasswordField();
		passwordField.setBounds(396, 205, 146, 26);
		contentPane.add(passwordField);
		passwordField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password = passwordField.getText();
			}
		});

		JButton btnSingIn = new JButton("");
		btnSingIn.setBackground(new Color(0, 250, 154));
		btnSingIn.setIcon(new ImageIcon(SignInForm.class.getResource("/View/images/enter.png")));
		btnSingIn.setBounds(445, 262, 43, 41);
		contentPane.add(btnSingIn);
		btnSingIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JLabel lblNewLabel_3 = new JLabel("Wrong username or password");
				lblNewLabel_3.setFont(new Font("Pristina", Font.BOLD, 17));
				lblNewLabel_3.setForeground(new Color(255, 0, 0));
				lblNewLabel_3.setBounds(354, 345, 220, 26);
				contentPane.add(lblNewLabel_3);
				lblNewLabel_3.setVisible(false);
				try {
					User user;
					user = UserManager.instance.signIn(username, password);
					if (user != null) {
						Mainmenu mm = new Mainmenu();
						frame.setVisible(false);
						mm.setVisible(true);

					} else {
						lblNewLabel_3.setVisible(true);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		JButton button = new JButton("Register");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Signupform sp = new Signupform();
				sp.setVisible(true);
				
			}
		});
		button.setFont(new Font("Pristina", Font.BOLD, 14));
		button.setBackground(new Color(0, 250, 154));
		button.setBounds(486, 444, 88, 25);
		contentPane.add(button);

		JLabel lblOrYouCan = new JLabel("Don't have account?");
		lblOrYouCan.setFont(new Font("Pristina", Font.BOLD, 20));
		lblOrYouCan.setForeground(new Color(255, 255, 255));
		lblOrYouCan.setBounds(325, 445, 164, 20);
		contentPane.add(lblOrYouCan);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 293, 562);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SignInForm.class.getResource("/View/images/SpendiserLogo2.png")));
		lblNewLabel_1.setBounds(39, 117, 200, 212);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Welcome To \r\n$pendiser");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Pristina", Font.BOLD, 30));
		lblNewLabel_2.setBounds(20, 329, 263, 104);
		panel.add(lblNewLabel_2);

		JLabel lblLogin = new JLabel("LogIn");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Pristina", Font.BOLD, 14));
		lblLogin.setBounds(445, 314, 62, 20);
		contentPane.add(lblLogin);

	}
}
