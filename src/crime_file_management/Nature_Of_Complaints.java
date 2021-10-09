
package crime_file_management;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author Ubaid Khan
 */
class Nature_Of_Complaints extends JFrame implements ActionListener{
     
    Connection con;
    PreparedStatement pst;
    
    String crimetype,crime,tm,per_inv;
    JLabel type,date,person_involve,time,loc;
    JTextField typeofcrime,p_involve,crime_date,timetf,locationtf;
    JButton submit;
    public Nature_Of_Complaints()
    {
        setLayout(null);
        JFrame jfr=new JFrame();
        submit=new JButton("Submit");
        submit.setBounds(165,240,200,25);
        submit.addActionListener(this);
    type=new JLabel("Nature of complaint:");
    type.setBounds(10,10,150,25);
    person_involve=new JLabel("Involved persons:");
    person_involve.setBounds(10,50,150,25);
    date=new JLabel("Date of incident:");
    date.setBounds(10,90,150,25);
    time=new JLabel("Time of incident");
    time.setBounds(10,130,150,25);
    loc=new JLabel("Location of incident:");
    loc.setBounds(10,170,150,25);
    
    
    typeofcrime=new JTextField(15);
    typeofcrime.setBounds(165, 10, 200, 25);
    p_involve=new JTextField(10);
    p_involve.setBounds(165,50,200,25);
    crime_date=new JTextField(8);
    crime_date.setBounds(165,90,200,25);
    timetf=new JTextField(8);
    timetf.setBounds(165,130,200,25);
    locationtf=new JTextField(30);
    locationtf.setBounds(165,170,200,25);
    
    
    add(type);
    add(date);
    add(person_involve);
    add(time);
    add(loc);
    add(typeofcrime);
    add(crime_date);
    add(p_involve);
    add(timetf);
    add(locationtf);
    add(submit);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
     /*crimetype=typeofcrime.getText();
     per_inv=p_involve.getText();
     crime=crime_date.getText();
     tm=t.getText();*/
    
    try
    {
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_database","root","");
    JOptionPane.showMessageDialog(rootPane,"Connected with Nature of crime table");
    String add="INSERT INTO `nature_of_crime`(`Type`, `person_involved`, `Date`, `Time`, `Location`)values(?,?,?,?,?);";
    
    
    pst=con.prepareStatement(add);
    
    pst.setString(1,typeofcrime.getText());
    pst.setString(2,p_involve.getText());
    pst.setString(3,crime_date.getText());
    pst.setString(4,timetf.getText());
    pst.setString(5,locationtf.getText());
    
    int i=pst.executeUpdate();
    if(i==1)
    {
    JOptionPane.showMessageDialog(rootPane,"Record Inserted");
    }
    else
    {
    JOptionPane.showMessageDialog(rootPane,"Record not inserted");
    }
    con.close();
    }
    catch(SQLException se)
    {
    se.printStackTrace();
    }
    
    
    }
}

