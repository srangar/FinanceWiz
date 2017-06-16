package panels;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dataAnalysis.PieGraph;

public class ViewProgressionPanel extends JPanel {

	private PieGraph graph; 
	
	public ViewProgressionPanel() {
		
		graph = new PieGraph(); 
		
		setLayout(new GridLayout(1,1)); 
		add(graph); 
		
	}
}
