package com.hiu.java.buoi5;
import java.util.Scanner;


public class NhanVien {
    // 1. Các thuộc tính (image_a218b2.jpg)
    private String ho;
    private String ten;
    private int soSP;

    // 2. Hàm khởi tạo có kiểm tra số sản phẩm (image_a218b2.jpg)
    public NhanVien(String ho, String ten, int soSP) {
        this.ho = ho;
        this.ten = ten;
        if (soSP >= 0) {
            this.soSP = soSP;
        } else {
            this.soSP = 0;
        }
    }

    // 3. Các hàm lấy và gán giá trị (Get/Set)
    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public int getSoSP() { return soSP; }
    public void setSoSP(int soSP) {
        if (soSP >= 0) {
            this.soSP = soSP;
        } else {
            this.soSP = 0;
        }
    }

    // 4. Hàm tính lương theo bảng giá mới (image_789.png - hình bạn vừa gửi)
    public double getLuong() {
        double donGia;
        if (soSP >= 1 && soSP <= 199) {
            donGia = 0.5;
        } else if (soSP >= 200 && soSP <= 399) {
            donGia = 0.55;
        } else if (soSP >= 400 && soSP <= 599) {
            donGia = 0.6;
        } else if (soSP >= 600) {
            donGia = 0.65;
        } else {
            donGia = 0; // Trường hợp 0 sản phẩm
        }
        return this.soSP * donGia;
    }

    // 5. Hàm LonHon(NhanVien nv2)
    public boolean LonHon(NhanVien nv2) {
        return this.soSP > nv2.soSP;
    }

    // --- Hàm main thực hiện các yêu cầu nhập và so sánh ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin 2 nhân viên
        System.out.println("Nhập thông tin nhân viên 1:");
        System.out.print("Họ: "); String ho1 = scanner.nextLine();
        System.out.print("Tên: "); String ten1 = scanner.nextLine();
        System.out.print("Số sản phẩm: "); int sp1 = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống
        NhanVien nv1 = new NhanVien(ho1, ten1, sp1);

        System.out.println("\nNhập thông tin nhân viên 2:");
        System.out.print("Họ: "); String ho2 = scanner.nextLine();
        System.out.print("Tên: "); String ten2 = scanner.nextLine();
        System.out.print("Số sản phẩm: "); int sp2 = scanner.nextInt();
        NhanVien nv2 = new NhanVien(ho2, ten2, sp2);

        // Xuất lương
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Lương nhân viên 1 (" + nv1.getTen() + "): " + nv1.getLuong());
        System.out.println("Lương nhân viên 2 (" + nv2.getTen() + "): " + nv2.getLuong());

        // So sánh cách 1: Dùng hàm LonHon
        System.out.println("\n[Cách 1: Dùng hàm LonHon]");
        if (nv1.LonHon(nv2)) {
            System.out.println(nv1.getTen() + " có nhiều sản phẩm hơn " + nv2.getTen() + " là " + (nv1.getSoSP() - nv2.getSoSP()) + " SP");
        } else if (nv2.LonHon(nv1)) {
            System.out.println(nv2.getTen() + " có nhiều sản phẩm hơn " + nv1.getTen() + " là " + (nv2.getSoSP() - nv1.getSoSP()) + " SP");
        } else {
            System.out.println("Hai nhân viên có số sản phẩm bằng nhau.");
        }

        // So sánh cách 2: Không dùng hàm LonHon (so sánh trực tiếp qua Getter)
        System.out.println("\n[Cách 2: Không dùng hàm LonHon]");
        if (nv1.getSoSP() > nv2.getSoSP()) {
            System.out.println(nv1.getTen() + " nhiều hơn " + (nv1.getSoSP() - nv2.getSoSP()) + " sản phẩm.");
        } else if (nv1.getSoSP() < nv2.getSoSP()) {
            System.out.println(nv2.getTen() + " nhiều hơn " + (nv2.getSoSP() - nv1.getSoSP()) + " sản phẩm.");
        } else {
            System.out.println("Số sản phẩm bằng nhau.");
        }

        scanner.close();
    }
}