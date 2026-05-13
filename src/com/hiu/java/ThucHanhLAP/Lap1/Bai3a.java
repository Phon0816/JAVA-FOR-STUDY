package com.hiu.java.ThucHanhLAP.Lap1;

public class Bai3a {
    package com.hiu.java.ThucHanhLAP.Lap1;

    abstract class Hinh {
        protected String mau;

        public Hinh(String mau) {
            this.mau = mau;
        }

        public abstract double TinhDienTich();

        public abstract double TinhChuVi();

        public String LayThongTin() {
            return "Màu sắc: " + this.mau;
        }
    }

    class HinhChuNhat extends Hinh {
        protected double chieudai;
        protected double chieurong;

        public HinhChuNhat(String mau, double chieudai, double chieurong) {
            super(mau);
            this.chieudai = chieudai;
            this.chieurong = chieurong;
        }

        @Override
        public double TinhDienTich() {
            return this.chieudai * this.chieurong;
        }

        @Override
        public double TinhChuVi() {
            return (this.chieudai + this.chieurong) * 2;
        }

        @Override
        public String LayThongTin() {
            return super.LayThongTin() + ", Chiều dài: " + this.chieudai + ", Chiều rộng: " + this.chieurong +
                    ", Diện tích: " + TinhDienTich() + ", Chu vi: " + TinhChuVi();
        }
    }

    class HinhTron extends Hinh {
        protected double bankinh;

        public HinhTron(String mau, double bankinh) {
            super(mau);
            this.bankinh = bankinh;
        }

        @Override
        public double TinhDienTich() {
            return Math.PI * this.bankinh * this.bankinh;
        }

        @Override
        public double TinhChuVi() {
            return 2 * Math.PI * this.bankinh;
        }

        @Override
        public String LayThongTin() {
            return super.LayThongTin() + ", Bán kính: " + this.bankinh +
                    ", Diện tích: " + TinhDienTich() + ", Chu vi: " + TinhChuVi();
        }
    }

    class HinhVuong extends HinhChuNhat {
        // Mặc dù trong đề ghi HinhVuong(String mau, double bankinh),
        // nhưng về mặt logic hình vuông sử dụng "cạnh".
        public HinhVuong(String mau, double canh) {
            super(mau, canh, canh);
        }

        @Override
        public String LayThongTin() {
            return "Màu sắc: " + this.mau + ", Cạnh: " + this.chieudai +
                    ", Diện tích: " + TinhDienTich() + ", Chu vi: " + TinhChuVi();
        }
    }

    public class KiemTraHinh {
        public static void main(String[] args) {
            // Tạo 3 đối tượng
            HinhChuNhat hinhChuNhat = new HinhChuNhat("Đỏ", 10.0, 5.0);
            HinhTron hinhTron = new HinhTron("Xanh", 3.0);
            HinhVuong hinhVuong = new HinhVuong("Vàng", 4.0);

            // Hiển thị thông tin
            System.out.println("--- Hình Chữ Nhật ---");
            System.out.println(hinhChuNhat.LayThongTin());

            System.out.println("\n--- Hình Tròn ---");
            System.out.println(hinhTron.LayThongTin());

            System.out.println("\n--- Hình Vuông ---");
            System.out.println(hinhVuong.LayThongTin());
        }
    }
}
