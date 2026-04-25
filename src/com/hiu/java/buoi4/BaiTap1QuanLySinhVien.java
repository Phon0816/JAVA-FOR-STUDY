package com.hiu.java.buoi4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaiTap1QuanLySinhVien {
    public static void main(String[] args) {
        ArrayList<String> danhSachSV = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n===== QUẢN LÝ TÊN SINH VIÊN =====");
            System.out.println("1. Thêm Sinh viên");
            System.out.println("2. Xuất danh sách sinh viên");
            System.out.println("3. Sửa Sinh Viên");
            System.out.println("4. Xóa Sinh viên chứa tên bất kỳ");
            System.out.println("5. Tìm Sinh viên mà tên có chữ 'An'");
            System.out.println("6. Sắp xếp Sinh Viên");
            System.out.println("7. Xuất ra số lượng sinh viên");
            System.out.println("0. Thoát chương trình");
            System.out.print("=> Nhập lựa chọn của bạn (0-7): ");

            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập tên sinh viên cần thêm: ");
                    String tenThem = scanner.nextLine();
                    danhSachSV.add(tenThem);
                    System.out.println("-> Đã thêm sinh viên thành công!");
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
                    if (danhSachSV.isEmpty()) {
                        System.out.println("Danh sách hiện đang trống!");
                    } else {
                        for (int i = 0; i < danhSachSV.size(); i++) {
                            System.out.println((i + 1) + ". " + danhSachSV.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên sinh viên chính xác muốn sửa: ");
                    String tenCu = scanner.nextLine();
                    int viTri = danhSachSV.indexOf(tenCu);

                    if (viTri != -1) {
                        System.out.print("Nhập tên mới: ");
                        String tenMoi = scanner.nextLine();
                        danhSachSV.set(viTri, tenMoi);
                        System.out.println("-> Đã cập nhật thành công!");
                    } else {
                        System.out.println("-> Không tìm thấy sinh viên này trong danh sách.");
                    }
                    break;

                case 4:
                    System.out.print("Nhập từ khóa/tên muốn xóa: ");
                    String tuKhoa = scanner.nextLine();
                    boolean daXoa = danhSachSV.removeIf(ten -> ten.contains(tuKhoa));

                    if (daXoa) {
                        System.out.println("-> Đã xóa các sinh viên có chứa từ khóa '" + tuKhoa + "'!");
                    } else {
                        System.out.println("-> Không có sinh viên nào phù hợp để xóa.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- KẾT QUẢ TÌM KIẾM CÓ CHỮ 'AN' ---");
                    boolean timThay = false;
                    for (String ten : danhSachSV) {
                        if (ten.toLowerCase().contains("an")) {
                            System.out.println("- " + ten);
                            timThay = true;
                        }
                    }
                    if (!timThay) {
                        System.out.println("-> Không có sinh viên nào tên chứa chữ 'An'.");
                    }
                    break;

                case 6:
                    Collections.sort(danhSachSV);
                    System.out.println("-> Đã sắp xếp danh sách theo thứ tự chữ cái (A-Z)!");
                    break;

                case 7:
                    System.out.println("-> Tổng số lượng sinh viên hiện tại là: " + danhSachSV.size());
                    break;

                case 0:
                    System.out.println("-> Cảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("-> Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 7!");
            }
        } while (luaChon != 0);

        scanner.close();
    }
}