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

public class DisplayFilteredIncome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JButton button;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayFilteredIncome frame = new DisplayFilteredIncome();
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
	public DisplayFilteredIncome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter start date");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(15, 112, 127, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterEndDate = new JLabel("Enter End Date");
		lblEnterEndDate.setForeground(new Color(255, 255, 255));
		lblEnterEndDate.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterEndDate.setBounds(15, 183, 115, 20);
		contentPane.add(lblEnterEndDate);
		
		JLabel lblEnterAccountId = new JLabel("Enter Account ID");
		lblEnterAccountId.setForeground(new Color(255, 255, 255));
		lblEnterAccountId.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAccountId.setBounds(15, 259, 127, 20);
		contentPane.add(lblEnterAccountId);
		
		textField = new JTextField();
		textField.setBounds(151, 107, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 180, 146, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 254, 146, 26);
		contentPane.add(textField_2);
		
		table = new JTable();
		table.setBounds(307, 78, 354, 214);
		contentPane.add(table);
		
		JButton btnShowi = new JButton("Show");
		btnShowi.setBackground(new Color(230, 230, 250));
		btnShowi.setBounds(406, 303, 115, 29);
		contentPane.add(btnShowi);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(DisplayFilteredIncome.class.getResource("/View/images/left-arrow.png")));
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
	}

}
