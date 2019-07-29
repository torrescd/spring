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

public class ArtistPriceInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String artist;
	private BigDecimal yourPrice;
	
	// Default constructor is required for an Entity or Embeddable class
	public ArtistPriceInfo() {}
	
	public ArtistPriceInfo( String artist, BigDecimal price) {
		this.artist = artist;
		this.yourPrice = price;
	}
	
	public BigDecimal getYourPrice() {
		return yourPrice;
	}
	public void setYourPrice(BigDecimal yourPrice) {
		this.yourPrice = yourPrice;
	}
	

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String toString() {
		return "artsit = " + getArtist() + ", yourPrice= " + getYourPrice();
	}

}
