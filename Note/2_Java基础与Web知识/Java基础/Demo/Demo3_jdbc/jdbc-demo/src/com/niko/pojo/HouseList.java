package com.niko.pojo;

public class HouseList {
    private int houseid;
    private String address;
    private double price;

    public int getHouseid() {
        return houseid;
    }

    public void setHouseid(int houseid) {
        this.houseid = houseid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "houseid=" + houseid +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }
}
