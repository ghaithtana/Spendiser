package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JFrame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Signup extends JFrame{
	public Signup() {
	}

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Label lblGender;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Signup window = new Signup();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(31, 22, 55, 15);
		lblNewLabel.setText("Username");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(31, 71, 55, 15);
		lblNewLabel_1.setText("Nickname");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(31, 126, 55, 15);
		lblNewLabel_2.setText("BirthDate");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(220, 22, 55, 15);
		lblNewLabel_3.setText("Password");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(220, 71, 86, 15);
		lblNewLabel_4.setText("Password Conf");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(104, 19, 76, 21);
		String txt = text.getText();
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(104, 65, 76, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(329, 19, 76, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(329, 68, 76, 21);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(104, 120, 76, 21);
		
		Button btnSingup = new Button(shell, SWT.NONE);
		btnSingup.setBounds(264, 174, 75, 25);
		btnSingup.setText("SingUp");
		
		lblGender = new Label(shell, SWT.NONE);
		lblGender.setBounds(220, 126, 55, 15);
		lblGender.setText("Gender");
		
		Button btnMale = new Button(shell, SWT.RADIO);
		btnMale.setBounds(281, 115, 90, 16);
		btnMale.setText("Male");
		
		Button btnFemale = new Button(shell, SWT.RADIO);
		btnFemale.setBounds(281, 137, 90, 16);
		btnFemale.setText("Female");

	}
	
}
