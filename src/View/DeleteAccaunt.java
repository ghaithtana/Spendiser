package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteAccaunt extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccaunt frame = new DeleteAccaunt();
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
	public DeleteAccaunt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Delete Account");
		btnNewButton.setBounds(278, 438, 146, 29);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(156, 67, 268, 193);
		contentPane.add(table);
		
		JLabel lblDeleteTable = new JLabel("Delete Table");
		lblDeleteTable.setBounds(244, 31, 95, 20);
		contentPane.add(lblDeleteTable);
		
		JLabel lblEnterAccountId = new JLabel("Enter account ID");
		lblEnterAccountId.setBounds(98, 330, 124, 20);
		contentPane.add(lblEnterAccountId);
		
		textField = new JTextField();
		textField.setBounds(246, 327, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("<Back");
		button.setBounds(15, 499, 115, 29);
		contentPane.add(button);
	}
}
