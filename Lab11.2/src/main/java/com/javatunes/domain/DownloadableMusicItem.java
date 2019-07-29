/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name="DownloadableItem")
@PrimaryKeyJoinColumn(name="itemId")
public class DownloadableMusicItem extends MusicItem {

	private String url;
	private String fileType;

	public String getFileType() { return fileType; }
	public String getUrl() { return url; }

	public void setFileType(String fileType) { this.fileType = fileType; }
	public void setUrl(String url) { this.url = url; }

	public DownloadableMusicItem() {
	}

	public DownloadableMusicItem(String num, String title,
			String artist, LocalDate releaseDate, BigDecimal price) {
		setTitle(title);
		setArtist(artist);
		setReleaseDate(releaseDate);
		setPrice(price);
	}

	   public String toString() {
		   String comma = ", ";
		   StringBuffer sb = new StringBuffer();
		   sb.append("DownloadableItem: ");
		   sb.append(getUrl());
		   sb.append(comma);
		   sb.append(getFileType());
		   sb.append(comma);
		   sb.append(super.toString());
		   return sb.toString();
	   }


}
