package panels;


import gui.PanelHandler;
import gui.TabSwitcher;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JTabbedPane;

import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;



public class WholeUI extends JPanel implements TabSwitcher {

	private TrackTransactionsPanel transactionsPanel;
	private TrackInvestmentsPanel investmentsPanel;
	private PlanPanel planPanel;
	private ViewProgressionPanel progressPanel; 
	private final PanelHandler handler;
    private JTabbedPane tabbedPane;

	public WholeUI(PanelHandler handler) {
		super();
		this.handler = handler;	
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		transactionsPanel = new TrackTransactionsPanel(handler);
		investmentsPanel = new TrackInvestmentsPanel(handler);
		planPanel = new PlanPanel(handler);
		progressPanel = new ViewProgressionPanel(); 
		

        setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("<html><body leftmargin=15 topmargin=5 marginwidth=24 marginheight=5>Transactions</body></html>", transactionsPanel);
        tabbedPane.addTab("<html><body leftmargin=15 topmargin=5 marginwidth=24 marginheight=5>Investments</body></html>", investmentsPanel);
        tabbedPane.addTab("<html><body leftmargin=15 topmargin=5 marginwidth=24 marginheight=5>Plan</body></html>", planPanel);
        tabbedPane.addTab("<html><body leftmargin=15 topmargin=5 marginwidth=24 marginheight=5>View Progression</body></html>", progressPanel); // add graph

		add(tabbedPane, BorderLayout.CENTER);

		setBounds(30,30,1100, 750);
	}

	
    public void switchToTab(int i) {
        tabbedPane.setSelectedIndex(i);
    }

}
