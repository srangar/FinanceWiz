package panels;

import gui.PanelHandler;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AccountSettingsPanel extends JPanel {
	
	private JButton changeUsername; 
	private JButton changePassword; 
	private JButton back; 
	
	private PanelHandler handler; 
	
	public AccountSettingsPanel(PanelHandler handler) {
		
		setLayout(new GridLayout(3, 1, 20, 20)); 
		
		this.handler = handler; 
		
		ActionListener a = new ButtonHandler(); 
		
		changeUsername = new JButton("Change Username"); 
		changeUsername.addActionListener(a);
		add(changeUsername); 
		
		changePassword = new JButton("Change Password"); 
		changePassword.addActionListener(a);
		add(changePassword); 
		
		back = new JButton("Back"); 
		back.addActionListener(a);
		add(back); 
		 
	}

	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			if(source == changeUsername) {
				String s = (String)JOptionPane.showInputDialog(//creates popup(input) for dim3
		                null,
		                "Enter new Username:\n",
		                "Set Username",
		                JOptionPane.PLAIN_MESSAGE,
		                null, null,"");
				handler.handleChangeUsername(s); 
			} else if(source == changePassword) {
				String s = (String)JOptionPane.showInputDialog(//creates popup(input) for dim3
		                null,
		                "Enter new Password:\n",
		                "Set Password",
		                JOptionPane.PLAIN_MESSAGE,
		                null, null,"");
				handler.handleChangePassword(s);
			} else if(source == back) {
				handler.handleIndividual();
			}
			
		}
		
	}

}
