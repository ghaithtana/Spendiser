package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class InsertIncome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertIncome frame = new InsertIncome();
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
	public InsertIncome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Account");
		lblNewLabel.setBounds(16, 74, 115, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnrtDicraption = new JLabel("Enrt dicraption");
		lblEnrtDicraption.setBounds(16, 165, 104, 20);
		contentPane.add(lblEnrtDicraption);
		
		JLabel lblEnterInsertionDate = new JLabel("Enter Insertion date");
		lblEnterInsertionDate.setBounds(15, 245, 154, 20);
		contentPane.add(lblEnterInsertionDate);
		
		JLabel lblEnter = new JLabel("Enter Account By ID ");
		lblEnter.setBounds(15, 336, 148, 20);
		contentPane.add(lblEnter);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(450, 499, 115, 29);
		contentPane.add(btnInsert);
		
		textField = new JTextField();
		textField.setBounds(178, 71, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(178, 162, 146, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(178, 242, 146, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(178, 333, 146, 26);
		contentPane.add(textField_3);
		
		table = new JTable();
		table.setBounds(339, 259, 226, 206);
		contentPane.add(table);
		
		button = new JButton("<Back");
		button.setBounds(16, 499, 115, 29);
		contentPane.add(button);
	}
}
