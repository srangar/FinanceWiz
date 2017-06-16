package panels;

import gui.PanelHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ChangePasswordPanel extends JPanel {

	private JButton change; 
	private JPasswordField originalPassword; 
	private JPasswordField changePassword; 
	private JPasswordField verifyPassword; 
	private PanelHandler handler; 
	
	public ChangePasswordPanel(PanelHandler handler) {
		
		this.handler = handler; 
		
		change = new JButton("Change!"); 
		change.addActionListener(new ButtonHandler()); 
		
		add(new JLabel("Enter your old password")); 
		originalPassword = new JPasswordField(15); 
		add(originalPassword); 
		
		add(new JLabel("Enter your new password")); 
		changePassword = new JPasswordField(15); 
		add(changePassword); 
		
		add(new JLabel("Verify your new password")); 
		verifyPassword = new JPasswordField(15); 
		add(verifyPassword); 
		
		add(change); 
		
	}
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			
			if(source == change) {
			
				
			}
			
		}
		
	}
}
