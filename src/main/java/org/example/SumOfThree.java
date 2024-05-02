/**
 * File: SumOfThree.java
 * Description: Class contains a method that checks for the presence of numbers
 * in three arrays such that their sum is zero
 * Author: Berezhnaya Svetlana
 * Date: 1.05.2024
 */
package org.example;

import java.util.Arrays;

public class SumOfThree {
    /**
     * Checks a sum of three numbers from three arrays
     * @param A is first array
     * @param B is second array
     * @param C is third array
     * @return True if the sum do match (false if sum do not match)
     */
    public static boolean checkSumm(int[] A, int[] B, int[] C) {
        if (A == null || B == null || C == null || A.length == 0 || B.length == 0 || C.length == 0) {
            System.out.println("поиск невозможен, если какой-то из массивов пуст"); return false;
        }
        //сортировка в порядке возрастания массивов B и С
        Arrays.sort(B); Arrays.sort(C);

        //определяем больший по размеру массив из В и С
        int[] third, second;
        if (C.length >= B.length) {third = C; second = B;
        } else {second = C; third = B;}

        boolean result = false;
        for (int j : A) {
            int k = 0; //первый указатель (индекс в меньшем массиве)
            int n = third.length - 1; //второй указатель(индекс в большем массиве)

            while (k <= n) {
                if (j + second[k] + third[n] < 0) { //если сумма < 0, то необходимо рассмотреть число > second[k]
                    k++;
                } else if (j + second[k] + third[n] > 0) { //если сумма > 0, то необходимо рассмотреть число < third[n]
                    n--;
                } else { //если сумма = 0, прерываем цикл
                    result = true; break;
                }
            }
            if (result) { break; }
        } return result;
    }
}

