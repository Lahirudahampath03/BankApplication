/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import Business.*;

/**
 *
 * @author lahiru dahampath
 */
public interface Iuser {
    
  int add(UserAccount ua);
  int delete(int ID); 
  int update (UserAccount ua);
}
