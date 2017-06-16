package panels;

import gui.PanelHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * represents the panel that registers a user after entering his/her info
 *
 */
public class RegisterPanel extends JPanel {

	private PanelHandler handler; 
	private JTextField fName, lName, userName, age; 
	private JPasswordField password; 
	private JRadioButton gender1, gender2; 
	private JButton registerButton, back; 
	private ButtonGroup group; 
	
	/**
	 * constructs a panel that allows the user to register his/her info.  
	 * @param handler handles the actions of the panel 
	 */
	public RegisterPanel(PanelHandler handler) {
	
		this.handler = handler; 
		
		BoxLayout layout = new BoxLayout(this, 1); 
		setLayout(layout); 
		
		fName = new JTextField(); 
		lName = new JTextField(); 
		age = new JTextField(); 
		userName = new JTextField(); 
		password = new JPasswordField();
		registerButton = new JButton("Register!"); 
		back = new JButton("Back"); 
		gender1 = new JRadioButton("Male", true);
		gender2 = new JRadioButton("Female"); 
		
		group = new ButtonGroup(); 
		group.add(gender1); 
		group.add(gender2);
		
		
		add(Box.createVerticalStrut(45)); 
		
		add(new JLabel("First Name")); 
		add(fName); 
		
		add(new JLabel("Last Name")); 
		add(lName); 
		
		add(new JLabel("Gender")); 
		add(gender1); 
		add(gender2); 
		
		add(new JLabel("Age")); 
		add(age); 
		
		add(new JLabel("Enter a username")); 
		add(userName); 
		
		add(new JLabel("Enter a password")); 
		add(password); 
		
		ActionListener a = new ButtonHandler(); 
		
		registerButton.addActionListener(a); 
		add(registerButton); 
		
		back.addActionListener(a);
		add(back); 
		
	}
	/**
	 * 
	 * class that handles the various buttons of the panel 
	 *
	 */
	class ButtonHandler implements ActionListener {

		@Override
		/**
		 * what happens when the user clicks on a button 
		 */
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			if(source == registerButton) {
				String username = userName.getText(); 
				String pword = String.valueOf(password.getPassword()); 
				String gender = ""; 
				if(gender1.isSelected()) {
					gender = "Male"; 
				} else if(gender2.isSelected()) {
					gender = "Female"; 
				}
				String firstname = fName.getText(); 
				String lastname = lName.getText(); 
				String a = age.getText(); 
				handler.handleRegistration(username, pword, gender, firstname, lastname, a);
				fName.cut();
				lName.cut();
				userName.cut();
				password.cut(); 
				age.cut(); 
			} else if(source == back) {
				handler.handleLogin();
			}
		}
		
	}
	
	
}
