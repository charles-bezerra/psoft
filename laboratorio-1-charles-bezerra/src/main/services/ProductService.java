package main.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.google.gson.Gson;
import main.dto.ProductDTO;
import main.dto.ProductIdDTO;
import main.interfaces.Repository;
import main.interfaces.ServiceRelation;
import main.models.Product;

public class ProductService implements ServiceRelation {
  private Repository<String, Product> repository;
  private Gson gson = new Gson();

  public ProductService(Repository<String, Product> repository) {
    this.repository = repository;
  }

  public Product get(String data) {
    ProductIdDTO productDTO = gson.fromJson(data, ProductIdDTO.class);

    return repository.get(productDTO.getId());
  }

  public Collection<Product> getAll() {
    return this.repository.all();
  }

  public Collection<Product> search(String data) {
    ProductDTO productDTO = gson.fromJson(data, ProductDTO.class);

    Collection<Product> result = new ArrayList<>();
    Iterator<Product> productsIterator = this.repository.all().iterator();
    Product productAux = null;

    while (productsIterator.hasNext()) {
      productAux = productsIterator.next();
      if (productAux.getName().matches(productDTO.getName()))
        result.add(productAux);
    }

    return result;
  }

  public void remove(String data) {
    ProductIdDTO productDTO = gson.fromJson(data, ProductIdDTO.class);
    this.repository.remove(productDTO.getId());
  }

  @Override
  public void remove(Object object) {
    if (object == null)
      throw new IllegalArgumentException("Argument object not can a null value");

    if (object.getClass() != Product.class)
      throw new IllegalArgumentException("Argument has been of type models.Product");

    Product p = this.repository.remove(((Product) object).getId());

    if (p == null)
      throw new IllegalArgumentException("Product not found in repositories.ProductRepository");
  }

  public String create(String data) {
    ProductDTO prodDTO = gson.fromJson(data, ProductDTO.class);
    Product produto = new Product(prodDTO.getName(), prodDTO.getManufacturing(), prodDTO.getPrice());

    this.repository.add(produto);
    return produto.getId();
  }
}
