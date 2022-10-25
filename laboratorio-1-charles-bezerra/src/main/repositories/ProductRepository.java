package main.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import main.interfaces.Repository;
import main.models.Product;

public class ProductRepository implements Repository<String, Product> {
  private Map<String, Product> products;

  public ProductRepository() {
    products = new HashMap<>();
  }

  public void add(Product product) {
    products.put(product.getId(), product);
  }

  public Product get(String id) {
    Product result = products.get(id);

    if (result == null)
      throw new IllegalArgumentException("Product not found in ProductRepository");

    return result;
  }

  public Collection<Product> all() {
    return products.values();
  }

  public Product remove(String id) {
    return products.remove(id);
  }

}
