package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class OutcomeManagerM extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutcomeManagerM frame = new OutcomeManagerM();
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
	public OutcomeManagerM() {
		setTitle("Outcome Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show all outcomes");
		btnNewButton.setBounds(188, 227, 199, 69);
		contentPane.add(btnNewButton);
		
		JButton btnInsertOutcome = new JButton("Insert outcome");
		btnInsertOutcome.setBounds(188, 98, 199, 69);
		contentPane.add(btnInsertOutcome);
		
		JButton btnShowFilterdOutcomes = new JButton("Show Filterd outcomes");
		btnShowFilterdOutcomes.setBounds(188, 359, 199, 69);
		contentPane.add(btnShowFilterdOutcomes);
	}

}
