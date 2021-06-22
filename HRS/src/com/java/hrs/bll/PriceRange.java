package com.java.hrs.bll;

import java.util.Iterator;

import com.java.hrs.dbl.DbPriceRange;

public class PriceRange {
		String[] prices;
		String[] priceRange;
		DbPriceRange dbPriceRange = new DbPriceRange();
		int size;
		int standardDiv = 5000;
		public PriceRange() {
			size = maxPriceRange()/5000;
			//System.out.println(size);
			prices = new String[size];
			for(int i=0;i<size;i++) {
				prices[i] = String.valueOf(standardDiv*(i+1));
				//System.out.println(prices[i]);
			}
			
			priceRange = new String[size-1];
			for(int i=0; i<size-1; i++) {
				priceRange[i] = prices[i]+"-"+prices[i+1];
				//System.out.println(priceRange[i]);
			}
		}
		
		private int maxPriceRange() {
			String strPrice;
			char ch1;
			int index1;
			int price;
			price  = dbPriceRange.getMax();
			strPrice = String.valueOf(price);
			ch1 = strPrice.charAt(0);
			index1 = Integer.parseInt(String.valueOf(ch1));
			strPrice = strPrice.substring(0,0)+(index1+1)+strPrice.substring(0+1);
			strPrice = strPrice.substring(0,1)+"0"+strPrice.substring(1+1);
			return Integer.parseInt(strPrice);
		}
		
		public String[] getPriceRange() {
			return priceRange;
		}
	}