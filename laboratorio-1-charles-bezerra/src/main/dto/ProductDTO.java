package main.dto;

public class ProductDTO {
	private String name;

	private String manufacturing;

	private float price;

	public ProductDTO(String name, String manufacturing, float price) {
		this.name = name;
		this.manufacturing = manufacturing;
		this.price = price;
	}
	public String getName() {
		return name;
	}

	public String getManufacturing() {
		return manufacturing;
	}

	public float getPrice() {
		return price;
	}
}