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

public class DisplayFilterOutcome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayFilterOutcome frame = new DisplayFilterOutcome();
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
	public DisplayFilterOutcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chose caregory by ID");
		lblNewLabel.setBounds(15, 81, 163, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(177, 78, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterStartDate = new JLabel("Start Date");
		lblEnterStartDate.setBounds(15, 206, 146, 20);
		contentPane.add(lblEnterStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(15, 275, 69, 20);
		contentPane.add(lblEndDate);
		
		JLabel lblChoseAccountBy = new JLabel("Chose account by ID");
		lblChoseAccountBy.setBounds(15, 349, 146, 20);
		contentPane.add(lblChoseAccountBy);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 203, 146, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 272, 146, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(177, 346, 146, 26);
		contentPane.add(textField_3);
		
		table = new JTable();
		table.setBounds(337, 81, 197, 121);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(331, 352, 203, 121);
		contentPane.add(table_1);
		
		btnNewButton = new JButton("Display");
		btnNewButton.setBounds(450, 501, 115, 29);
		contentPane.add(btnNewButton);
		
		button = new JButton("< Back");
		button.setBounds(15, 501, 115, 29);
		contentPane.add(button);
	}

}
