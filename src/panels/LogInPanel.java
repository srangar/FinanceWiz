package panels;

import gui.PanelHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * starting panel which allows the user to log in to his/her account 
 *
 */
public class LogInPanel extends JPanel {
	
	private final PanelHandler handler;
	private JButton signInButton, cancelButton, registerButton, instructionsButton; 
	private JPasswordField password; 
	private JTextField username;
	
	/**
	 * constructs the pane with various textboxes and buttons 
	 * @param handler handles the components on the panel
	 */
	public LogInPanel(PanelHandler handler)
	{
		super();
		//setLayout(new BoxLayout(this,1));
		this.handler = handler;

		username = new JTextField(15);
		password = new JPasswordField(15);
		
		add(Box.createVerticalStrut(145));
		
		add(new JLabel("Username"));
		add(username);
		
		add(new JLabel("Password"));
		add(password);
		
		add(Box.createVerticalStrut(25));
		
		ActionListener a = new ButtonHandler();
		signInButton = new JButton("Sign In");
		signInButton.addActionListener(a);
		add(signInButton); 
		
		add(new JLabel("Here's how to get started")); 
		instructionsButton = new JButton("Instructions"); 
		instructionsButton.addActionListener(a); 
		add(instructionsButton); 
		
		add(Box.createHorizontalStrut(400)); 
		
		add(new JLabel("Don't have an account? Register here!")); 
		registerButton = new JButton("Register User"); 
		registerButton.addActionListener(a);
		add(registerButton); 
		
		cancelButton = new JButton("Quit"); 
		cancelButton.addActionListener(a); 
		add(cancelButton);
		
		
	}
	/**
	 * handles the buttons of the panel 
	 *
	 */
	class ButtonHandler implements ActionListener {

		@Override
		/**
		 * what happens when the button is clicked 
		 */
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			if(source == signInButton) {
				String pwd = String.valueOf(password.getPassword());
				String user = username.getText();
				handler.handleSignIn(user,pwd);
			} else if(source == cancelButton) {
				handler.handleQuit();
			} else if(source == registerButton) {
				handler.handleRegisterRequest();
			} else if(source == instructionsButton) {
				handler.handleInstructions();
			}
		}
		
	}

}
