/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vp.util.math.comb;

import java.util.List;

/**
 *
 * @author vp
 */
public interface PermutationIntf {

    List permuteList(List list);
    
    PermutationIntf getNext();
    
    PermutationIntf inverse();
    
    boolean equalsTo(PermutationIntf pi);
    
}
