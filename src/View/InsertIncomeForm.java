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

public class InsertIncomeForm extends JFrame {

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
	private JLabel lblAccounts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertIncomeForm frame = new InsertIncomeForm();
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
	public InsertIncomeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter description :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 167, 127, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterEndDate = new JLabel("Enter Date :");
		lblEnterEndDate.setForeground(new Color(255, 255, 255));
		lblEnterEndDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterEndDate.setBounds(12, 228, 115, 20);
		contentPane.add(lblEnterEndDate);
		
		JLabel lblEnterAccountId = new JLabel("Enter Account ID :");
		lblEnterAccountId.setForeground(new Color(255, 255, 255));
		lblEnterAccountId.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAccountId.setBounds(15, 288, 127, 20);
		contentPane.add(lblEnterAccountId);
		
		textField = new JTextField();
		textField.setBounds(151, 162, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 223, 146, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 283, 146, 26);
		contentPane.add(textField_2);
		
		table = new JTable();
		table.setBounds(307, 113, 354, 214);
		contentPane.add(table);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(InsertIncomeForm.class.getResource("/View/images/left-arrow.png")));
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
		textField_3.setBounds(151, 107, 146, 26);
		contentPane.add(textField_3);
		
		lblEnterAmount = new JLabel("Enter Amount :");
		lblEnterAmount.setForeground(Color.WHITE);
		lblEnterAmount.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAmount.setBounds(12, 112, 127, 20);
		contentPane.add(lblEnterAmount);
		
		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(InsertIncomeForm.class.getResource("/View/images/plus.png")));
		button_1.setBounds(46, 361, 49, 38);
		contentPane.add(button_1);
		
		lblInsertIncome = new JLabel("Insert Income");
		lblInsertIncome.setForeground(Color.WHITE);
		lblInsertIncome.setFont(new Font("Pristina", Font.PLAIN, 15));
		lblInsertIncome.setBounds(43, 398, 73, 38);
		contentPane.add(lblInsertIncome);
		
		lblAccounts = new JLabel("Accounts");
		lblAccounts.setForeground(Color.WHITE);
		lblAccounts.setFont(new Font("Pristina", Font.BOLD, 14));
		lblAccounts.setBounds(432, 82, 127, 20);
		contentPane.add(lblAccounts);
	}

}
