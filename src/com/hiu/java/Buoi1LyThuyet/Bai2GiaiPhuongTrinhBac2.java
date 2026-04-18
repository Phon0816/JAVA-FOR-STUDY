package com.hiu.java.Buoi1LyThuyet;
import java.util.Scanner;

public class Bai2GiaiPhuongTrinhBac2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap a : ");
        double a = sc.nextDouble();
        System.out.println("Nhap b : ");
        double b = sc.nextDouble();
        System.out.println("Nhap c : ");
        double c = sc.nextDouble();

        if (a == 0){
            //Nhánh yes a=0
            if (b == 0) {
                //Nhánh yes b=0
                if (c == 0) {
                    //Nhánh yes c=0
                    System.out.println("Phuong trinh vo so nghiem");
                }else{
                    //Nhánh no c!=0
                    System.out.println("Phuong trinh vo nghiem");
                }
            }else{
                //Nhánh no b!=0
                double x = -c / b;
            }
        }else{
            //Nhánh no a!=0
            double delta = (b*b) - (4*a*c) ;
            if (delta < 0 ){
                //Nhánh Yes delta < 0
                System.out.println("Phuong trinh vo nghiem");
            }else{
                //Nhánh No delta >= 0
                if (delta == 0 ){
                    //Nhánh yes delta = 0
                    double x = - b / (2*a) ;
                }else{
                    //Nhánh delta > 0
                    double x1 = (-b + Math.sqrt(delta))/(2*a) ;
                    double x2 = (-b - Math.sqrt(delta))/(2*a) ;
                    System.out.println("Phương trình có 2 nghiệm phân biệt : ");
                    System.out.println("x1 = " + x1);
                    System.out.println("x2 = " + x2);
                }
            }
        }
        sc.close();
    }
}
