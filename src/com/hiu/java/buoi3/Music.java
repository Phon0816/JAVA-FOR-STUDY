package com.hiu.java.buoi3; // Bro nhớ đổi tên package cho khớp nếu cần nha

public class Music {
    public static void main(String[] args) {
        String path = "D:/music/bolero/longme.mp3";
        System.out.println("Đường dẫn gốc: " + path);

        int viTriGachCheo = path.lastIndexOf('/');

        String tenFileCoDuoi = path.substring(viTriGachCheo + 1);
        System.out.println("- Kết quả lấy tên file có đuôi: " + tenFileCoDuoi);

        int viTriDauCham = tenFileCoDuoi.lastIndexOf('.');

        String tenFileKhongDuoi = tenFileCoDuoi.substring(0, viTriDauCham);
        System.out.println("- Kết quả lấy tên file không đuôi: " + tenFileKhongDuoi);
    }
}