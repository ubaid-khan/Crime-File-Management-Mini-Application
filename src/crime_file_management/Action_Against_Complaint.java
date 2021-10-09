
package crime_file_management;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Ubaid Khan
 */
public class Action_Against_Complaint extends JFrame implements ActionListener 
{
    Connection con;
    PreparedStatement ps;
    
    JLabel actiondatelbl,actiontype,officer_inchargelbl,actiontimelbl;
    JTextField datetf,typetf,officertf,timetf;
    JButton submitinfo;
            
    
  
    public Action_Against_Complaint()
    {
        setLayout(null);
        actiondatelbl=new JLabel("Action taken on date:");
        actiondatelbl.setBounds(10, 10, 150, 25);
        actiontype=new JLabel("Type of Action:");
        actiontype.setBounds(10,50,150,25);
        officer_inchargelbl=new JLabel("Officer Incharge:");
        officer_inchargelbl.setBounds(10,90,150,25);
        actiontimelbl=new JLabel("Action taken at time:");
        actiontimelbl.setBounds(10,130,150,25);
        
        datetf=new JTextField(10);
        datetf.setBounds(165, 10, 200, 25);
        typetf=new JTextField(30);
        typetf.setBounds(165,50,200,25);
        officertf=new JTextField(15);
        officertf.setBounds(165,90,200,25);
        timetf=new JTextField(8);
        timetf.setBounds(165,130,200,25);
        
        submitinfo=new JButton("Save");
        submitinfo.addActionListener(this);
        submitinfo.setBounds(165,200,150,25);
        
        add(actiondatelbl);
        add(actiontype);
        add(officer_inchargelbl);
        add(actiontimelbl);
        add(datetf);
        add(typetf);
        add(officertf);
        add(timetf);
        add(submitinfo);
        
        try
        {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_database","root","");
        JOptionPane.showMessageDialog(rootPane,"Connected with Action Table");
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        
        
    }
  
    public void actionPerformed(ActionEvent e)
    {
        try
        {
    
        ps=con.prepareStatement("insert into action values(?,?,?,?)");
        ps.setString(1,typetf.getText());
        ps.setString(2,datetf.getText());
        ps.setString(3,timetf.getText());
        ps.setString(4,officertf.getText());
        
        
        int i=ps.executeUpdate();
        if(i==1){
        JOptionPane.showMessageDialog(rootPane,"Record inserted");
        }
        else
        {
        JOptionPane.showMessageDialog(rootPane,"Record not inserted");
        }
        }
        catch(SQLException se)
        {
        se.printStackTrace();;
        }
    
        
        
    }
}
