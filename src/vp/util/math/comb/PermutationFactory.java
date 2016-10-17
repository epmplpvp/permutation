/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vp.util.math.comb;

/**
 *
 * @author vp
 */
public class PermutationFactory {
    
    public static PermutationIntf getInitialPermutation(int n){
        return new Permutation(n);
    }

}
