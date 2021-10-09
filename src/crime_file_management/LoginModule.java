
package crime_file_management;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class LoginModule extends JFrame implements ActionListener
{
	JLabel UserNameLabel,PasswordLabel;
	JTextField usernameTextField;
        JPasswordField passwordTextField;
	JButton Login;
	
	public LoginModule(String Title)
	{
            JFrame f=new JFrame();
		
            
                 UserNameLabel=new JLabel("UserName:");
                 UserNameLabel.setBounds(10, 10, 150, 25);
		 PasswordLabel=new JLabel("Password:");
                 PasswordLabel.setBounds(10, 50, 150, 25);
		 usernameTextField=new JTextField(10);
                 usernameTextField.setBounds(165, 10, 200, 25);
		 passwordTextField=new JPasswordField(10);
                 passwordTextField.setBounds(165, 40, 200, 25);
		 Login=new JButton("Login");
                 Login.setBounds(215, 70, 150, 25);
		 Login.addActionListener(this);
		
                 passwordTextField.setEchoChar('*');
                 
                 
                add(UserNameLabel);
                add(usernameTextField);
                add(PasswordLabel);
                add(passwordTextField);
                add(Login);
                           
		
	}
        @Override
	public void actionPerformed(ActionEvent ae)
	
	{
            
            
		 /*UserNameLabel=new JLabel("UserName:");
		 PasswordLabel=new JLabel("Password:");
		 usernameTextField=new JTextField(10);
		 passwordTextField=new JTextField(10);
		 Login=new JButton("Login");
		 Login.setActionListener(this);*/
	 
		
	if(usernameTextField.getText().equals("admin")&&passwordTextField.getText().equals("admin"))
		{
			JOptionPane.showMessageDialog(this,"Logged in successfully");
			Database_Class db=new Database_Class();
                        HomeModule m=new HomeModule("Home");
                        m.setVisible(true);
			}
		else
		{
			
			JOptionPane.showMessageDialog(this,"Unauthorised !");
			
		}
		

	}
	

public static void main(String args[])throws Exception
{
LoginModule m  = new LoginModule("Crime File Management System");
m.setLayout(null);
m.setSize(400,400);
m.setVisible(true);
}
/*public class Crime_File_Management {


    public static void main(String[] args) 
    {
    }
    
}*/

}