/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

// TODO: Extend the correct interface to make this a repository definition using JPA for MusicItems.
public interface ItemRepository {
	
	// TODO: 2nd Spring Data Lab - Define query method to query by artist.
	/**
	 * Search on artist only.
	 * @param artist Artist to match on.
	 * @return The matching items - never null buy may be empty.
	 */
	
	
	/**
	 * Short, single parameter version of findByArtistContainingOrTitleContainingAllIgnoreCase
	 * @param keyword
	 * @return
	 */
	public default Collection<MusicItem> findByKeyword(String keyword) {
		return findByArtistContainingOrTitleContainingAllIgnoreCase(keyword, keyword);
	}
	/**
	 * Search on title and artist that contain the given keywords (i.e. are the keywords substrings)  
	 * @param artist artist to match on
	 * @param title title to match on
	 * @return The matching items - never null, but may be empty
	 */
	public Collection<MusicItem> findByArtistContainingOrTitleContainingAllIgnoreCase(String artist, String title);
	/**
	 * Search on music category
	 * @param category The category you want
	 * @return The matching items - never null, but may be empty
	 */
	public Collection<MusicItem> findByMusicCategory(MusicCategory category);
}
