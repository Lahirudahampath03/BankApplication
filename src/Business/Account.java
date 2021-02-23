/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author icbt
 */
public class Account {
    
    private int AccNum;
    private double Balance;

    public Account() {
    }

    public Account(int AccNum, double Balance) {
        this.AccNum = AccNum;
        this.Balance = Balance;
    }

    public int getAccNum() {
        return AccNum;
    }

    public void setAccNum(int AccNum) {
        this.AccNum = AccNum;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }
    
    public double Deposit(double Amount){
        
     this.Balance = this.Balance+Amount;
     return this.Balance;
        
    }
    
    public double Withdraw (double Amount){
        
        if (this.Balance>=Amount) {
           
         this.Balance = this.Balance-Amount;
         return this.Balance;
            
        } else {
            
          return -1;
        }
    }
    
     public String show (){
         
         
       return this.AccNum+""+this.Balance; 
        
     }
      
}
