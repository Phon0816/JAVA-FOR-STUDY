package com.hiu.java.ThucHanhLAP.Lap1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(findGCD(a, b));

        int nPerfect = sc.nextInt();
        System.out.println(isPerfectNumber(nPerfect));

        int nEven = sc.nextInt();
        System.out.println(isAllEvenDigits(nEven));

        double x = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(calculateS(x, n));

        sc.close();
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static boolean isPerfectNumber(int n) {
        if (n <= 0) return false;
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    public static boolean isAllEvenDigits(int n) {
        n = Math.abs(n);
        if (n == 0) return true;
        while (n > 0) {
            if ((n % 10) % 2 != 0) return false;
            n /= 10;
        }
        return true;
    }

    public static double calculateS(double x, int n) {
        double s = 0;
        for (int i = 0; i <= n; i++) {
            int power = 2 * i + 1;
            s += Math.pow(x, power) / factorial(power);
        }
        return s;
    }

    public static double factorial(int num) {
        double fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}