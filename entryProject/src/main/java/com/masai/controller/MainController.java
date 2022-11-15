package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.beans.Entry;
import com.masai.service.EntryService;

@RestController
public class MainController {

	@Autowired
	private EntryService entryService;
	
	@PostMapping("/entry")
	public ResponseEntity<Entry> saveEntry(@RequestBody Entry e){
		Entry entry = entryService.saveEntry(e);
		
		return new ResponseEntity<Entry>(entry, HttpStatus.CREATED);
	}
	
	@GetMapping("/entry/{category}")
	public ResponseEntity<List<String>> getTitleDescription(@PathVariable("category") String category){
		
		List<String> list = entryService.getTitleDescription(category);
		
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		
	}
	
}
