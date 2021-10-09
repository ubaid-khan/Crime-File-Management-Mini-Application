/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crime_file_management;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;


/** @author Ubaid Khan
 */
public class Database_Class extends JFrame 
{
   public Database_Class()
   {
    Connection con;
    Statement st;
    ResultSet rs;
try
{
Class.forName("com.mysql.jdbc.Driver");

JOptionPane.showMessageDialog(rootPane,"Driver Registered");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_database","root","");
JOptionPane.showMessageDialog(rootPane,"Connection Established");
}
catch(Exception e)
{
    e.printStackTrace();
JOptionPane.showMessageDialog(rootPane,"Connection Didn't Established");
}
   }
public static void main(String args[])
{
 }
}
