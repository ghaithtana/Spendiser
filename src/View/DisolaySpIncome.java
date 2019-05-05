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

public class DisolaySpIncome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisolaySpIncome frame = new DisolaySpIncome();
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
	public DisolaySpIncome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter start date");
		lblNewLabel.setBounds(15, 57, 127, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterEndDate = new JLabel("Enter End Date");
		lblEnterEndDate.setBounds(15, 183, 115, 20);
		contentPane.add(lblEnterEndDate);
		
		JLabel lblEnterAccountId = new JLabel("Enter Account ID");
		lblEnterAccountId.setBounds(15, 305, 127, 20);
		contentPane.add(lblEnterAccountId);
		
		textField = new JTextField();
		textField.setBounds(151, 54, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 180, 146, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 302, 146, 26);
		contentPane.add(textField_2);
		
		table = new JTable();
		table.setBounds(324, 238, 239, 201);
		contentPane.add(table);
		
		JButton btnShowi = new JButton("Show");
		btnShowi.setBounds(448, 500, 115, 29);
		contentPane.add(btnShowi);
		
		btnBack = new JButton("<Back");
		btnBack.setBounds(15, 500, 115, 29);
		contentPane.add(btnBack);
	}

}
