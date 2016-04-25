package com.mycompany.model;

public class ContextSort {
	
	private Sort sort;
	
	public ContextSort(Sort sort) {
		super();
		this.sort = sort;
	}

	public java.util.List<Doctor> executeSort(String loc, String spl)
	{
		return sort.sort(loc, spl);
	}

}
