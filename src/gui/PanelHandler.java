package gui;

/**
 * handles the different panels in the program 
 *
 */
public interface PanelHandler {
	
	void handleSignIn(String userName, String password);
	void handleQuit();
	void handleRegisterRequest(); 
	void handleRegistration(String userName, String password, String gender, String fName, String lName, String age); 
	void handleInstructions(); 
	void handleBackOptions(); 
	void handleIndividual(); 
	void handleGraph(); 
	void handleMoneyManage();
	void handleChangeUsername(String s); 
	void handleChangePassword(String s); 
	void handleLogin(); 
	void handleBudget();
	void handleCompany();
	void handleSettings();
}