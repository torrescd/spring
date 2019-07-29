/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

public class CatalogData extends ArrayList<MusicItem>{

	private static final long serialVersionUID = 1L;

	{
	      add(1, "Diva", "Annie Lennox", "1992-01-04", "13.99", MusicCategory.POP);
	      add(2,"Dream of the Blue Turtles", "Sting", "1985-02-05", "14.99", MusicCategory.POP);
	      add(3,"Trouble is...", "Kenny Wayne Shepherd Band", "1997-08-08", "14.99", MusicCategory.BLUES);
	      add(4,"Lie to Me", "Jonny Lang", "1997-08-26", "17.97", MusicCategory.BLUES);
	      add(5,"Little Earthquakes", "Tori Amos", "1992-01-18", "14.99", MusicCategory.ALTERNATIVE);
	      add(6,"Seal", "Seal", "1991-08-18", "17.97", MusicCategory.POP);
	      add(7,"Ian Moore", "Ian Moore", "1993-12-05", "9.97", MusicCategory.CLASSICAL);
	      add(8,"So Much for the Afterglow", "Everclear", "1997-01-19", "13.99", MusicCategory.ROCK);
	      add(9,"Surfacing", "Sarah McLachlan", "1997-12-04", "17.97", MusicCategory.ALTERNATIVE);
	      add(10,"Hysteria", "Def Leppard", "1987-06-20", "17.97", MusicCategory.ROCK);
	      add(11,"A Life of Saturdays", "Dexter Freebish", "2000-12-06", "16.97", MusicCategory.RAP);
	}


	   private void add(Integer id,String title, String artist,String releaseDate, String price, MusicCategory musicCategory){
	     this.add(new MusicItem((long)id, title, artist, releaseDate, new BigDecimal(price), musicCategory ));
	   }
}
