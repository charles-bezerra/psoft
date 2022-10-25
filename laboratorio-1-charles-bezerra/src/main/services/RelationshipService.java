package main.services;

import com.google.gson.Gson;
import main.dto.ProductIdDTO;
import main.models.Product;

public class RelationshipService {
  AllotmentService allotmentService;
  ProductService productService;
  Gson gson = new Gson();

  public RelationshipService(AllotmentService allotmentService, ProductService productService) {
    this.allotmentService = allotmentService;
    this.productService = productService;
  }

  public void removeProductDependents(String data) {
    ProductIdDTO productDTO = gson.fromJson(data, ProductIdDTO.class);
    Product product = productService.get(productDTO.getId());

    allotmentService.remove(product);
    productService.remove(product);
  }
}
