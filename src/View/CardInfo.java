package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CardInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static int cardnum;
	private static String edate;
	private static int cvc;
	private static String listener1;
	private static String listener2;

	/**
	 * Launch the application.
	 */
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardInfo frame = new CardInfo();
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
	public CardInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 273, 393);
		contentPane.add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CardInfo.class.getResource("/View/images/SpendiserLogo2.png")));
		label.setBounds(33, 22, 200, 212);
		panel.add(label);

		JLabel label_1 = new JLabel("Welcome To \r\n$pendiser");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Pristina", Font.BOLD, 30));
		label_1.setBounds(10, 232, 263, 104);
		panel.add(label_1);

		textField = new JTextField();
		textField.setBounds(374, 74, 127, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener1 = textField.getText();
				cardnum = Integer.parseInt(textField.getText().trim());
			}
		});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(374, 121, 127, 27);
		contentPane.add(textField_1);
		textField_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				edate = textField_1.getText();
			}
		});

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(374, 174, 127, 23);
		contentPane.add(textField_2);
		textField_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener2 = textField_2.getText();
				cvc = Integer.parseInt(textField_2.getText().trim());
			}
		});

		JButton btnNewButton = new JButton("Click to pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listener1 != null && listener2 != null && edate != null) {
					infoBox("Congrats Payment completed successfully!", "");
					dispose();
					StatisticsForm sf = new StatisticsForm();
					sf.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(388, 245, 100, 23);
		contentPane.add(btnNewButton);

		JLabel lblCardNumber = new JLabel("Card number :");
		lblCardNumber.setFont(new Font("Pristina", Font.BOLD, 14));
		lblCardNumber.setForeground(new Color(255, 255, 255));
		lblCardNumber.setBounds(283, 80, 81, 14);
		contentPane.add(lblCardNumber);

		JLabel lblExpidredDate = new JLabel("expidred date :");
		lblExpidredDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblExpidredDate.setForeground(new Color(255, 255, 255));
		lblExpidredDate.setBounds(282, 127, 82, 14);
		contentPane.add(lblExpidredDate);

		JLabel lblCvc = new JLabel("cvc:");
		lblCvc.setFont(new Font("Pristina", Font.BOLD, 14));
		lblCvc.setForeground(new Color(255, 255, 255));
		lblCvc.setBounds(309, 180, 34, 14);
		contentPane.add(lblCvc);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CardInfo.class.getResource("/View/images/credit-card.png")));
		lblNewLabel.setBounds(515, 83, 24, 14);
		contentPane.add(lblNewLabel);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(CardInfo.class.getResource("/View/images/calendar.png")));
		label_2.setBounds(515, 134, 24, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(CardInfo.class.getResource("/View/images/credit-card-band-and-number.png")));
		label_3.setBounds(515, 174, 24, 14);
		contentPane.add(label_3);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpgradeUser up = new UpgradeUser();
				up.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(CardInfo.class.getResource("/View/images/left-arrow.png")));
		button.setBounds(271, 0, 54, 38);
		contentPane.add(button);
		
		JLabel label_4 = new JLabel("Back");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Pristina", Font.BOLD, 14));
		label_4.setBounds(283, 35, 32, 32);
		contentPane.add(label_4);
	}
}
