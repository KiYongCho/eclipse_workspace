package io.ex;

import java.io.Serializable;
import java.util.List;

public class Shop implements Serializable {
	
	private static final long serialVersionUID = 92347839248732947L;
	
	private String name;
	private List<Product> productList;
	
	public Shop() {
	}

	public Shop(String name, List<Product> productList) {
		super();
		this.name = name;
		this.productList = productList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	@Override
	public String toString() {
		return "상점명: " + name + ", 제품리스트: " + productList;
	}

}









