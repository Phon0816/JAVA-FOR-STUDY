package com.hiu.java.buoi4;
import java.util.ArrayList;

public class Bai4 {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] M = {3, 6, 7, 8, 11, 17, 2, 90, 2, 5, 4, 5, 8};

        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> nonPrimes = new ArrayList<>();

        for (int num : M) {
            if (num % 2 != 0) {
                odds.add(num);
            } else {
                evens.add(num);
            }

            if (isPrime(num)) {
                primes.add(num);
            } else {
                nonPrimes.add(num);
            }
        }
        System.out.println("- Dòng 1 : gồm các số lẻ là " + odds + ", tổng cộng có " + odds.size() + " số lẻ.");
        System.out.println("- Dòng 2 : gồm các số chẵn là " + evens + ", tổng cộng có " + evens.size() + " số chẵn.");
        System.out.println("- Dòng 3 : gồm các số nguyên tố là " + primes + ".");
        System.out.println("- Dòng 4 : gồm các số không phải là số nguyên tố là " + nonPrimes + ".");
    }
}