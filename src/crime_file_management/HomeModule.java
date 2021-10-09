
package crime_file_management;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/* @author Ubaid Khan
 */
public class HomeModule extends JFrame implements ActionListener
{

    JButton person_details,NOC,AOC,report;
    public HomeModule(String title)
    {
    JFrame f=new JFrame();
    setLayout(null);
    person_details=new JButton("Insert Person Details");
    person_details.setBounds(100, 10, 250, 25);
    NOC=new JButton("Nature Of Complaint");
    NOC.setBounds(100, 70, 250, 25);
    AOC=new JButton("Action Against Complaint");
    AOC.setBounds(100, 130,250, 25);
    report=new JButton("Report");
    report.setBounds(100, 190, 250, 25);
    
    person_details.addActionListener(this);
    NOC.addActionListener(this);
    AOC.addActionListener(this);
    report.addActionListener(this);
    
    add(person_details);
    add(NOC);
    add(AOC);
    add(report);
        
   
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
       String getButton=e.getActionCommand();
       if(getButton.equals("Insert Person Details")){
       Person_Details p=new Person_Details("Person Details");
       p.setVisible(true);
       
       }
       if(getButton.equals("Nature Of Complaint")){
       Nature_Of_Complaints n=new Nature_Of_Complaints();
       n.setVisible(true);
       }
       if(getButton.equals("Action Against Complaint")){
       Action_Against_Complaint a=new Action_Against_Complaint();
       a.setVisible(true);
       }
       if(getButton.equals("Report")){
       PersonDataReport r=new PersonDataReport();
       r.setVisible(true);
       }
      
    
}
}
