package org.example;

import java.util.List;

public class Order {

    private int id;
    private List<Product> items;
    private double totalPrice;
    private String customer;
    private String status;

    public Order(int id, List<Product> items, double totalPrice, String customer) {
        this.id = id;
        this.items = items;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.status = "New";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", status=" + status +
                '}';
    }


    public void changeStatusToProcessing() {
        this.status = "Processing";
    }

    public void changeStatusToShipped() {
        this.status = "Shipped";
    }

    public void changeStatusToCompleted() {
        this.status = "Completed";
    }

    public void changeStatusToCancelled() {
        this.status = "Cancelled";
    }
}