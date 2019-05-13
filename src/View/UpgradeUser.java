package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpgradeUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpgradeUser frame = new UpgradeUser();
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
	public UpgradeUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 273, 432);
		contentPane.add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UpgradeUser.class.getResource("/View/images/SpendiserLogo2.png")));
		label.setBounds(33, 38, 200, 212);
		panel.add(label);

		JLabel label_1 = new JLabel("Welcome To \r\n$pendiser");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Pristina", Font.BOLD, 30));
		label_1.setBounds(10, 262, 263, 104);
		panel.add(label_1);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CardInfo ci = new CardInfo();
				ci.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UpgradeUser.class.getResource("/View/images/bank.png")));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(343, 164, 158, 120);
		contentPane.add(btnNewButton);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Mainmenu mu = new Mainmenu();
				mu.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(UpgradeUser.class.getResource("/View/images/left-arrow.png")));
		button.setBounds(272, 0, 54, 38);
		contentPane.add(button);

		JLabel label_2 = new JLabel("Back");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Pristina", Font.BOLD, 14));
		label_2.setBounds(294, 38, 32, 32);
		contentPane.add(label_2);

		JLabel lblSorryCantShow = new JLabel("Sorry cant show statistics,your account is not premium ");
		lblSorryCantShow.setForeground(Color.WHITE);
		lblSorryCantShow.setFont(new Font("Pristina", Font.BOLD, 14));
		lblSorryCantShow.setBounds(283, 106, 286, 32);
		contentPane.add(lblSorryCantShow);

		JLabel lblClickToUpgrade = new JLabel("Click to Upgrade");
		lblClickToUpgrade.setForeground(Color.WHITE);
		lblClickToUpgrade.setFont(new Font("Pristina", Font.BOLD, 14));
		lblClickToUpgrade.setBounds(370, 295, 116, 32);
		contentPane.add(lblClickToUpgrade);

		JLabel lblCost = new JLabel("Cost : 5$");
		lblCost.setForeground(Color.WHITE);
		lblCost.setFont(new Font("Pristina", Font.BOLD, 14));
		lblCost.setBounds(394, 325, 63, 32);
		contentPane.add(lblCost);
	}
}
