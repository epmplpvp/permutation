/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vp.util.math.comb;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author venzipetkov
 */
public class PermutationTest {
    
    public PermutationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPermutation method, of class Permutation.
     */
    @Test
    public void testGetPermutation() {
         try{
//             Initial permutation
            PermutationCode pc = new PermutationCode(3);
            Permutation instance = new Permutation();
            LinkedList<Integer> list = instance.getPermutation(pc);
            Object[] perm = list.toArray();
            int[] expected = {1,2,3};
            
            assertEquals(expected[2], perm[2]);
            assertEquals(expected[1], perm[1]);
            assertEquals(expected[0], perm[0]);

//            next permutation            
            
            PermutationCode pc1 = PermutationCode.generateNextCode(pc);
            list = instance.getPermutation(pc1);
            perm = list.toArray();
            int[] expected2 = {1,3,2};
            
            assertEquals(expected2[2], perm[2]);
            assertEquals(expected2[1], perm[1]);
            assertEquals(expected2[0], perm[0]);
            
//            inverted permutation            
            pc1 = PermutationCode.inverseCode(pc);
            list = instance.getPermutation(pc1);
            perm = list.toArray();
            int[] expected3 = {3,2,1};
            
            assertEquals(expected3[2], perm[2]);
            assertEquals(expected3[1], perm[1]);
            assertEquals(expected3[0], perm[0]);
            
        }
        catch (Exception e){
            fail("Initial permutation failed ");
        }
    }
    
    @Test
    public void testPermuteList() {
        try{
        LinkedList<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        
        PermutationCode pc = new PermutationCode(list.size());
        
        Permutation permutation = new Permutation();
        List actual = permutation.permuteList(list, pc);
        assertEquals(actual.get(0), list.get(0));
        assertEquals(actual.get(1), list.get(1));
        assertEquals(actual.get(2), list.get(2));
        assertEquals(actual.get(3), list.get(3));
        
        PermutationCode incPc = PermutationCode.inverseCode(pc);
        List actual2 = permutation.permuteList(list, incPc);
        assertEquals(actual.get(0), list.get(3));
        assertEquals(actual.get(1), list.get(2));
        assertEquals(actual.get(2), list.get(1));
        assertEquals(actual.get(3), list.get(0));
        }
        catch(Exception ex){
            fail("permute list fail");
        }
    }
    
}
