/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.util.Scanner;

/**
 *
 * @author jarif
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter width X: ");
        int width = scan.nextInt();
        System.out.print("Enter height Y: ");
        int height = scan.nextInt();
        System.out.print("Enter block size B: ");
        int blockSize = scan.nextInt();
        int centreRow = height / 2;
        int centreCol = width / 2;

        if (error(width, height, blockSize)) {
            System.out.println("Error: X and Y must be odd numbers between 7 and 29, and B must be between 1 \nand 3. 2");

        } else {
            for (int r = 0; r < height; r++) {

                int diagonal_One = (int) Math.round((double) r * (width - 1) / (height - 1));
                int diagonal_Two = (width - 1) - diagonal_One;
                for (int c = 0; c < width; c++) {

                    boolean firstLastRow = (r == 0 || r == height - 1);
                    boolean firstLastCol = (c == 0 || c == width - 1);

                    // STEP 4: priority rules, first match wins
                    if (firstLastRow && firstLastCol) {
                        System.out.print("+");
                    } else if (firstLastRow) {
                        System.out.print("=");
                    } else if (firstLastCol) {
                        System.out.print("I");
                    } else if (c == diagonal_One || c == diagonal_Two) {
                        System.out.print("X");
                    } else if (r == centreRow && c == centreCol) {
                        System.out.print("@");
                    } else if (r == centreRow) {
                        System.out.print("-");
                    } else if (c == centreCol) {
                        System.out.print("|");
                    } else if ((r / blockSize + c / blockSize) % 2 == 0) {
                        System.out.print(".");
                    } else {
                        System.out.print("o");
                    }
                }
                System.out.println();

            }
        }

    }

    public static boolean error(int width, int height, int blockSize) {
        boolean condition_width = width < 7 || width > 29 || width % 2 == 0;
        boolean condition_height = height < 7 || height > 29 || height % 2 == 0;
        boolean condition_baseSize = blockSize < 1 || blockSize > 3;
        return condition_width || condition_height || condition_baseSize;
    }

}
