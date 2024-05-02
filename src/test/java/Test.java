/**
 * File: Test.java
 * Description: Class contains a tests for method checkSumm
 * Author: Berezhnaya Svetlana
 * Date: 2.05.2024
 */

import org.example.*;
import static org.junit.jupiter.api.Assertions.*;

public class Test {
    /*
    * @param A is array with numbers
     * @param B is null array
     * @param C is array with numbers
     * @param C is array with numbers
     * @return True if the sum do match (false if sum do not match)
     */
    @org.junit.jupiter.api.Test
    public void testForNullArray() {
        assertFalse(SumOfThree.checkSumm(A, B, C));
    }

    @org.junit.jupiter.api.Test
    public void testTrueForNotNullArray() {
        assertTrue(SumOfThree.checkSumm(A, C, D));
    }

    @org.junit.jupiter.api.Test
    public void testFalseForNotNullArray() {
        assertFalse(SumOfThree.checkSumm(A, C, E));
    }

    public int [] A = {1, 2, 3, 0, -60, 3};
    public int [] B = {};
    public int [] C = {4, 0, 9, 343};
    public int [] D = {-1, 789, -30, 999, 2, 90};
    public int [] E = {1, 52};
}
