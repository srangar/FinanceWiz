package panels;
 
import gui.PanelHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * panel that allows the user to select what to manage 
 *
 */
public class MainPanel extends JPanel {
	
	private JButton individual, company;
	private PanelHandler handler; 
	
	/**
	 * constructs the panel in which the user can select to manage either himself/herself or a company
	 * @param handler handles the various panels and what happens when this panel is modified 
	 */
	public MainPanel(PanelHandler handler) {
		this.handler = handler; 
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		
		ActionListener a = new ButtonHandler(); 
		
		individual = new JButton("Individual");
		
		individual.setPreferredSize(new Dimension(300 , 100));
		individual.setFont(new Font("Arial" , Font.ITALIC , 20));
		individual.setBackground(Color.CYAN);
		individual.setContentAreaFilled(false);
		individual.setOpaque(true);		
		individual.addActionListener(a); 
		
		add(individual);
		
		company = new JButton("Company");
	
		company.setPreferredSize(new Dimension(300 , 100));
		company.setFont(new Font("Arial" , Font.ITALIC , 20));
		company.setBackground(Color.CYAN);
		company.setContentAreaFilled(false);
		company.setOpaque(true);
		company.addActionListener(a); 
		
		add(company);
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
	}
	/**
	 * draws the background image onto the panel 
	 */
    public void paintComponent(Graphics g) {
    	Image bg = new ImageIcon("mercury.jpg").getImage(); // fix the logo later
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
    /**
     * handles the buttons on the panel 
     *
     */
    class ButtonHandler implements ActionListener {

		@Override
		/**
		 * what happens when a button is clicked 
		 */
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource(); 
			
			if(source == individual) {
				handler.handleIndividual(); 
			} else if(source == company) {
				handler.handleCompany();
			}
		}
    	
    }
}
