/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

public class JpaItemRepository implements ItemRepository {

	// TODO: Add the annotation for the persistence context
	private EntityManager em;

	public MusicItem findOne(Long id) {
	    // Call EntityManager.find() and return the result
	    return em.find(MusicItem.class, id);
	}

	@Override
	public Collection<MusicItem> findAll() {
		// Not implemented
		return null;
	}


	@Override
	public long count() {
		// Not implemented
		return 0;
	}

	@Override
	public Collection<MusicItem> findByArtist(String artist) {
		// Not implemented
		return null;
	} 
	
	@Override
	public Collection<MusicItem> findByArtistContainingOrTitleContainingAllIgnoreCase(String artist, String title) {
		// Not implemented
		return null;
	}
	
	@Override
	public Collection<MusicItem> findByMusicCategory(MusicCategory category) {
		// Not implemented
		return null;
	}
	
	@Override
	public MusicItem save(MusicItem item) {
		// Not implemented
		return null;
	}

	@Override
	public void delete(MusicItem item) {
		// Not implemented
	}

	/**
	 * Utility method to test JPA queries in the testing structure we've set up.
	 * It is for ease of use only, and is not a standard repository method
	 */
	@Override
	public void testQueries() {
	}
}
