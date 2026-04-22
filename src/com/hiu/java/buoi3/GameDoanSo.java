package com.hiu.java.buoi3;

import java.util.Random;
import java.util.Scanner;

public class GameDoanSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean choiTiep = true;

        while (choiTiep) {
            int soCuaMay = random.nextInt(101);
            int soLanDoan = 0;
            boolean isWin = false;

            System.out.println("\n============= GAME ĐOÁN SỐ =============");
            System.out.println("Máy tính đã chọn một số bí mật từ 0 đến 100.");
            System.out.println("Bạn có tối đa 7 lần đoán. Bắt đầu nào!");

            while (soLanDoan < 7) {
                System.out.print("\nLần đoán thứ " + (soLanDoan + 1) + " - Nhập số của bạn: ");
                int soNguoiChoi = scanner.nextInt();
                soLanDoan++;

                if (soNguoiChoi == soCuaMay) {
                    System.out.println("🎉 WIN!!! Chúc mừng bạn đã đoán trúng số " + soCuaMay + " chỉ sau " + soLanDoan + " lần!");
                    isWin = true;
                    break;
                } else if (soNguoiChoi < soCuaMay) {
                    System.out.println("📉 Số bạn đoán NHỎ HƠN số của máy.");
                } else {
                    System.out.println("📈 Số bạn đoán LỚN HƠN số của máy.");
                }
            }
            if (!isWin) {
                System.out.println("\n💀 Game Over nha thím! Bạn đã hết 7 lần đoán.");
                System.out.println("Số bí mật của máy là: " + soCuaMay);
            }

            System.out.print("\nBạn có muốn chơi nữa không? (Y/N): ");
            String luaChon = scanner.next();

            if (luaChon.equalsIgnoreCase("N")) {
                choiTiep = false;
                System.out.println("Cảm ơn bạn đã chơi. Tạm biệt!");
            }
        }

        scanner.close();
    }
}