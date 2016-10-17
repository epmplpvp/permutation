/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vp.util.math.comb;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author venzipetkov
 */


class Permutation implements PermutationIntf {
   
    private PermutationCode pc;
    
    public Permutation(int n){
        this.pc = new PermutationCode(n);
    }
    
    public Permutation(PermutationCode pc){
        this.pc = pc;
    }
    
    
    public LinkedList<Integer> getPermutation(PermutationCode pc){
       LinkedList<Integer> result = new LinkedList<>();
       int counter;
       counter = 1;
       for (Integer next : pc.code) {
           result.add(next - 1, counter);
           counter++; 
       }
       return result;
    }
   
   
   
   public List permuteList(List list, PermutationCode pc){
       List result = new LinkedList();
       LinkedList<Integer> permutationOrigin = getPermutation(pc);
       permutationOrigin.forEach((next) -> {
           result.add( list.get(next-1));
       });
       return result;
   }
   
   public Permutation getNext(){
       Permutation newPerm = new Permutation(PermutationCode.generateNextCode(this.pc));
       return newPerm;
   }
   
   public Permutation inverse(){
       Permutation newPerm = new Permutation(PermutationCode.inverseCode(this.pc));
       return newPerm;
   }
   
    @Override
   public List permuteList(List list){
       List result = new LinkedList();
       LinkedList<Integer> permutationOrigin = getPermutation(this.pc);
       permutationOrigin.forEach((next) -> {
           result.add( list.get(next-1));
       });
       return result;
   }
   
   private boolean equalsTo(PermutationCode pc){
       return this.pc.eqalsTo(pc);
   }
   
   public boolean equalsTo(Permutation pi){
       return pi.equalsTo(this.pc);
   }
   
   public boolean equalsTo(PermutationIntf pi){
       return ((Permutation)pi).equalsTo(this);
   }
   
   
}
