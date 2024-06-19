package com.yearup.dealership.models;

public class Vehicle {
    private String vin;
    private String make;
    private String model;
    private int year;
    private boolean sold;
    private String color;
    private String vehicleType;
    private int odometer;
    private double price;

    public Vehicle() {
    }

    public Vehicle(String vin, String make, String model, int year, boolean sold, String color, String vehicleType, int odometer, double price) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.sold = sold;
        this.color = color;
        this.vehicleType = vehicleType;
        this.odometer = odometer;
        this.price = price;
    }



    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return  String.format("| %-20s | %-15s | %-15s | %-7d | %-7b | %-10s | %-15s | %-15d | %-10.2f |", vin, make, model, year, sold, color,
                vehicleType, odometer, price);
    }

    public static String getHeader(){

        return String.format("| %-20s | %-15s | %-15s | %-7s | %-7s | %-10s | %-15s | %-15s | %-10s |", "VIN", "make", "model", "year", "SOLD",
                "color", "vehicleType", "odometer", "price");

    }
}