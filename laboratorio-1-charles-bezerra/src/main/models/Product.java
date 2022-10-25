package main.models;

import java.util.UUID;

import main.interfaces.Searchable;

public class Product implements Searchable {
    private String id;
    private String name;
    private String manufacturing;
    private float price;

    public Product(String name, String manufacturing, float price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.manufacturing = manufacturing;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getManufacturing() {
        return this.manufacturing;
    }

    public float getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object outher) {
        if (outher == null) {
            return false;
        }

        if (outher.getClass() != Product.class) {
            return false;
        }

        return this.id == ((Product) outher).getId();
    }

    public String toString() {
        return "Produto: " + getName() + " - Fabricante: " + getManufacturing();
    }
}
