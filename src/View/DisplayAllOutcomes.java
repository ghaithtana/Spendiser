package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class DisplayAllOutcomes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton button;
	private JLabel label;
	private JPanel panel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayAllOutcomes frame = new DisplayAllOutcomes();
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
	public DisplayAllOutcomes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 601);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(256, 81, 569, 445);
		contentPane.add(table);
		
		JLabel lblIncomeManager = new JLabel("All Outcomes");
		lblIncomeManager.setForeground(new Color(255, 255, 255));
		lblIncomeManager.setFont(new Font("Pristina", Font.BOLD, 14));
		lblIncomeManager.setBounds(474, 50, 123, 20);
		contentPane.add(lblIncomeManager);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(DisplayAllOutcomes.class.getResource("/View/images/left-arrow.png")));
		button.setBounds(239, 0, 54, 40);
		contentPane.add(button);
		
		label = new JLabel("Back");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Pristina", Font.BOLD, 14));
		label.setBounds(250, 38, 32, 32);
		contentPane.add(label);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 239, 562);
		contentPane.add(panel);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DisplayAllOutcomes.class.getResource("/View/images/user.png")));
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setBounds(80, 11, 71, 70);
		panel.add(label_1);
		
		label_2 = new JLabel("Current balance :");
		label_2.setForeground(new Color(0, 250, 154));
		label_2.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(0, 135, 104, 50);
		panel.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setForeground(new Color(0, 250, 154));
		label_3.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_3.setBounds(65, 81, 86, 26);
		panel.add(label_3);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 250, 154));
		textField.setColumns(10);
		textField.setBounds(108, 149, 86, 20);
		panel.add(textField);
	}

}
