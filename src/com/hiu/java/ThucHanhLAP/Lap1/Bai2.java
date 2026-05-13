package com.hiu.java.ThucHanhLAP.Lap1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        NegativeNumberInStrings(str);
        sc.close();
    }

    public static void NegativeNumberInStrings(String str) {
        Pattern pattern = Pattern.compile("-\\d+");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}