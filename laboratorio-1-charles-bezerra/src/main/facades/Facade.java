package main.facades;

import java.util.Collection;

import main.models.Allotment;
import main.models.Product;
import main.repositories.AllotmentRepository;
import main.repositories.ProductRepository;
import main.services.AllotmentService;
import main.services.ProductService;
import main.services.RelationshipService;

public class Facade {
	private AllotmentRepository allotmentRepository;
	private ProductRepository productRepository;

	private AllotmentService allotmentService;
	private ProductService productService;
	private RelationshipService relationshipService;

	public Facade() {
		allotmentRepository = new AllotmentRepository();
		productRepository = new ProductRepository();

		allotmentService = new AllotmentService(allotmentRepository, productRepository);
		productService = new ProductService(productRepository);
		relationshipService = new RelationshipService(allotmentService, productService);
	}

	public Collection<Allotment> getAllAlloment() {
		return allotmentService.getAll();
	}

	public String createAlloment(String jsonData) {
		return allotmentService.create(jsonData);
	}

	public Collection<Allotment> searchAllomentForProduct(String name) {
		return allotmentService.searchForProductName(name);
	}

	public void removeAlloment(String data) {
		allotmentService.remove(data);
	}

	public Product getProduct(String data) {
		return productService.get(data);
	}

	public Collection<Product> getAllProduct() {
		return productService.getAll();
	}

	public Collection<Product> searchProduct(String data) {
		return productService.search(data);
	}

	public void removeProduct(String data) {
		relationshipService.removeProductDependents(data);
	}

	public String createProduct(String data) {
		return productService.create(data);
	}
}