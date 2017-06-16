package panels;

import gui.PanelHandler;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.*;

import management.*;


public class TrackTransactionsPanel extends JPanel {
	private final PanelHandler handler;
	private JButton addTransaction , removeTransaction , back , clear , enterBalance;
	private IndividualManagement manager;
	
	private JLabel balanceLabel;
	private double balance;
	
	private DefaultListModel listModel;
	private JList list;
	
	private boolean listPanelExist;
	
	
	public TrackTransactionsPanel(PanelHandler handler) {
		super();
		this.handler = handler;
		ActionListener a = new ButtonHandler();
		listPanelExist = false;
		
		JPanel buttonPanel = new JPanel();
		addTransaction = new JButton("Add Transaction");
		addTransaction.setPreferredSize(new Dimension(100 , 10));
		addTransaction.addActionListener(a);
		BorderLayout layout = new BorderLayout();
		buttonPanel.setLayout(new GridLayout(6 , 1));
		buttonPanel.add(addTransaction);
		setLayout(layout);
		
		
		
		removeTransaction = new JButton("Remove Transaction");
		removeTransaction.setPreferredSize(new Dimension(200 , 10));
		removeTransaction.addActionListener(a);
		buttonPanel.add(removeTransaction);
		
		enterBalance = new JButton("Enter balance");
		enterBalance.setPreferredSize(new Dimension(200 , 10));
		enterBalance.addActionListener(a);
		buttonPanel.add(enterBalance);
		
		
		clear = new JButton("Clear All Transactions");
		clear.setPreferredSize(new Dimension(200 , 10));
		clear.addActionListener(a);
		buttonPanel.add(clear);
		
		back = new JButton("Back to Options Menu");
		back.setPreferredSize(new Dimension(200 , 10));
		back.addActionListener(a);
		buttonPanel.add(back);
		
		manager = new IndividualManagement(balance);
		balanceLabel = new JLabel("Balance: $" + manager.getBalance());
		balanceLabel.setFont(new Font("Times New Roman" , Font.BOLD , 20));
		balanceLabel.setBackground(Color.GREEN);
		balanceLabel.setOpaque(true);
		buttonPanel.add(balanceLabel);	
		
		add(buttonPanel , BorderLayout.WEST);
		
		
		
	}

	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == addTransaction) {
				processAdd();
			} else if (source == removeTransaction) {
				processRemove();
			} else if (source == back) { 
				handler.handleIndividual();
			} else if (source == enterBalance) {
				processEnterBalance();
			} else if (source == clear) {
				processClear();
			}
		}	
	}
	
	private void processAdd() {
		
		JTextField amount = new JTextField(5);
	    JTextField place = new JTextField(20);
	    JTextField item = new JTextField(20);

	    JPanel myPanel = new JPanel();
	    
	    myPanel.add(new JLabel("Amount Spent: "));
	    myPanel.add(amount);
	      
	    myPanel.add(Box.createHorizontalStrut(15));
	    myPanel.add(new JLabel("Place Bought: "));
	    myPanel.add(place);
	      
	    myPanel.add(Box.createHorizontalStrut(15)); 
	    myPanel.add(new JLabel("Item/Service Purchased: "));
	    myPanel.add(item);
	        
	    if (manager.getBalance() <= 0) {
	    	JOptionPane.showMessageDialog(this, "You can't do this! You have a balance of $0!!!");
	    } else if (manager.getBalance() > 0) {	
	    
		   int result = JOptionPane.showConfirmDialog(this, myPanel ,"Transaction Data", JOptionPane.OK_CANCEL_OPTION);
		   
		   if(result == JOptionPane.OK_OPTION) {
		    
			   	 ArrayList <Item> items = manager.getItems();
		    	 String amountEntered = amount.getText();
		         String placeEntered = place.getText();
		         String itemEntered = item.getText();
		         double newAmount = 0;
		         try {
		        	  newAmount = Double.parseDouble(amountEntered);
		         } catch(Exception e) {
		        	 JOptionPane.showMessageDialog(this, "You have entered illegal characters. Try again!");
		        	 return;
		         }
		         manager.addTransaction(newAmount, placeEntered, itemEntered); 
		         balanceLabel.setText("Balance: $" + manager.getBalance());	         
			         
		        
		        if (items.size() == 1 && listPanelExist == false) {
			        JPanel listPanel = new JPanel();
			 		listPanel.setLayout(new BorderLayout());
			 		listModel = new DefaultListModel();
			 		
			 		
			 		for (int i = 0; i < items.size(); i++) {
			 			listModel.addElement(items.get(i).toString());
			 		}
			 		
			        list = new JList(listModel);
			        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			        list.setSelectedIndex(0);
			        list.setVisibleRowCount(10);
			       
			        list.setVisible(true);
			      
			        JScrollPane listScrollPane = new JScrollPane(list);
			       
			        listPanel.add(listScrollPane, BorderLayout.CENTER);
			        add(listPanel , BorderLayout.CENTER);	
			        listPanelExist = true;
		        
		        } else {
		        	listModel.removeAllElements();
		        	for (int i = 0; i < items.size(); i++) {
			 			listModel.addElement(items.get(i).toString());
			 		}
		        }
		   	}
	   	}
	 }
	
	private void processRemove() {		
		JTextField idField = new JTextField(5);
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Transaction Number of Item: "));
		myPanel.add(idField);
		
		if (manager.getItems().size() == 0) {
			JOptionPane.showMessageDialog(this, "You can't do this! You have no transactions to remove!!!");
		} else {
		
			int result = JOptionPane.showConfirmDialog(this, myPanel ,"Remove Transaction", JOptionPane.OK_CANCEL_OPTION);
			    
			if (result == JOptionPane.OK_OPTION) {    	  
		    	 String idEntered = idField.getText();
		    	 int id = 0;
		    	 try {
		    		 id = Integer.parseInt(idEntered);	
		    	 } catch (Exception e) {
		    		 JOptionPane.showMessageDialog(this, "You have entered illegal characters. Try again!");
		    		 return;
		    	 }
		         Item item = null;
		         for (int i = 0; i < manager.getItems().size(); i++) {
		        	 if (manager.getItems().get(i).getID() == id) {
		        		  item = manager.getItems().get(i);
		        	 }
		         }
		         manager.removeTransaction(id);
		         balanceLabel.setText("Balance: $" + manager.getBalance());
		         listModel.removeElement(item.toString());	 
		   }
	   } 
	}
	
	private void processEnterBalance() {		
		JTextField balanceField = new JTextField(5);
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Enter current balance "));
		myPanel.add(balanceField);	
		int result = JOptionPane.showConfirmDialog(this, myPanel ,"Enter Balance", JOptionPane.OK_CANCEL_OPTION);	    
		if (result == JOptionPane.OK_OPTION) {    	  
		   String balanceEntered = balanceField.getText();
		   try {
			   balance = Double.parseDouble(balanceEntered);
		   } catch(Exception e) {
			   JOptionPane.showMessageDialog(this, "You have entered illegal characters. Try again!");
			   return;
		   }
		   manager = new IndividualManagement(balance);
		   balanceLabel.setText("Balance: $" + manager.getBalance());
		} 
	}
	
	private void processClear() {
		if (manager.getItems().size() == 0) {
			JOptionPane.showMessageDialog(this, "You can't do this!!! You have no transactions!!!");
		} else {
			String[] options = {"Yes" , "No"};
			int n = JOptionPane.showOptionDialog(this,
				    "Are you sure you want to clear all transactions?",
				    "Confirm",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options,
				    options[1]);
			if (n == 0) {
				balanceLabel.setText("Balance: $" + balance);
				manager.getItems().clear();
				listModel.removeAllElements();
			}
		}
	}
}
