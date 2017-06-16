package panels;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.PanelHandler;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;




/**
 * 
 * 
 *
 */
public class CompanyOptionsPanel extends JPanel {
	
	private PanelHandler handler;
	private JButton manageEquity;
	private JButton backButton; 
	private JButton quitButton;
	private JButton settings;
	
	public CompanyOptionsPanel(PanelHandler handler) {
		super(); 
		this.handler = handler; 
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		
		manageEquity = new JButton("Manage Equity"); 
		settings = new JButton("Account Settings");
		backButton = new JButton("Back"); 
		quitButton = new JButton("Quit and Log Out"); 
		
		ActionListener a = new ButtonHandler(); 
		
		manageEquity.addActionListener(a); 
		settings.addActionListener(a);
		backButton.addActionListener(a); 
		quitButton.addActionListener(a); 
		
		add(manageEquity); 
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
			if(source == manageEquity) {
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

