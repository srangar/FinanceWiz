package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChangeUsernamePanel extends JPanel {

	private JButton change; 
	public ChangeUsernamePanel() {
		
		change = new JButton("Change!");
		change.addActionListener(new ButtonHandler());
	}
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			
			if(source == change)
			{
			
			}
			
		}
		
	}
}
