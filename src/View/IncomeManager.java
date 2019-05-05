package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class IncomeManager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncomeManager frame = new IncomeManager();
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
	public IncomeManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIncomeManager = new JLabel("Income Manager");
		lblIncomeManager.setBounds(215, 36, 123, 20);
		contentPane.add(lblIncomeManager);
		
		JButton btnNewButton = new JButton("Insert Item");
		btnNewButton.setBounds(190, 152, 174, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Get all incomes");
		btnNewButton_1.setBounds(195, 276, 169, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Get specific income");
		btnNewButton_2.setBounds(193, 395, 169, 29);
		contentPane.add(btnNewButton_2);
	}

}
