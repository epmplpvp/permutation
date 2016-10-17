/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vp.util.math.comb;

import java.util.ArrayList;
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
public class PermutationIntfTest {
    
    public PermutationIntf permIf;
    
    public PermutationIntfTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        permIf = PermutationFactory.getInitialPermutation(10);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of permuteList method, of class PermutationIntf.
     */
    @Test
    public void testPermuteList() {
        System.out.println("permuteList");
        List list = new ArrayList<String>();
        // first 10 time nextPermutation
        for (int i = 0; i < 10; i++) {
            list.add("number:"+(String.valueOf(i+1)));
            permIf = permIf.getNext();
        }
        List result = permIf.permuteList(list);
         System.out.println("Permutation Nr10");
        result.stream().forEach((text) -> {
            System.out.println(text.toString());
        });
        assertEquals(list.get(8), result.get(7));
        assertEquals(list.get(7), result.get(8));
        
        // second inversed permutation
        
        permIf = permIf.inverse();
        result = permIf.permuteList(list);
        System.out.println("\n Permutation inverse");
        result.stream().forEach((text) -> {
            System.out.println(text.toString());
        });
        assertEquals(list.get(8), result.get(2));
        assertEquals(list.get(7), result.get(1));
        
    }

    /**
     * Test of getNext method, of class PermutationIntf.
     */
//    @Test
//    public void testGetNext() {
//        System.out.println("getNext");
//        PermutationIntf instance = new PermutationIntfImpl();
//        PermutationIntf expResult = null;
//        PermutationIntf result = instance.getNext();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of inverse method, of class PermutationIntf.
     */
//    @Test
//    public void testInverse() {
//        System.out.println("inverse");
//        PermutationIntf instance = new PermutationIntfImpl();
//        PermutationIntf expResult = null;
//        PermutationIntf result = instance.inverse();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of equalsTo method, of class PermutationIntf.
     */
//    @Test
//    public void testEqualsTo() {
//        System.out.println("equalsTo");
//        PermutationIntf pi = null;
//        PermutationIntf instance = new PermutationIntfImpl();
//        boolean expResult = false;
//        boolean result = instance.equalsTo(pi);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
}
