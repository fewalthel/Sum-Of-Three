/**
 * File: Main.java
 * Description: General class in project
 * Author: Berezhnaya Svetlana
 * Date: 1.05.2024
 */

package org.example;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
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
            writeArraysToCSV("info.csv", A, B, C);
            writeTimeToCSV("info.csv", elapsed);
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
        if (minNum > maxNum || minNum < 0) {
            System.out.println("неподходящие параметры для чисел массива"); return null;
        }
        for (int j = 0; j < array.length; j ++) {
            array[j] = (int) (Math.random() * maxNum- minNum) + minNum;
        }
        return array;
    }


    /**
     * A method for writing arrays data to csv file
     * @param fileName is of the file to which the data is being written
     * @param array1 is first array from where the data is read
     * @param array2 is second array from where the data is read
     * @param array3 is third array from where the data is read
     */
    public static void writeArraysToCSV(String fileName, int[] array1, int[] array2, int[] array3) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("Для массивов: [");
            // Записываем элементы первого массива
            for (int num : array1) { writer.write(num + " ");}
            writer.write("] [");

            // Записываем элементы второго массива
            for (int num : array2) { writer.write(num + " ");}
            writer.write("] [");

            // Записываем элементы третьего массива
            for (int num : array3) { writer.write(num + " ");}
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            System.out.println(e); // Выводим ошибку в консоль
        }
    }

    /**
     * A method for writing time data to csv file
     * @param fileName is of the file to which the data is being written
     * @param result is data is being written
     */
    public static void writeTimeToCSV(String fileName, long result) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(" - "+result+" наносек.\n"); // Записываем значение переменной на следующей строке
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}