/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import Business.*;
/**
 *
 * @author icbt
 */
public interface IAccount {
    
    int add(Account ac);
    int delete(int AccNum);
    int update(Account ac);
    Account get(int AccNum);
    ArrayList<Account> getall();
    
    
    
}
