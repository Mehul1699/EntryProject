package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.beans.Entry;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Integer>{

	@Query("select entryid from entry where category like 'category%' OR category in '%category%' OR category in '%category'")
	public List<Integer> getIdByCategory(String category);
	
}
