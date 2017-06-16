package panels;

import gui.PanelHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

public class PlanPanel extends JPanel {
	
	private PanelHandler handler;
	private JButton budget;
	private JButton calendar;
	  
	public PlanPanel(PanelHandler handler) {
		this.handler = handler;
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		
		ActionListener a = new ButtonHandler(); 
		
		budget = new JButton("Budget Your Money!");
		budget.setPreferredSize(new Dimension(300 , 100));
		budget.setFont(new Font("Arial" , Font.ITALIC , 20));
		budget.setBackground(Color.CYAN);
		budget.setContentAreaFilled(false);
		budget.setOpaque(true);		
		budget.addActionListener(a); 
		
		
		calendar = new JButton("View Your Calendar!");
		calendar.setPreferredSize(new Dimension(300 , 100));
		calendar.setFont(new Font("Arial" , Font.ITALIC , 20));
		calendar.setBackground(Color.CYAN);
		calendar.setContentAreaFilled(false);
		calendar.setOpaque(true);		
		calendar.addActionListener(a); 
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		add(budget);
		add(calendar);
	}
	
	
	public void paintComponent(Graphics g) {
    	Image bg = new ImageIcon("earth.jpg").getImage();
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == budget) {
				handler.handleBudget();
			} else if (source == calendar) {
				
			} 
			
		}
		
	}
	
}
