package com.java.hrs.bll;

import com.java.hrs.dbl.DbSizeRange;

public class SizeRange {
	String[] sizeRage;
	String[] sizes;
	DbSizeRange dbSizeRange = new DbSizeRange();
	int min = dbSizeRange.getMin();
	int max = dbSizeRange.getMax();
	int size = max-min;
	public SizeRange() {
		// TODO Auto-generated constructor stub
		sizes = new String[size+1];
		for(int i=0;i<=size;i++) {
			sizes[i] = String.valueOf(min);
			min = min+1;
			//System.out.println(sizes[i] + " max:"+max);
		}
		
		sizeRage = new String[size];
		for(int i=0; i<size;i++) {
			sizeRage[i] = sizes[i]+"-"+sizes[i+1];
			//System.out.println(sizeRage[i]);
		}
	}
	
	public String[] getSizeRage() {
		return sizeRage;
	}
}
