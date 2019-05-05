package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class outcomeInsert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					outcomeInsert frame = new outcomeInsert();
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
	public outcomeInsert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOutcomeManager = new JLabel("Outcome Manager");
		lblOutcomeManager.setBounds(198, 16, 140, 20);
		contentPane.add(lblOutcomeManager);
		
		JLabel lblNewLabel = new JLabel("Enter Amount");
		lblNewLabel.setBounds(15, 60, 107, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 52, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterDiscripton = new JLabel("Enter discripton");
		lblEnterDiscripton.setBounds(15, 129, 116, 20);
		contentPane.add(lblEnterDiscripton);
		
		JLabel lblEnterDateOf = new JLabel("Enter date of outcome");
		lblEnterDateOf.setBounds(15, 196, 158, 20);
		contentPane.add(lblEnterDateOf);
		
		JLabel lblSelectCategoryBy = new JLabel("Select category by ID");
		lblSelectCategoryBy.setBounds(15, 274, 158, 20);
		contentPane.add(lblSelectCategoryBy);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(173, 126, 146, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(179, 193, 140, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(173, 271, 131, 26);
		contentPane.add(textField_3);
		
		table = new JTable();
		table.setBounds(319, 266, 244, 202);
		contentPane.add(table);
		
		JButton btnInsertOutcome = new JButton("Insert outcome");
		btnInsertOutcome.setBounds(417, 498, 146, 29);
		contentPane.add(btnInsertOutcome);
		
		JButton button = new JButton("< Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OutcomeManagerM om = new OutcomeManagerM();
				om.setVisible(isVisible());
			}
		});
		button.setBounds(15, 498, 115, 29);
		contentPane.add(button);
	}

}
