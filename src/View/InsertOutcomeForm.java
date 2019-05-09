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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class InsertOutcomeForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JButton button;
	private JLabel label;
	private JTextField textField_3;
	private JLabel lblEnterAmount;
	private JButton button_1;
	private JLabel lblInsertIncome;
	private JTable table_1;
	private JLabel lblAccounts;
	private JLabel lblCategories;
	private JLabel lblEnterCategoryId;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertOutcomeForm frame = new InsertOutcomeForm();
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
	public InsertOutcomeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter description :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 146, 127, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterEndDate = new JLabel("Enter Date :");
		lblEnterEndDate.setForeground(new Color(255, 255, 255));
		lblEnterEndDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterEndDate.setBounds(12, 208, 115, 20);
		contentPane.add(lblEnterEndDate);
		
		JLabel lblEnterAccountId = new JLabel("Enter Account ID :");
		lblEnterAccountId.setForeground(new Color(255, 255, 255));
		lblEnterAccountId.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAccountId.setBounds(12, 260, 127, 20);
		contentPane.add(lblEnterAccountId);
		
		textField = new JTextField();
		textField.setBounds(151, 141, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 203, 146, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 255, 146, 26);
		contentPane.add(textField_2);
		
		table = new JTable();
		table.setBounds(356, 52, 282, 197);
		contentPane.add(table);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(InsertOutcomeForm.class.getResource("/View/images/left-arrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(0, 0, 54, 38);
		contentPane.add(button);
		
		label = new JLabel("Back");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Pristina", Font.BOLD, 14));
		label.setBounds(10, 45, 32, 32);
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(151, 83, 146, 26);
		contentPane.add(textField_3);
		
		lblEnterAmount = new JLabel("Enter Amount :");
		lblEnterAmount.setForeground(Color.WHITE);
		lblEnterAmount.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAmount.setBounds(12, 88, 127, 20);
		contentPane.add(lblEnterAmount);
		
		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(InsertOutcomeForm.class.getResource("/View/images/plus.png")));
		button_1.setBounds(50, 375, 49, 38);
		contentPane.add(button_1);
		
		lblInsertIncome = new JLabel("Insert Outcome");
		lblInsertIncome.setForeground(Color.WHITE);
		lblInsertIncome.setFont(new Font("Pristina", Font.PLAIN, 15));
		lblInsertIncome.setBounds(39, 424, 73, 38);
		contentPane.add(lblInsertIncome);
		
		table_1 = new JTable();
		table_1.setBounds(356, 283, 282, 197);
		contentPane.add(table_1);
		
		lblAccounts = new JLabel("Accounts");
		lblAccounts.setForeground(Color.WHITE);
		lblAccounts.setFont(new Font("Pristina", Font.BOLD, 14));
		lblAccounts.setBounds(427, 24, 127, 20);
		contentPane.add(lblAccounts);
		
		lblCategories = new JLabel("Categories");
		lblCategories.setForeground(Color.WHITE);
		lblCategories.setFont(new Font("Pristina", Font.BOLD, 14));
		lblCategories.setBounds(427, 260, 127, 20);
		contentPane.add(lblCategories);
		
		lblEnterCategoryId = new JLabel("Enter Category ID :");
		lblEnterCategoryId.setForeground(Color.WHITE);
		lblEnterCategoryId.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterCategoryId.setBounds(12, 320, 127, 20);
		contentPane.add(lblEnterCategoryId);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(151, 315, 146, 26);
		contentPane.add(textField_4);
	}

}
