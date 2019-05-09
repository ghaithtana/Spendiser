package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Mainmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainmenu frame = new Mainmenu();
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
	public Mainmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(0, 250, 154));
		btnNewButton.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/income.png")));
		btnNewButton.setBounds(201, 36, 150, 135);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setBackground(new Color(0, 250, 154));
		button.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/outcome.png")));
		button.setBounds(201, 218, 150, 135);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(new Color(0, 250, 154));
		button_1.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/financial.png")));
		button_1.setBounds(436, 36, 150, 135);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBackground(new Color(0, 250, 154));
		button_2.setIcon(new ImageIcon(Mainmenu.class.getResource("/View/images/presentation.png")));
		button_2.setBounds(436, 218, 150, 135);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("OutcomeManager");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(214, 196, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIncomeManager = new JLabel("Income Manager\r\n");
		lblIncomeManager.setForeground(Color.WHITE);
		lblIncomeManager.setFont(new Font("Pristina", Font.BOLD, 14));
		lblIncomeManager.setBounds(230, 21, 91, 14);
		contentPane.add(lblIncomeManager);
		
		JLabel lblFinancialAccountManager = new JLabel("Financial Account Manager");
		lblFinancialAccountManager.setForeground(Color.WHITE);
		lblFinancialAccountManager.setFont(new Font("Pristina", Font.BOLD, 14));
		lblFinancialAccountManager.setBounds(436, 21, 150, 14);
		contentPane.add(lblFinancialAccountManager);
		
		JLabel lblStatistics = new JLabel("Financial Statistics");
		lblStatistics.setForeground(Color.WHITE);
		lblStatistics.setFont(new Font("Pristina", Font.BOLD, 14));
		lblStatistics.setBounds(454, 196, 117, 14);
		contentPane.add(lblStatistics);
	}

}
