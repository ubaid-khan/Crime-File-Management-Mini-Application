
package crime_file_management;
import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**@author Ubaid Khan
 */
class Person_Details extends JFrame implements ActionListener
{
    Connection con;
    PreparedStatement ps=null;
    
    JLabel person_name,per_address,phone_no,email,profession;
    JTextField p_name,p_addr,p_phone,p_email,prof;
    JButton submit;
    JFrame jf=new JFrame();
    public Person_Details(String title)
    {
        setLayout(null );
    person_name=new JLabel("Person Name:");
    person_name.setBounds(10, 10, 150, 25);
    per_address=new JLabel("Permanent Address:");
    per_address.setBounds(10, 50, 150, 25);
    phone_no=new JLabel("Phone No:");
    phone_no.setBounds(10,90,150, 25);
    profession=new JLabel("Profession");
    profession.setBounds(10, 130, 150, 25);
    email=new JLabel("Email Address:");
    email.setBounds(10, 170, 150, 25);
    
    p_name=new JTextField(15);
    p_name.setBounds(165, 10, 200, 25);
    p_addr=new JTextField(30);
    p_addr.setBounds(165, 50, 200, 25);
    p_phone=new JTextField(10);
    p_phone.setBounds(165, 90, 200, 25);
    prof=new JTextField(15);
    prof.setBounds(165, 130, 200, 25);
    p_email=new JTextField(15);
    p_email.setBounds(165, 170, 200, 25);
    submit=new JButton("Submit Details");
    submit.setBounds(165,240,200,25);
    submit.addActionListener(this);
    
    add(person_name);
    add(per_address);
    add(phone_no);
    add(email);
    add(p_name);
    add(p_addr);
    add(p_phone);
    add(profession);
    add(prof);
    add(p_email);
    add(submit);
    }
  @Override
    public void actionPerformed(ActionEvent e) 
    {
        
            
         try
         {
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_database","root","");
             JOptionPane.showMessageDialog(rootPane,"Connected with person database");
             String ins="insert into person_database(`Name`, `Address`, `Email`, `Phone`, `Profession`)values(?,?,?,?,?)";             
             ps=con.prepareStatement(ins);
             
             ps.setString(1, p_name.getText());
             ps.setString(2, p_addr.getText());
             ps.setString(3,p_email.getText());
             ps.setString(4, p_phone.getText());
             ps.setString(5, prof.getText());
             
             
         int i=ps.executeUpdate();
         if(i==1)
         {                                         
         JOptionPane.showMessageDialog(rootPane,"Record insereted");     
         }
         else
         {
             JOptionPane.showMessageDialog(rootPane,"Record not inserted");
         }
            }
         
         
         
            catch(HeadlessException | SQLException ec)
            {
                ec.printStackTrace();
            }
         
         Nature_Of_Complaints n=new Nature_Of_Complaints();
         n.setVisible(true);
    }
    public static void main(String args[])
    {
   
    }

    
}

  
