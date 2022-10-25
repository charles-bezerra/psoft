package main.dto;

public class AllotmentDTO {

	private String idProduct;

	private Integer amount;

	private String expiretionDate;

	public AllotmentDTO(String idProduct, Integer amount, String expiretionDate) {
		this.idProduct = idProduct;
		this.amount = amount;
		this.expiretionDate =  expiretionDate;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getExpiretionDate() {
		return expiretionDate;
	}
}
