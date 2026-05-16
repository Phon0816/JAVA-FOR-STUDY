package com.hiu.java.ThucHanhLAP.Lap2;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        ArrayList<Invoice> invoiceList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Nhap danh sach Invoice (Du lieu gia)");
            System.out.println("2. Xuat thong tin danh sach Invoice");
            System.out.println("3. Sap xep danh sach");
            System.out.println("4. Tim kiem Invoice theo Ma mat hang");
            System.out.println("5. Xoa mot Invoice theo Ma mat hang");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    taoDuLieuGia(invoiceList);
                    break;
                case 2:
                    xuatDanhSach(invoiceList);
                    break;
                case 3:
                    sapXepDanhSach(invoiceList);
                    break;
                case 4:
                    System.out.print("Nhap Ma mat hang can tim: ");
                    String maTim = scanner.nextLine();
                    timKiemInvoice(invoiceList, maTim);
                    break;
                case 5:
                    System.out.print("Nhap Ma mat hang can xoa: ");
                    String maXoa = scanner.nextLine();
                    xoaInvoice(invoiceList, maXoa);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void taoDuLieuGia(ArrayList<Invoice> list) {
        String[] partNumbers = {"P05", "P01", "P03", "P02", "P04", "P07", "P09", "P06", "P10", "P08"};
        int count = 0;

        for (int i = 0; i < partNumbers.length; i++) {
            boolean isDuplicate = false;
            for (Invoice inv : list) {
                if (inv.getPartNumber().equals(partNumbers[i])) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                list.add(new Invoice(partNumbers[i], "Mo ta san pham " + partNumbers[i], (i % 4) + 1, 150.5 * (i + 1)));
                count++;
            }
        }
        System.out.println("Da them " + count + " Invoice vao danh sach.");
    }

    private static void xuatDanhSach(ArrayList<Invoice> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sach trong.");
            return;
        }

        System.out.printf("%-10s | %-20s | %-10s | %-15s | %-15s\n", "Ma MH", "Mo ta", "So luong", "Gia", "Tong tien");
        System.out.println("--------------------------------------------------------------------------------");
        for (Invoice inv : list) {
            System.out.printf("%-10s | %-20s | %-10d | %-15.2f | %-15.2f\n",
                    inv.getPartNumber(),
                    inv.getPartDescription(),
                    inv.getQuantity(),
                    inv.getPricePerItem(),
                    inv.getInvoiceAmount());
        }
    }

    private static void sapXepDanhSach(ArrayList<Invoice> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                boolean needSwap = false;
                int maCompare = list.get(i).getPartNumber().compareTo(list.get(j).getPartNumber());

                if (maCompare > 0) {
                    needSwap = true;
                } else if (maCompare == 0) {
                    if (list.get(i).getQuantity() > list.get(j).getQuantity()) {
                        needSwap = true;
                    }
                }

                if (needSwap) {
                    Invoice temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("Da sap xep danh sach thanh cong.");
    }

    private static void timKiemInvoice(ArrayList<Invoice> list, String ma) {
        boolean found = false;
        for (Invoice inv : list) {
            if (inv.getPartNumber().equalsIgnoreCase(ma)) {
                System.out.println("Thong tin Invoice tim thay:");
                System.out.printf("%-10s | %-20s | %-10s | %-15s | %-15s\n", "Ma MH", "Mo ta", "So luong", "Gia", "Tong tien");
                System.out.printf("%-10s | %-20s | %-10d | %-15.2f | %-15.2f\n",
                        inv.getPartNumber(),
                        inv.getPartDescription(),
                        inv.getQuantity(),
                        inv.getPricePerItem(),
                        inv.getInvoiceAmount());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay Invoice voi ma: " + ma);
        }
    }

    private static void xoaInvoice(ArrayList<Invoice> list, String ma) {
        boolean removed = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPartNumber().equalsIgnoreCase(ma)) {
                list.remove(i);
                removed = true;
                System.out.println("Da xoa Invoice voi ma: " + ma);
                break;
            }
        }

        if (!removed) {
            System.out.println("Khong tim thay Invoice voi ma " + ma + " de xoa.");
        }
    }
}