package com.example.psudoproject;

import java.time.LocalDate;

public class Medications {

    private int serialNumber;
    private String name;
    private int quantity;
    private LocalDate expiryDate;
    private LocalDate productionDate;
    private String photoLink;
    private float price;

    public Medications(){}

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public String getName() {
        return name;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

}
