package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;

public class DisplaySpIncomes2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplaySpIncomes2 frame = new DisplaySpIncomes2();
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
	public DisplaySpIncomes2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(15, 49, 548, 481);
		contentPane.add(table);
		
		JLabel lblIncomeManager = new JLabel("Income Manager");
		lblIncomeManager.setBounds(225, 16, 124, 20);
		contentPane.add(lblIncomeManager);
		
		button = new JButton("<Back");
		button.setBounds(15, 4, 115, 29);
		contentPane.add(button);
	}

}
