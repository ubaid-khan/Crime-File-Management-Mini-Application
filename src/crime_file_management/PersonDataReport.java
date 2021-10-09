package crime_file_management;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class PersonDataReport extends JFrame  
{
    
    String name,adrs,email,phone,profession;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    JScrollPane jsp;
    PersonDataReport p;
    ArrayList<PersonDataReport> parraylist;
    
    public String getName(){
    return name;
    }
    
    public String getAddress(){
    return adrs;
    }
    
    public String getEmail(){return email;}
    
    public String getPhone(){return phone;}
    
    public String getProfession(){return profession;}
    
    public PersonDataReport(String n,String adr,String em,String ph,String pro)
    {
        p=new PersonDataReport(n, adr, em, ph, pro);
        ArrayList<PersonDataReport> parraylist=new ArrayList<PersonDataReport>();
        
        
        try 
        {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_database","root","");
            JOptionPane.showMessageDialog(rootPane,"Report Connection Made");   
        } 
        
        catch (SQLException ex) 
        {
          ex.printStackTrace();
        }
        }
    }
    public  ArrayList<PersonDataReport> getUsers(){
     try
        {
        String sqlshow="select * from person_database";
        ps=con.prepareStatement(sqlshow);
        rs=ps.executeQuery();
        
        while(rs!=null){
        p=new PersonDataReport(rs.getString("n"),rs.getString("adr"),rs.getString("em"),rs.getString("ph"),
                rs.getString("pro"));
                 parraylist.add(p);
        }
       
        }catch(SQLException se)
        {
        se.printStackTrace();
     }
        return parraylist;
    }
    
    public static void main(String args[]){
    JTable table=new JTable();
    DefaultTableModel model=new DefaultTableModel();
    Object[] columnsName = new Object[5];
    
        columnsName[0] = "name";
        columnsName[1] = "adrs";
        columnsName[2] = "email";
        columnsName[3] = "phone";
        columnsName[4]= "profession";
       
        model.setColumnIdentifiers(columnsName);
        
        Object[] rowData = new Object[5];
        
        for(int i = 0; i < getUsers().size(); i++)
        {
            
              rowData[0] = getUsers().get(i).getName();
              rowData[1] = getUsers().get(i).getAddress();
              rowData[2] = getUsers().get(i).getEmail();
              rowData[3] = getUsers().get(i).getPhone();
              rowData[4]= getUsers().get(i).getProfession();
              
              model.addRow(rowData);
    
    }
    }
   

