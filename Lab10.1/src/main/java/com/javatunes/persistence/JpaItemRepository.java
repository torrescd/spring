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
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

public class JpaItemRepository implements ItemRepository {

	// Done: Add the annotation for the persistence context
	@PersistenceContext
	private EntityManager em;

	public MusicItem findOne(Long id) {
	    // Call EntityManager.find() and return the result
	    return em.find(MusicItem.class, id);
	}

	@Override
	public Collection<MusicItem> findAll() {
		// DONE: Implemented with dynamic query.
	    TypedQuery<MusicItem> q = em.createQuery("SELECT m FROM MusicItem m", MusicItem.class);
	    return q.getResultList();
	}


	@Override
	public long count() {
		// Not implemented
		return 0;
	}
/*
	// Dynamic query version for first part of query lab
	@Override
	public Collection<MusicItem> findByArtist(String artist) {
		// DONE: Implemented with dynamic query
		String artistQuery = "SELECT mi FROM MusicItem mi WHERE mi.artist = :artist";
		TypedQuery<MusicItem> q = em.createQuery(artistQuery, MusicItem.class);
	    q.setParameter("artist", artist);
		return q.getResultList();
	} 
*/	
	
	// Named query version for first part of query lab
	@Override
	public Collection<MusicItem> findByArtist(String artist) {
		// DONE: Implemented with named query
		TypedQuery<MusicItem> q = em.createNamedQuery("MusicItem.findByArtist", MusicItem.class);
	    q.setParameter("artist", artist);
		return q.getResultList();
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
		// DONE: Use EM to persist.
		em.persist(item);
		return item;
	}

	@Override
	public void delete(MusicItem item) {
		// DONE: Use EM to remove
		em.remove(item);
	}

	/**
	 * Utility method to test JPA queries in the testing structure we've set up.
	 * It is for ease of use only, and is not a standard repository method
	 */
	@Override
	public void testQueries() {
		
	}

}
