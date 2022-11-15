package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.beans.Entry;
import com.masai.exceptions.EntryException;
import com.masai.repo.EntryRepo;

@Service
public class EntryServiceImpl implements EntryService{

	@Autowired
	private EntryRepo entryRepo;
	
	@Override
	public List<String> getTitleDescription(String category) throws EntryException{
		List<Integer> list = entryRepo.getIdByCategory(category);
		List<String> ans = new ArrayList<>();
		if(list.size()!=0) {
			for(Integer i:list) {
				Optional<Entry> o = entryRepo.findById(i);
				ans.add("title "+o.get().getTitle()+" description "+o.get().getDescription());
			}
		}else {
			throw new EntryException("No entry found");
		}
		return ans;
	}

	@Override
	public Entry saveEntry(Entry entry) {
		return entryRepo.save(entry);
	}

}
