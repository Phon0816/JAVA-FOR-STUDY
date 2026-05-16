package com.hiu.java.ThucHanhLAP.Lap2;

public class Invoice {
    // Các thuộc tính (instance variables)
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    // Constructor để khởi tạo các giá trị
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;

        // Kiểm tra điều kiện số lượng
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }

        // Kiểm tra điều kiện giá
        if (pricePerItem > 0.0) {
            this.pricePerItem = pricePerItem;
        } else {
            this.pricePerItem = 0.0;
        }
    }

    // --- Các phương thức Getter và Setter ---

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem > 0.0) {
            this.pricePerItem = pricePerItem;
        } else {
            this.pricePerItem = 0.0;
        }
    }

    public double getInvoiceAmount() {
        return this.quantity * this.pricePerItem;
    }

    // Hàm main
    public static void main(String[] args) {
        // Tạo một hóa đơn hợp lệ
        Invoice inv1 = new Invoice("RAM01", "RAM 16GB DDR4", 2, 1200.50);
        System.out.println("Mã mặt hàng: " + inv1.getPartNumber());
        System.out.println("Mô tả: " + inv1.getPartDescription());
        System.out.println("Số lượng: " + inv1.getQuantity());
        System.out.println("Giá: " + inv1.getPricePerItem());
        System.out.println("Tổng tiền hóa đơn 1: " + inv1.getInvoiceAmount());

        System.out.println("-------------------------");

        // Tạo một hóa đơn có số lượng và giá âm để test logic
        Invoice inv2 = new Invoice("CPU01", "Intel Core i7", -5, -300.0);
        System.out.println("Số lượng (bị đổi thành 0): " + inv2.getQuantity());
        System.out.println("Giá (bị đổi thành 0.0): " + inv2.getPricePerItem());
        System.out.println("Tổng tiền hóa đơn 2: " + inv2.getInvoiceAmount());
    }
}