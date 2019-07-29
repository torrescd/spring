/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;

import java.util.Collection;

import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;

public class CatalogImpl implements Catalog {

	private ItemRepository itemRepository;

	public CatalogImpl() {}
	
	public CatalogImpl(ItemRepository itemRepository) {
		this.itemRepository=itemRepository;
	}
	public void persistBatch(Collection<MusicItem> items) {
		for (MusicItem musicItem : items) {
			itemRepository.save(musicItem);	
		}
		System.out.println("If you are seeing this, persistBatch ended normally!");
	}
	
	public void persist(MusicItem item) {
		itemRepository.save(item);
	}
	public void remove(MusicItem item) {
		itemRepository.save(item);
	}
	
	public MusicItem findById(Long id) {
		return itemRepository.findOne(id);
	}

	public Collection<MusicItem> findByKeyword(String keyword) {
		return itemRepository.findByKeyword(keyword);
	}

	@Override
	public long size() {
		return itemRepository.count();
	}
	
	@Override
	public String toString() {
		return "I am a shiny new " + getClass().getName() + " brought to you from Spring" + " but you can just call me " + getClass().getInterfaces()[0] + ".  My itemRepository is " + itemRepository;
	}



}
