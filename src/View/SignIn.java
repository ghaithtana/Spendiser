package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class SignIn {

	protected Shell shlSpendiser;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SignIn window = new SignIn();
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
		shlSpendiser.open();
		shlSpendiser.layout();
		while (!shlSpendiser.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSpendiser = new Shell();
		shlSpendiser.setSize(450, 300);
		shlSpendiser.setText("Spendiser");
		
		text = new Text(shlSpendiser, SWT.BORDER);
		text.setBounds(150, 68, 135, 21);
		
		Label lblNewLabel = new Label(shlSpendiser, SWT.NONE);
		lblNewLabel.setBounds(60, 71, 55, 15);
		lblNewLabel.setText("Username");
		
		Label lblNewLabel_1 = new Label(shlSpendiser, SWT.NONE);
		lblNewLabel_1.setBounds(60, 117, 55, 15);
		lblNewLabel_1.setText("Psaaword");
		
		text_1 = new Text(shlSpendiser, SWT.BORDER);
		text_1.setBounds(150, 111, 135, 21);
		
		Label lblNewLabel_2 = new Label(shlSpendiser, SWT.NONE);
		lblNewLabel_2.setBounds(150, 195, 121, 15);
		lblNewLabel_2.setText("Don't have account ?");
		
		Button btnLogin = new Button(shlSpendiser, SWT.NONE);
		btnLogin.setBounds(184, 149, 75, 25);
		btnLogin.setText("Login");
		
		Button btnNewButton = new Button(shlSpendiser, SWT.NONE);
		btnNewButton.setBounds(277, 192, 75, 21);
		btnNewButton.setText("SignUp");
		
		Label lblWelcomeToSpendiser = new Label(shlSpendiser, SWT.NONE);
		lblWelcomeToSpendiser.setBounds(150, 22, 121, 15);
		lblWelcomeToSpendiser.setText("Welcome to Spendiser");

	}
}
