package com.javatunes.persistence;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

public class ProductionItemRepository implements ItemRepository {

	// simulate an actual production database
	private CatalogData catalogData = new CatalogData();

	private Integer maxSearchResults = 30;

	// Accessors
	public Integer getMaxSearchResults() {
		return maxSearchResults;
	}
	public void setMaxSearchResults(Integer maxSearchResults) {
		this.maxSearchResults = maxSearchResults;
	}
	
	@Override
	public MusicItem findOne(Long id) {
		// Uses Java 8 Streams, and filters with a lambda that matches on id value.  
	    Optional<MusicItem> itemOptional = catalogData.stream()
	            .filter(item -> item.getId().equals(id))
	            .findAny();		
	    return itemOptional.orElse(null);  // Returns item if found, else returns null
	}
	
	@Override
	public Collection<MusicItem> findByArtistContainingOrTitleContainingAllIgnoreCase(String artist, String title) {

		String artistLow = artist.toLowerCase();
		String titleLow = title.toLowerCase();

		// Uses Java 8 Streams, and filters with a lambda that matches on title or artist
		// Uses a "finisher" to limit the side of the list.  This can be done more efficiently by limiting while you're creating the list
		// We do it this way for (relative) simplicity.  See https://stackoverflow.com/questions/33853611/limit-groupby-in-java-8 for guide to a more efficient solution
	    return catalogData.stream()
	            .filter(item -> item.getTitle().toLowerCase().contains(titleLow) ||
	                            item.getArtist().toLowerCase().contains(artistLow))
	            .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.size() <= maxSearchResults ? list : list.subList(0, maxSearchResults)));		
	}
	
	@Override
	public Collection<MusicItem> findByMusicCategory(MusicCategory category) {
		// Uses Java 8 Streams, and filters with a lambda that matches on musicCategory
		// Uses a "finisher" to limit the side of the list, same as findByArtistContainingOrTitleContainingAllIgnoreCase
	    return catalogData.stream()
	            .filter(item->item.getMusicCategory() == category)
	            .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.size() <= maxSearchResults ? list : list.subList(0, maxSearchResults)));	            
	}

	public Collection<MusicItem> findAll() {
		return Collections.unmodifiableCollection(catalogData);
	}

	@Override
	public long count() {
		return catalogData.size();
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


}
