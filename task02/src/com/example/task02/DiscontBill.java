package com.example.task02;

import javax.crypto.spec.PSource;

public class DiscontBill extends Bill{
    private final double discont;
    public DiscontBill(int discont) {
        this.discont = discont;
    }
    public String getDiscont() {
        return discont + "%";
    }

    @Override
    public long getPrice() {
        double disc = super.getPrice() * (discont / 100);

        long price = super.getPrice();
        return Math.abs((long) disc - price);
    }

    public long getAbsoluteDiscont() {
        return super.getPrice()- getPrice();
    }
}
