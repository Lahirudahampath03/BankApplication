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
public class Minor extends Account{
    private String bcNum;

    public Minor() {
    }

    public Minor(int AccNum, double Balance,String bcNum) {
        super(AccNum, Balance);
        this.bcNum = bcNum;
    }

    public String getBcNum() {
        return bcNum;
    }

    public void setBcNum(String bcNum) {
        this.bcNum = bcNum;
    }

    @Override
    public String show() {
        return super.show()+""+this.bcNum; //To change body of generated methods, choose Tools | Templates.
    }
 
    
    
    
    
    
}
