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
public class Major extends Account{
    private String NIC;

    public Major() {
    }

    public Major( int AccNum, double Balance,String NIC) {
        super(AccNum, Balance);
        this.NIC = NIC;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    @Override
    public String show() {
        return super.show()+""+this.NIC; 
        
     }
    
    
    
    
}
