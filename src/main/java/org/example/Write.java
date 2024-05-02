/**
 * File: Write.java
 * Description: Class contains a methods for writing different data to files
 * Author: Berezhnaya Svetlana
 * Date: 2.05.2024
 */

package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

    /**
     * A method for writing arrays data to csv file
     * @param fileName is of the file to which the data is being written
     * @param array1 is first array from where the data is read
     * @param array2 is second array from where the data is read
     * @param array3 is third array from where the data is read
     */
    public static void writeArraysToCSV(String fileName, int[] array1, int[] array2, int[] array3) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        try {
            writer.write("Для массивов: \n[");
            // Записываем элементы первого массива
            for (int num : array1) { writer.write(num + " ");}
            writer.write("]\n[");

            // Записываем элементы второго массива
            for (int num : array2) { writer.write(num + " ");}
            writer.write("]\n[");

            // Записываем элементы третьего массива
            for (int num : array3) { writer.write(num + " ");}
            writer.write("]");

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writer.flush();
            writer.close();
        }
    }

    /**
     * A method for writing time data to csv file
     * @param fileName is of the file to which the data is being written
     * @param result is data is being written
     */
    public static void writeTimeToCSV(String fileName, long result) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        try {
            writer.write("\nВремя работы программы: " + result + " нс.");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writer.flush();
            writer.close();
        }
    }

    /**
     * A method for writing time data to csv file
     * @param fileName is of the file to which the data is being written
     * @param f is first number is being written
     * @param s is second number is being written
     * @param t is third number is being written
     * @param result is result of the method checkSumm execution
     */
    public static void writeNumbersToCSV(String fileName, int f, int s, int t, boolean result) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        try {
            if (result) {
                writer.write("\nДля чисел: " + f + " " + s + " " + t);
            } else {
                writer.write("\nТройка чисел не была найдена");
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
