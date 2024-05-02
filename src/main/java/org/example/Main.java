/**
 * File: Main.java
 * Description: General class in project
 * Author: Berezhnaya Svetlana
 * Date: 2.05.2024
 */

package org.example;
import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        //выбираем числовой диапазон для рандомных чисел в массиве
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите минимальное число в массиве");
        int minNum = scan.nextInt();
        System.out.println("Выберите максимальное число в массиве");
        int maxNum = scan.nextInt();

        int minSize = 10, maxSize = 100;

        //замеряем время работы программы для 10 рандомных массивов
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();

            //создаем и заполняем рандомные массивы
            int[] A = createAndFillArray(minSize, maxSize, minNum, maxNum);
            int[] B = createAndFillArray(minSize, maxSize, minNum, maxNum);
            int[] C = createAndFillArray(minSize, maxSize, minNum, maxNum);

            boolean result = SumOfThree.checkSumm(A, B, C);

            long finish = System.nanoTime();
            long elapsed = finish - start;
            String filename = "./info" + i + ".csv";

            Write.writeArraysToCSV(filename, A, B, C);
            Write.writeNumbersToCSV(filename, SumOfThree.f, SumOfThree.s, SumOfThree.t, result);
            Write.writeTimeToCSV(filename, elapsed);
        }
    }

    /**
     * A method to initialize an array of random size.
     * @param minSize is minimum quantity of elements
     * @param maxSize is maximum quantity of elements
     * @return an array of generated integers
     */
    public static int[] createAndFillArray(int minSize, int maxSize, int minNum, int maxNum) {
        if (minSize > maxSize || minSize < 0) {
            System.out.println("неподходящие параметры для размера массива"); return null;
        }

        //генерация рандомного размера для массива
        int size = (int) (Math.random() * (maxSize - minSize) + minSize);
        int[] array = new int[size];

        //заполнение массива рандомными числами в указанном диапазоне
        if (minNum > maxNum ) {
            System.out.println("неподходящие параметры для чисел массива"); return null;
        }
        for (int j = 0; j < array.length; j ++) {
            array[j] = (int) (Math.random() * maxNum- minNum) + minNum;
        }
        return array;
    }
}