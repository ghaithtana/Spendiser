package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class DisplayFilteredOutcome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JButton btnNewButton;
	private JButton button;
	private JLabel label;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayFilteredOutcome frame = new DisplayFilteredOutcome();
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
	public DisplayFilteredOutcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 579);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose category by ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(15, 105, 131, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(177, 102, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterStartDate = new JLabel("Start Date");
		lblEnterStartDate.setForeground(new Color(255, 255, 255));
		lblEnterStartDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterStartDate.setBounds(15, 163, 69, 20);
		contentPane.add(lblEnterStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setForeground(new Color(255, 255, 255));
		lblEndDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEndDate.setBounds(15, 222, 69, 20);
		contentPane.add(lblEndDate);
		
		JLabel lblChoseAccountBy = new JLabel("Choose account by ID");
		lblChoseAccountBy.setFont(new Font("Pristina", Font.BOLD, 14));
		lblChoseAccountBy.setForeground(new Color(255, 255, 255));
		lblChoseAccountBy.setBounds(15, 280, 146, 20);
		contentPane.add(lblChoseAccountBy);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 160, 146, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 219, 146, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(177, 277, 146, 26);
		contentPane.add(textField_3);
		
		table = new JTable();
		table.setBounds(333, 108, 301, 195);
		contentPane.add(table);
		
		btnNewButton = new JButton("Display");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(85, 451, 115, 29);
		contentPane.add(btnNewButton);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(DisplayFilteredOutcome.class.getResource("/View/images/left-arrow.png")));
		button.setBounds(0, 0, 54, 38);
		contentPane.add(button);
		
		label = new JLabel("Back");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Pristina", Font.BOLD, 14));
		label.setBounds(10, 35, 32, 32);
		contentPane.add(label);
		
		table_1 = new JTable();
		table_1.setBounds(333, 334, 301, 195);
		contentPane.add(table_1);
		
		JLabel lblAccounts = new JLabel("Categories");
		lblAccounts.setForeground(new Color(255, 255, 255));
		lblAccounts.setFont(new Font("Pristina", Font.BOLD, 14));
		lblAccounts.setBounds(436, 79, 131, 20);
		contentPane.add(lblAccounts);
		
		JLabel lblAccounts_1 = new JLabel("Accounts");
		lblAccounts_1.setForeground(new Color(255, 255, 255));
		lblAccounts_1.setFont(new Font("Pristina", Font.BOLD, 14));
		lblAccounts_1.setBounds(436, 314, 131, 20);
		contentPane.add(lblAccounts_1);
	}
}
