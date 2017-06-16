package panels;
import gui.PanelHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * panel that allows the user to choose how to manage his/her money 
 *
 */
public class IndividualOptionsPanel extends JPanel {
	
	private PanelHandler handler; 
	private JButton manageMoney;
	private JButton backButton; 
	private JButton quitButton;
	private JButton settings;
	
	/**
	 * constructs the panel with the respective buttons that represent the actions 
	 * @param handler
	 */
	public IndividualOptionsPanel(PanelHandler handler) {
		super(); 
		this.handler = handler; 
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		
		manageMoney = new JButton("Manage Money"); 
		settings = new JButton("Account Settings");
		backButton = new JButton("Back"); 
		quitButton = new JButton("Quit and Log Out"); 
		
		ActionListener a = new ButtonHandler(); 
		
		manageMoney.addActionListener(a); 
		settings.addActionListener(a);
		backButton.addActionListener(a); 
		quitButton.addActionListener(a); 
		
		add(manageMoney); 
		add(settings);
		add(backButton); 
		add(quitButton); 
	
		
		
		setLayout(new GridLayout(4 , 1 , 20 , 20));
	}
	/**
	 * handles the buttons on the panel 
	 *
	 */
	class ButtonHandler implements ActionListener {

		@Override
		/**
		 * what happens when the button is clicked 
		 */
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			if(source == manageMoney) {
				handler.handleMoneyManage(); 
			} else if(source == backButton) {
				handler.handleBackOptions();
			} else if(source == quitButton) {
				handler.handleQuit();
			} else if(source == settings) {
				handler.handleSettings();
			}
		}
		
	}
}
