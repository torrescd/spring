/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class PriceInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal yourPrice;
	
	// Default constructor is required for an Entity or Embeddable class
	public PriceInfo() {}
	
	public PriceInfo( BigDecimal price) {
		this.yourPrice = price;
	}
	public BigDecimal getYourPrice() {
		return yourPrice;
	}
	public void setYourPrice(BigDecimal yourPrice) {
		this.yourPrice = yourPrice;
	}
	
	public void performFancyPricingMetrics() {
		System.out.println("We don't really do this in the lab.");
	}

	public String toString() {
		return " yourPrice= " + getYourPrice();
	}

}
