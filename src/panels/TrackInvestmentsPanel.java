package panels;

import gui.PanelHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import panels.TrackTransactionsPanel.ButtonHandler;

public class TrackInvestmentsPanel extends JPanel {
	
	private final PanelHandler handler; 
	public TrackInvestmentsPanel(PanelHandler handler) {
		super();
		this.handler = handler;
		ActionListener a = new ButtonHandler();
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
}	
