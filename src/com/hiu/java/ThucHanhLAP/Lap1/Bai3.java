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
        return super.LayThongTin() + ", Chiều dài: " + this.chieudai + ", Chiều rộng: " + this.chieurong + ", Diện tích: " + TinhDienTich() + ", Chu vi: " + TinhChuVi();
    }
}

public class Bai3 {
    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat("Đỏ", 10.5, 5.0);
        System.out.println(hcn.LayThongTin());
    }
}