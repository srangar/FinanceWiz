package panels;

import gui.PanelHandler;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionsPanel extends JPanel {
	
	private JButton back;
	private PanelHandler handler; 
	
	public InstructionsPanel(PanelHandler handler) {
		
		setLayout(new FlowLayout());
		setBackground(Color.PINK);
		this.handler = handler;
		
		add(new JLabel("1. Click Register User"));
		add(Box.createHorizontalStrut(2233));
		add(new JLabel("2. Type in your name, age, username and password"));
		add(Box.createHorizontalStrut(2233));
		add(new JLabel("3. Click Register"));
		add(Box.createHorizontalStrut(2233));
		add(new JLabel("4. Log in using the information you provided"));
		add(Box.createHorizontalStrut(2233));
		add(new JLabel("5. Enjoy!"));
		add(Box.createHorizontalStrut(2233));
		
		back = new JButton("Back");
		back.addActionListener(new ButtonHandler());
		add(back);		
		
	}

	
	class ButtonHandler implements ActionListener {

		@Override
		/**
		 * what happens when the button is clicked 
		 */
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			
			if(source == back) 
			{
				handler.handleLogin();
			}
			
		}
	}
		
}
