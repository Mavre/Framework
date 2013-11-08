package com.epam.reutska.domain;

import java.util.Map;

import org.openqa.selenium.WebElement;

public class BaseGood implements Comparable<BaseGood> {
	private String name;
	private Double price;
	private Map <String,String> paramMap;
	private String description;
	private double minBoundaryRangePrice;
	private double maxBoundaryRangePrice;
	private int id;
	public String getName() {
		return name;
	}

	public BaseGood withName(String name) {
		this.name = name;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public BaseGood withPrice(Double price) {
		this.price = price;
		return this;
	}
	public BaseGood withDescription(String description) {
		this.description=description;
		return this;
	}
	
	public BaseGood withPram(Map<String,String> paramMap) {
		this.paramMap = paramMap;
		return this;
	}
	public Map<String,String> getParam() {
		return paramMap;
	}
	
	
	
	public double getMinBoundaryRangePrice(){
		return minBoundaryRangePrice;
	}
	public void setMinBoundaryRangePrice(double minBoundaryRangePrice){
		this.minBoundaryRangePrice=minBoundaryRangePrice;
	}
	public double getMaxBoundaryRangePrice(){
		return maxBoundaryRangePrice;
	}
	public void setMaxBoundaryRangePrice(double maxBoundaryRangePrice){
		this.maxBoundaryRangePrice=maxBoundaryRangePrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseGood other = (BaseGood) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseGood [name=" + name + ", price=" + price + ", params=" + paramMap + "]";
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public BaseGood setId(int id) {
		this.id = id;
		return this;
	}

	@Override
	public int compareTo(BaseGood o) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	
	
}
