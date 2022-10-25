package main.models;

import java.util.UUID;

import main.interfaces.Searchable;

public class Allotment implements Searchable {
    private String id;
    private Product product;
    private Integer amount;
    private String expiretionDate;

    public Allotment(Product product, Integer amount, String expiretionDate) {
        this.product = product;
        this.amount = amount;
        this.expiretionDate = expiretionDate;
        this.id = UUID.randomUUID().toString();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return this.id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getExpirationDate() {
        return expiretionDate;
    }

    public void setExpirationDate(String expiretionDate) {
        this.expiretionDate = expiretionDate;
    }

    @Override
    public String toString() {
        return "Lote ID: " + getId() + " - Produto: " + getProduct().getName() + " - " + getAmount() + " itens";
    }
}
