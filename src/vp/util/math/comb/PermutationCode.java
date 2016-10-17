/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vp.util.math.comb;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author venzipetkov
 */
class PermutationCode {
    public LinkedList<Integer> code;
    public int degree;

    public PermutationCode(int degree) {
        code = new LinkedList<>();
        for (int i = 0; i < degree; i++) {
            code.add(i + 1);
        }
        this.degree = degree;
    }

    // copy constructor
    public PermutationCode(PermutationCode pCode) {
        code = (LinkedList<Integer>) pCode.code.clone();
        this.degree = pCode.degree;
    }

    public static PermutationCode inverseCode(PermutationCode pCode) {
        PermutationCode result = new PermutationCode(pCode.degree);
        for (int i = 0; i < pCode.code.size(); i++) {
            int item = pCode.code.get(i);
            result.code.set(i, i - item + 2);
        }
        return result;
    }

    private static PermutationCode generateNextCodeInverse(PermutationCode pCode) {
        PermutationCode result = new PermutationCode(pCode);
        int i = 0;
        for (Iterator iterator = result.code.descendingIterator(); iterator.hasNext();) {
            Integer next = (Integer) iterator.next();
            if (next < pCode.degree - i) {
                result.code.set(pCode.degree - i - 1, next + 1);
                break;
            } else {
                result.code.set(pCode.degree - i - 1, 1);
                result.code.set(pCode.degree - i - 2, pCode.code.get(pCode.degree - i - 2) + 1);
                if (result.code.get(pCode.degree - i - 2) < pCode.degree - i - 1) {
                    break;
                }
            }

            i++;
        }
        return result;
    }

    public static PermutationCode generateNextCode(PermutationCode pc) {
        PermutationCode result = inverseCode(pc);
        result = inverseCode(generateNextCodeInverse(result));
        return result;
    }

    public boolean eqalsTo(PermutationCode pCode) {
        boolean result = true;
        for (int i = 0; i < pCode.code.size(); i++) {
            int item = pCode.code.get(i);
            int myItem = this.code.get(i);
            result = result && item == myItem;
        }
        return result;
    }

}
