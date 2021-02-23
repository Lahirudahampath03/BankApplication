/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Business.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author lahiru dahampath
 */
public class UserAccountDB implements Iuser {

private Connection con;

public UserAccountDB(){
   
    try {
         
         con=DriverManager.getConnection("jdbc:mysql://localhost:3308/bankdb","root","");
            
        } catch (Exception e) {
           
         JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    
    
    
    
}

    @Override
    public int add(UserAccount ua) {
        
        int result=0;
        String insert="insert into UserAccount(ID,Cusername,Cpassword) values(?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(insert);
            ps.setInt(1, ua.getID());
            ps.setString(2, ua.getUsername());
            ps.setString(3, ua.getPassword());
                
                  
            
            result=ps.executeUpdate();
            return result;
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         return 0;
        }
        
        
        
        
        
    }

    @Override
    public int delete(int ID) {
       int result=0;
        String delete="delete from useraccount where ID=?";
        try{
            PreparedStatement ps=con.prepareStatement(delete);
            ps.setInt(1, ID);
            
                
  
            result=ps.executeUpdate();
            return result;
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         return 0;
        } 
    }

    @Override
    public int update(UserAccount ua) {
        int result=0;
        String update="update useraccount set Cusername=? , Cpassword=? where ID=?";
        try{
            PreparedStatement ps=con.prepareStatement(update);
            ps.setInt(1, ua.getID());
            ps.setString(1, ua.getUsername());
            ps.setString(2, ua.getPassword());   
            ps.setInt(3, ua.getID());
            result=ps.executeUpdate();
            return result;
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         return 0;
        } 
    }

    public UserAccount get(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }













}
