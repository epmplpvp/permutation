/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vp.util.math.comb;

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
public class PermutationCodeTest {
    PermutationCode pc;
    
    public PermutationCodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pc = new PermutationCode(21);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPermutationCode() {
        try {
            for (int i = 0; i < 21; i++) {
                int actual = pc.code.get(i);
                assertTrue(actual-1 == 0);
            }
        } catch (Exception e) {
            fail("constructor fail");
        }
        
    }
    @Test
    public void testInverseCodeFirstLast(){
        try {
        PermutationCode  newCode = PermutationCode.inverseCode(pc);
            for (int i = 0; i < newCode.degree; i++) {
               assertTrue(newCode.code.get(i) == i+1);
            }
        } catch (Exception e) {
            fail("inverseCode fail");
        }
    }
    
    @Test
    public void testInverseCode(){
        try {
        PermutationCode  newCode = new PermutationCode(4);
        newCode.code.set(2, 1);
        newCode.code.set(3, 2);
        PermutationCode actual = PermutationCode.inverseCode(newCode);
        assertTrue(actual.code.get(2)==3);
        assertTrue(actual.code.get(3)==3);
        
        } catch (Exception e) {
          fail("inverseCode fail");
        }
    }
    
    @Test
    public void testGenerateNextCode(){
        try {
        PermutationCode  nextCode = new PermutationCode(pc.degree);
        nextCode.code.set(19, 2);
        nextCode.code.set(20, 1);
        pc.code.set(20,21);
        PermutationCode  newCode = PermutationCode.generateNextCode(pc);
        assertTrue(newCode.eqalsTo(nextCode));
        } catch (Exception e) {
            fail("nextCode fail");
        }
    }
    
    
    
}
