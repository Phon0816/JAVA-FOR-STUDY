package com.hiu.java.Buoi6;

import java.util.ArrayList;

// 1. Lớp cha trừu tượng
abstract class StaffMember {
    protected String name;
    protected String address;
    protected String phone;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone;
    }

    public abstract double pay();
}

// 2. Lớp Volunteer
class Volunteer extends StaffMember {
    public Volunteer(String name, String address, String phone) {
        super(name, address, phone);
    }

    @Override
    public double pay() {
        return 0.0;
    }
}

// 3. Lớp Employee
class Employee extends StaffMember {
    protected String socialSecurityNumber;
    protected double payRate;

    public Employee(String name, String address, String phone, String ssn, double payRate) {
        super(name, address, phone);
        this.socialSecurityNumber = ssn;
        this.payRate = payRate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSSN: " + socialSecurityNumber;
    }

    @Override
    public double pay() {
        return payRate;
    }
}

// 4. Lớp Executive
class Executive extends Employee {
    private double bonus;

    public Executive(String name, String address, String phone, String ssn, double payRate) {
        super(name, address, phone, ssn, payRate);
        this.bonus = 0;
    }

    public void awardBonus(double execBonus) {
        this.bonus = execBonus;
    }

    @Override
    public double pay() {
        double totalPay = super.pay() + bonus;
        bonus = 0;
        return totalPay;
    }
}

// 5. Lớp Hourly
class Hourly extends Employee {
    private int hoursWorked;

    public Hourly(String name, String address, String phone, String ssn, double payRate) {
        super(name, address, phone, ssn, payRate);
        this.hoursWorked = 0;
    }

    public void addHours(int moreHours) {
        this.hoursWorked += moreHours;
    }

    @Override
    public double pay() {
        double totalPay = payRate * hoursWorked;
        hoursWorked = 0;
        return totalPay;
    }
}

// 6. Lớp quản lý Staff
class Staff {
    private ArrayList<StaffMember> staffList;

    public Staff() {
        staffList = new ArrayList<>();
    }

    public void addMember(StaffMember member) {
        staffList.add(member);
    }

    public void payday() {
        for (StaffMember member : staffList) {
            System.out.println(member.toString());
            System.out.println("Paid: " + member.pay());
            System.out.println("-------------------------");
        }
    }
}

// 7. Lớp chính thực thi bài tập
public class Bai1 {
    public static void main(String[] args) {
        Staff ptk = new Staff();


        Executive boss = new Executive("Nguyen Van Boss", "HCMC", "090", "SSN001", 5000);
        boss.awardBonus(1000);

        Hourly worker = new Hourly("Tran Van Worker", "Hanoi", "091", "SSN002", 20);
        worker.addHours(45);

        Volunteer free = new Volunteer("Le Thi Volunteer", "Da Nang", "092");

        ptk.addMember(boss);
        ptk.addMember(worker);
        ptk.addMember(free);

        System.out.println("--- KẾT QUẢ THANH TOÁN LƯƠNG ---");
        ptk.payday();
    }
}