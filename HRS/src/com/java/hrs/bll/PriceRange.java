package com.java.hrs.bll;

import com.java.hrs.dbl.DbPriceRange;

public class PriceRange {
		
		public PriceRange() {
			System.out.println(new DbPriceRange().getMax());
		}
	}