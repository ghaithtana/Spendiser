package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AccountManager;
import Controller.FinancialManager;
import Controller.UserManager;
import Model.Account;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;

import com.sun.jndi.cosnaming.IiopUrl.Address;

import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

public class DeleteAccountForm extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField textField;
	private static double balcnce;
	private JTable table_1;
	private static int id;
	private static String listener;

	/**
	 * Launch the application.
	 */
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void addRowToTable() {

		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			ArrayList<Account> accounts = new ArrayList<Account>();
			accounts = AccountManager.instance.getAllAccounts();
			Object rowdata[] = new Object[20];
			for (int i = 0; i < accounts.size(); i++) {
				rowdata[0] = accounts.get(i).getId();
				rowdata[1] = accounts.get(i).getName();
				rowdata[2] = accounts.get(i).getU_ID();
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

					DeleteAccountForm frame = new DeleteAccountForm();
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

	public DeleteAccountForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (listener != null) {
						AccountManager.instance.deleteAccount(id);
						infoBox("Account deleted succsessfully", "");
						listener = null;
					} else {
						infoBox("Pleas add account's id to delete", "");

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(DeleteAccountForm.class.getResource("/View/images/clear.png")));
		btnNewButton.setBounds(323, 211, 74, 64);
		contentPane.add(btnNewButton);

		table = new JTable();
		table.setFont(new Font("Pristina", Font.BOLD, 14));
		table.setBorder(UIManager.getBorder("DesktopIcon.border"));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "AccountID", "Account Name", "UserID" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.setBounds(456, 105, 268, 157);
		contentPane.add(table);

		JLabel lblDeleteTable = new JLabel("Financial Accounts\r\n");
		lblDeleteTable.setForeground(new Color(255, 255, 255));
		lblDeleteTable.setFont(new Font("Pristina", Font.BOLD, 17));
		lblDeleteTable.setBounds(504, 38, 151, 20);
		contentPane.add(lblDeleteTable);

		JLabel lblEnterAccountId = new JLabel("Enter account ID :");
		lblEnterAccountId.setForeground(new Color(255, 255, 255));
		lblEnterAccountId.setFont(new Font("Pristina", Font.BOLD, 14));
		lblEnterAccountId.setBounds(314, 134, 101, 20);
		contentPane.add(lblEnterAccountId);

		textField = new JTextField();
		textField.setBounds(314, 165, 114, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener = textField.getText();
				id = Integer.parseInt(textField.getText().trim());
			}
		});

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AccountManagerForm ac = new AccountManagerForm();
				ac.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(DeleteAccountForm.class.getResource("/View/images/left-arrow.png")));
		button.setBounds(232, 0, 54, 38);
		contentPane.add(button);

		JLabel label = new JLabel("Back");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Pristina", Font.BOLD, 14));
		label.setBounds(242, 38, 32, 32);
		contentPane.add(label);

		JLabel lblDeleteAccount = new JLabel("Delete Account");
		lblDeleteAccount.setForeground(new Color(255, 255, 255));
		lblDeleteAccount.setFont(new Font("Pristina", Font.BOLD, 14));
		lblDeleteAccount.setBounds(325, 286, 87, 20);
		contentPane.add(lblDeleteAccount);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 233, 481);
		contentPane.add(panel);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DeleteAccountForm.class.getResource("/View/images/user.png")));
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setBounds(65, 11, 71, 70);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Current balance :");
		label_2.setForeground(new Color(0, 250, 154));
		label_2.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(0, 135, 104, 50);
		panel.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setForeground(new Color(0, 250, 154));
		label_3.setFont(new Font("Pristina", Font.PLAIN, 18));
		label_3.setBounds(65, 83, 86, 26);
		panel.add(label_3);
		// label_3.setText(UserManager.instance.getCurrentUser().getName());

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Pristina", Font.BOLD, 14));
		lblNewLabel.setBounds(125, 152, 71, 14);
		panel.add(lblNewLabel);
		try {
			balcnce = FinancialManager.instance.getBalance();
			lblNewLabel.setText(balcnce + " $");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table_1 = new JTable();
		table_1.setFont(new Font("Pristina", Font.BOLD, 14));
		table_1.setBackground(new Color(0, 250, 154));
		table_1.setForeground(new Color(255, 255, 255));
		table_1.setModel(new DefaultTableModel(new Object[][] { { "AccountID", "AccountName", "UserID" }, },
				new String[] { "New column", "New column", "New column" }));
		table_1.setBounds(456, 85, 268, 16);
		contentPane.add(table_1);

		JButton btnNewButton_1 = new JButton("ShowData");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addRowToTable();
			}
		});
		btnNewButton_1.setBounds(504, 283, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(null, new String[] { "s", "", "" }));

			}

		});
		btnNewButton_2.setBounds(617, 283, 89, 23);
		contentPane.add(btnNewButton_2);

	}
}
