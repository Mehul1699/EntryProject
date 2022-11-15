package com.masai.service;

import java.util.List;

import com.masai.beans.Entry;
import com.masai.exceptions.EntryException;

public interface EntryService {
	
	public List<String> getTitleDescription(String category) throws EntryException; 
	
	public Entry saveEntry(Entry entry);
	
}
