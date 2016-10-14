/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vp.util.math.comb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author venzipetkov
 */
public class Permutation {
   public LinkedList<Integer> getPermutation(PermutationCode pc){
       LinkedList<Integer> result = new LinkedList<Integer>();
       int counter = 1;
       for (Iterator iterator = pc.code.iterator(); iterator.hasNext();) {
           Integer next = (Integer)iterator.next();
           result.add(next - 1, counter);
           counter++; 
       }
       return result;
   }
   
   public List permuteList(List list, PermutationCode pc){
       List result = new LinkedList();
       LinkedList<Integer> permutationOrigin = getPermutation(pc);
       for (Iterator iterator = permutationOrigin.iterator(); iterator.hasNext();) {
           Integer next = (Integer)iterator.next();
           result.add(list.get(next-1));
       }
       return list;
   }
}
