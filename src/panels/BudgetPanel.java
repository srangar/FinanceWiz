package panels;

import gui.PanelHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import panels.TrackTransactionsPanel.ButtonHandler;
import management.*;

public class BudgetPanel extends JPanel {
	
	private final PanelHandler handler;
	private JButton addCategory;
	private JButton removeCategory;
	private JButton addMoney;
	private JButton removeMoney;
	private JButton reset;
	private JButton resetAll;
	private JButton back;
	
	private JPanel categoriesPanel;
	private JPanel progressPanel;	
	private JPanel addCategoryMessagePanel;
	
	private JTextField name;
	private JTextField budget;
	
	private JLabel nameLabel;
	private JLabel budgetLabel;
	private JLabel amountLeftLabel;
	
	private ArrayList<JProgressBar> bars;
	private ArrayList<String> names;
	private ArrayList<JLabel> amountLeftLabels;
	private ArrayList<JLabel> nameLabels;
	
	private int amount;
	private ArrayList<Integer> amounts;
	private ArrayList<Integer> amountLefts;
	
	/*
	 * ONLY THING LEFT TO DO IS TO ADD BARS IN A SPECIFIC ORDER 
	 */
	
	public BudgetPanel(PanelHandler handler) {
		super();
		this.handler = handler;
		ActionListener a = new ButtonHandler();
		
		bars = new ArrayList<JProgressBar>();
		names = new ArrayList<String>();
		amountLeftLabels = new ArrayList<JLabel>();
		amounts = new ArrayList<Integer>();
		nameLabels = new ArrayList<JLabel>();
		amountLefts = new ArrayList<Integer>();
		
		categoriesPanel = new JPanel();
		categoriesPanel.setLayout(new GridLayout(7 , 1));
		progressPanel = new JPanel();
		
		addCategory = new JButton("Add Category!");
		addCategory.addActionListener(a);
		removeCategory = new JButton("Remove Category!");
		removeCategory.addActionListener(a);
		addMoney = new JButton("Add Money!");
		addMoney.addActionListener(a);
		removeMoney = new JButton("Remove Money!");
		removeMoney.addActionListener(a);
		reset = new JButton("Reset!");
		reset.addActionListener(a);
		resetAll = new JButton("Reset All!");
		resetAll.addActionListener(a);
		back = new JButton("Back");
		back.addActionListener(a);
		
		addCategoryMessagePanel = new JPanel();
		nameLabel = new JLabel("Name of new category: ");
		budgetLabel = new JLabel("Budget: ");
		addCategoryMessagePanel.add(nameLabel);
		name = new JTextField(20);
		budget = new JTextField(10);
		addCategoryMessagePanel.add(name);
		addCategoryMessagePanel.add(budgetLabel);
		addCategoryMessagePanel.add(budget);
		
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		categoriesPanel.add(addCategory);
		categoriesPanel.add(removeCategory);
		categoriesPanel.add(addMoney);
		categoriesPanel.add(removeMoney);
		categoriesPanel.add(reset);
		categoriesPanel.add(resetAll);
		categoriesPanel.add(back);
		
		
		
		add(categoriesPanel , BorderLayout.WEST);
		
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == addCategory) {
				processAddCategory();
			} else if (source == removeCategory) {
				processRemoveCategory();
			} else if (source == addMoney) {
				processAddMoney();
			} else if (source == removeMoney) {
				processRemoveMoney();
			} else if (source == back) {
				handler.handleMoneyManage();
			} else if (source == reset) {
				processReset();
			} else if (source == resetAll) {
				processResetAll();
			}
		}		
	}
	
	private void processAddCategory() {		
		int result = JOptionPane.showConfirmDialog(this, addCategoryMessagePanel ,"Add Category", JOptionPane.OK_CANCEL_OPTION);
		 if (result == JOptionPane.OK_OPTION) {
			 nameLabel = new JLabel(name.getText());
			 nameLabels.add(nameLabel);
			 progressPanel.add(nameLabel);
			 names.add(name.getText());			 
			 String amnt = budget.getText();
			 try {
				 amount = Integer.parseInt(amnt);
			 } catch (Exception e) {
				 JOptionPane.showMessageDialog(this, "You have entered illegal characters. Try again!");
				 return;
			 }
			 amounts.add(amount);
			 amountLefts.add(amount);
			 JProgressBar bar = new JProgressBar(0 , amount);
			 double num = Math.random();
			 if (num <= .20)
				 bar.setForeground(Color.blue);
			 else if (num <= .40)
				 bar.setForeground(Color.GREEN);
			 else if (num <= .60)
				 bar.setForeground(Color.RED);
			 else if (num <= .80)
				 bar.setForeground(Color.BLACK);
			 else
				 bar.setForeground(Color.ORANGE);
			 bar.setStringPainted(true);
			 bar.setSize(new Dimension(700 , 700));
			 revalidate();
			 progressPanel.add(bar , BorderLayout.WEST);
			 amountLeftLabel = new JLabel("Amount left: $" + (amount - bar.getValue()));
			 amountLeftLabels.add(amountLeftLabel);
			 progressPanel.add(amountLeftLabel);
			 add(progressPanel , BorderLayout.CENTER); // have to figure out how to add bars in an organized fashion
			 name.setText("");
			 budget.setText("");
			 bars.add(bar);
		 }
	}
	
	private void processRemoveCategory() {
		JPanel removeCategoryPanel = new JPanel();
		JComboBox options = new JComboBox(names.toArray());
		removeCategoryPanel.add(options);
		int result = JOptionPane.showConfirmDialog(this, removeCategoryPanel ,"Remove Category", JOptionPane.OK_CANCEL_OPTION);		
		 if (result == JOptionPane.OK_OPTION) {
			 for (int i = 0; i < bars.size(); i++) {
				 if (i == options.getSelectedIndex()) {
					 if (names.get(i).equals(options.getItemAt(i))) {										
						 amounts.remove(i);
						 progressPanel.remove(bars.get(i));
						 progressPanel.remove(nameLabels.get(i));
						 progressPanel.remove(amountLeftLabels.get(i));
						 amountLeftLabels.remove(i);
						 revalidate();
						 bars.remove(i);
						 nameLabels.remove(i);
						 names.remove(i);
						 repaint();					 
					 }
				 }
			 }
		 }
	}
	
	private void processAddMoney() {		
		JPanel addMoneyPanel = new JPanel();
		JComboBox options = new JComboBox(names.toArray());
		addMoneyPanel.add(options);
		JTextField moneyField = new JTextField(10);
		addMoneyPanel.add(moneyField);
		int result = JOptionPane.showConfirmDialog(this, addMoneyPanel ,"Add Money", JOptionPane.OK_CANCEL_OPTION);		
		 if (result == JOptionPane.OK_OPTION) {
			 int money = 0;
			 try {
				money = Integer.parseInt(moneyField.getText());
			 } catch (Exception e) {
				 JOptionPane.showMessageDialog(this, "You have entered illegal characters. Try again!");
				 return;
			 }
			 for (int i = 0; i < bars.size(); i++) {
				 if (i == options.getSelectedIndex()) {
					 if (names.get(i).equals(options.getItemAt(i))) {
						 bars.get(i).setValue(Integer.parseInt(moneyField.getText()) + bars.get(i).getValue());				
						 amountLeftLabels.get(i).setText("Amount left: $" + (amounts.get(i) - money) + "\n");						
						 amounts.set(i, amounts.get(i) - money);
					 }
				 }
			 }
		 }
	}
	
	private void processRemoveMoney() {
		JPanel removeMoneyPanel = new JPanel();
		JComboBox options = new JComboBox(names.toArray());
		removeMoneyPanel.add(options);
		JTextField moneyField = new JTextField(10);
		removeMoneyPanel.add(moneyField);
		int result = JOptionPane.showConfirmDialog(this, removeMoneyPanel ,"Remove Money", JOptionPane.OK_CANCEL_OPTION);		
		 if (result == JOptionPane.OK_OPTION) {
			 int money = 0;
			 try {
				money = Integer.parseInt(moneyField.getText());
			 } catch (Exception e) {
				 JOptionPane.showMessageDialog(this, "You have entered illegal characters. Try again!");
				 return;
			 }
			 for (int i = 0; i < bars.size(); i++) {
				 if (i == options.getSelectedIndex()) {
					 if (names.get(i).equals(options.getItemAt(i))) {
						 bars.get(i).setValue(bars.get(i).getValue() - Integer.parseInt(moneyField.getText()));				
						 amountLeftLabels.get(i).setText("Amount left: $" + (amounts.get(i) + money) + "\n");						
						 amounts.set(i, amounts.get(i) + money);
					 }
				 }
			 }
		 }
	}
	
	private void processReset() {
		JPanel resetPanel = new JPanel();
		JComboBox options = new JComboBox(names.toArray());
		resetPanel.add(options);
		int result = JOptionPane.showConfirmDialog(this, resetPanel ,"Reset Budget", JOptionPane.OK_CANCEL_OPTION);		
		 if (result == JOptionPane.OK_OPTION) {
			 for (int i = 0; i < bars.size(); i++) {
				 if (i == options.getSelectedIndex()) {
					 if (names.get(i).equals(options.getItemAt(i))) {
						 bars.get(i).setValue(0);				
						 amountLeftLabels.get(i).setText("Amount left: $" + amountLefts.get(i));	
						 amounts.set(i, 0);
					 }
				 }
			 }
		 }
	}
	
	private void processResetAll() {
		String[] options = {"Yes" , "No"};
		int n = JOptionPane.showOptionDialog(this,
			    "Are you sure you want to reset all of your transactions?",
			    "Confirm",
			    JOptionPane.YES_NO_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[1]);
		if (n == 0) {
			for (int i = 0; i < bars.size(); i++) {
				bars.get(i).setValue(0);
				amountLeftLabels.get(i).setText("Amount left: $" + amountLefts.get(i));	
				amounts.set(i, 0);
			}
		}
	}
}
