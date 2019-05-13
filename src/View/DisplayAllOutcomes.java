package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.FinancialManager;
import Controller.IncomeManager;
import Controller.OutcomeManager;
import Controller.UserManager;
import Model.Income;
import Model.Outcome;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayAllOutcomes extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JButton button;
	private JLabel label;
	private JPanel panel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTable table_1;
	private JButton button_1;
	private JLabel label_4;
	private JLabel label_5;
	private static double balance;
	private JLabel label_6;

	/**
	 * Launch the application.
	 */
	public static void addRowToTable() {

		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
			outcomes = OutcomeManager.instance.getAllOutcomes();
			Object rowdata[] = new Object[20];
			for (int i = 0; i < outcomes.size(); i++) {
				rowdata[0] = outcomes.get(i).getAmount();
				rowdata[1] = outcomes.get(i).getDescription();
				rowdata[2] = outcomes.get(i).getDate();
				rowdata[3] = outcomes.get(i).getC_id();
				rowdata[4] = outcomes.get(i).getA_id();

				model.addRow(rowdata);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column" }));
		table.setBounds(260, 108, 571, 308);
		contentPane.add(table);

		JLabel lblIncomeManager = new JLabel("All Outcomes");
		lblIncomeManager.setForeground(new Color(255, 255, 255));
		lblIncomeManager.setFont(new Font("Pristina", Font.BOLD, 14));
		lblIncomeManager.setBounds(474, 50, 123, 20);
		contentPane.add(lblIncomeManager);

		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View.OutcomeManager om = new View.OutcomeManager();
				om.setVisible(true);

			}
		});
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
		label_3.setText(UserManager.instance.getCurrentUser().getName());

		label_5 = new JLabel("0.0 $");
		label_5.setFont(new Font("Pristina", Font.BOLD, 14));
		label_5.setBounds(114, 154, 61, 14);
		panel.add(label_5);
		try {
			balance = FinancialManager.instance.getBalance();
			label_5.setText(balance + " $");

			label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon(DisplayAllOutcomes.class.getResource("/View/images/cash.png")));
			label_6.setBounds(108, 179, 86, 41);
			panel.add(label_6);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		table_1 = new JTable();
		table_1.setForeground(new Color(255, 255, 255));
		table_1.setBackground(new Color(0, 250, 154));
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { " Amount", " Description", " Date", " Category ID", " Account ID" }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		table_1.setFont(new Font("Pristina", Font.BOLD, 14));
		table_1.setBounds(260, 81, 571, 16);
		contentPane.add(table_1);

		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRowToTable();
			}
		});
		button_1.setIcon(new ImageIcon(DisplayAllOutcomes.class.getResource("/View/images/show.png")));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(508, 427, 54, 20);
		contentPane.add(button_1);

		label_4 = new JLabel("Show\r\n");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Pristina", Font.BOLD, 14));
		label_4.setBounds(518, 450, 32, 32);
		contentPane.add(label_4);
	}

}
