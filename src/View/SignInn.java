package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SignInn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInn frame = new SignInn();
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
	public SignInn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(149, 151, 82, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(149, 269, 69, 20);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(246, 148, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(246, 266, 146, 26);
		contentPane.add(textField_1);
		
		JButton btnSingIn = new JButton("Register");
		btnSingIn.setBounds(323, 387, 115, 29);
		contentPane.add(btnSingIn);
		
		JButton button = new JButton("Sing In");
		button.setBounds(122, 387, 115, 29);
		contentPane.add(button);
		
		JLabel lblOrYouCan = new JLabel("Or you can");
		lblOrYouCan.setBounds(239, 391, 87, 20);
		contentPane.add(lblOrYouCan);
	}

}
