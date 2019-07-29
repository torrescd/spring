/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

@Transactional(propagation=Propagation.REQUIRED)
public class JpaItemRepository implements ItemRepository {

	// Inject the persistence context
	@PersistenceContext
	private EntityManager em;


	// Normal version - lazy fetch
	public MusicItem findOne(Long id) {
	    // Call EntityManager.find() and return the result
	    return em.find(MusicItem.class, id);
	}

/*
	// Eager fetch version
	public MusicItem findOne(Long id) {	
		System.out.println("findOne called");
		String queryString = "SELECT m FROM MusicItem m LEFT JOIN FETCH m.inventoryRecords WHERE m.id = :id";
		TypedQuery<MusicItem> tq = em.createQuery(queryString, MusicItem.class);
		tq.setParameter("id", id);
		Collection<MusicItem> items = tq.getResultList();
		System.out.println("Number of items retrieved from query = " + items.size());
		HashSet<MusicItem> filteredItems = new HashSet<MusicItem>(items);
		System.out.println("Number of items after filtering = " + filteredItems.size());
		MusicItem theItem = filteredItems.iterator().next();
		return theItem;
	}
*/
	
	@Override
	public Collection<MusicItem> findAll() {
		// Implemented with dynamic query.
	    TypedQuery<MusicItem> q = em.createQuery("SELECT m FROM MusicItem m", MusicItem.class);
	    return q.getResultList();
	}


	@Override
	public long count() {
		// Not implemented
		return 0;
	}

	
	// Named query version for first part of query lab
	@Override
	public Collection<MusicItem> findByArtist(String artist) {
		// Implemented with named query
		TypedQuery<MusicItem> q = em.createNamedQuery("MusicItem.findByArtist", MusicItem.class);
	    q.setParameter("artist", artist);
		return q.getResultList();
	}
	
	@Override
	public Collection<MusicItem> findByArtistContainingOrTitleContainingAllIgnoreCase(String artist, String title) {
		String artistWildcarded = "%" + artist.toLowerCase() + "%";
		String titleWildcarded = "%" + title.toLowerCase() + "%";
        TypedQuery<MusicItem> q = em.createNamedQuery("MusicItem.findLikeTitleOrArtist", MusicItem.class);
        q.setParameter("artist", artistWildcarded);
        q.setParameter("title", titleWildcarded);
    	Collection<MusicItem> ret = q.getResultList(); 
    	return ret;
    }
	
	@Override
	public Collection<MusicItem> findByMusicCategory(MusicCategory category) {
		// Not implemented
		return null;
	}
	
	@Override
	public MusicItem save(MusicItem item) {
		// Use EM to persist.
		em.persist(item);
		return item;
	}

	@Override
	public void delete(MusicItem item) {
		// Use EM to remove
		em.remove(item);
	}

}
