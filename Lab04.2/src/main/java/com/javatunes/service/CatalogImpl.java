/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;

import java.util.Collection;

import javax.annotation.PostConstruct;

import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;
// Removed for Java Config @Component("musicCatalog")
public class CatalogImpl implements Catalog {

// Removed for Java Config	@Autowired
	private ItemRepository itemRepository;

	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

// DONE: add method for creation callback after construction
// DONE: add annotation for callback
	@PostConstruct
	public void init() {
		System.out.println("Post Construct called");
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
	
   // Added for this lab.
   public void remove(MusicItem item) {
	   itemRepository.delete(item);
   }
	
	
	@Override
	public String toString() {
		return "I am a shiny new " + getClass().getName() + " brought to you from Spring" + " but you can just call me " + getClass().getInterfaces()[0] + ".  My itemRepository is " + itemRepository;
	}

}
