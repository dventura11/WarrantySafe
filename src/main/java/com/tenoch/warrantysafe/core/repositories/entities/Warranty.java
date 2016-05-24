package com.tenoch.warrantysafe.core.repositories.entities;

import java.util.Date;
import java.util.List;

public class Warranty extends BaseEntity{	

	private Integer idOwner;
	
	private Date buyDate;
	
	private Date expirationDate;
	
	private String brand;
	
	private String buyPlace;
	
	private String tickerImage;
	
	private String warrantymage;
	
	private List<String> extraImage;	

	public Integer getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Integer idOwner) {
		this.idOwner = idOwner;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBuyPlace() {
		return buyPlace;
	}

	public void setBuyPlace(String buyPlace) {
		this.buyPlace = buyPlace;
	}

	public String getTickerImage() {
		return tickerImage;
	}

	public void setTickerImage(String tickerImage) {
		this.tickerImage = tickerImage;
	}

	public String getWarrantymage() {
		return warrantymage;
	}

	public void setWarrantymage(String warrantymage) {
		this.warrantymage = warrantymage;
	}

	public List<String> getExtraImage() {
		return extraImage;
	}

	public void setExtraImage(List<String> extraImage) {
		this.extraImage = extraImage;
	}
	
	
}
