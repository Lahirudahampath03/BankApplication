/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author icbt
 */
public class AccountDB implements IAccount{
private Connection cn;

    public AccountDB() {
        try {
         
         cn=DriverManager.getConnection("jdbc:mysql://localhost:3308/bankdb","root","");
            
        } catch (Exception e) {
           
         JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
 
        
        
    }

    @Override
    public int add(Account ac) {
        int result=0;
        String insert="insert into account(Accnum,Balance,NIC,bcNum) values(?,?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(insert);
            ps.setInt(1, ac.getAccNum());
            ps.setDouble(2, ac.getBalance());
            if(ac instanceof Major){
               Major mc =(Major)ac;
               ps.setString(3,mc.getNIC());
               ps.setString(4,""); 
            }else{
                Minor mi=(Minor)ac;
                ps.setString(3,"");
                ps.setString(4, mi.getBcNum());
                
                
            
            }   
            
            result=ps.executeUpdate();
            return result;
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         return 0;
        }
    }

    @Override
    public int delete(int AccNum) {
       int result=0;
       String delete="delete from account where AccNum=?";
        try{
            PreparedStatement ps=cn.prepareStatement(delete);
            ps.setInt(1, AccNum);
            result=ps.executeUpdate();
            return result;
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         return 0;
        }
    }

    @Override
    public int update(Account ac) {
         int result=0;
        String update="update account set balance=?,NIC=?,BcNum=? where AccNum=?";
        try{
            PreparedStatement ps=cn.prepareStatement(update);
            ps.setInt(1, ac.getAccNum());
            ps.setDouble(1, ac.getBalance());
            if(ac instanceof Major){
               Major mc =(Major)ac;
               ps.setString(2,mc.getNIC());
               ps.setString(3,""); 
            }else{
                Minor mi=(Minor)ac;
                ps.setString(2,"");
                ps.setString(3, mi.getBcNum());
                                     
            }   
           
            
            ps.setInt(4, ac.getAccNum());
            result=ps.executeUpdate();
            return result;
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         return 0;
        }
    }

    @Override
    public Account get(int AccNum) {
      Account ac=null;
      String select="select * from Account where AccNum=?";
        try {
            
        PreparedStatement ps=cn.prepareStatement(select);
        ps.setInt(1, AccNum);
        ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                
             double Balance=rs.getDouble("Balance");
             String NIC=rs.getString("nic");
             String BcNum=rs.getString("BcNum");
                if (NIC.equals("")) {
                    ac=new Minor(AccNum, Balance, BcNum);
                    
                    
                }else{
                    
                ac=new Major(AccNum, Balance, NIC);
                
               
               }
                    
                }
                
            rs.close();
            return ac;
        
        } catch (Exception e) {
         
         JOptionPane.showMessageDialog(null, e.getMessage());
         return null;   
            
        }
        
    }

    @Override
    public ArrayList<Account> getall() {
      Account ac=null;
      ArrayList<Account> acList=new ArrayList<>();
      String select="select * from Account";
        try {
            
         PreparedStatement ps=cn.prepareStatement(select);
         ResultSet rs=ps.executeQuery();
            while (rs.next()) {
               int AccNum=rs.getInt("Accnum");
               double Balance=rs.getDouble("Balance");
             String NIC=rs.getString("nic");
             String BcNum=rs.getString("BcNum");
                if (NIC.equals("")) {
                ac=new Minor(AccNum, Balance, BcNum);
                    
                    
                }else{
                    
               ac=new Major(AccNum, Balance, NIC);
                
               
               }
                
             acList.add(ac); 
            }
            
         rs.close();
         return acList;
         
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
         return null;   
            
        }
    }
   
    
   
    
    
    
}
