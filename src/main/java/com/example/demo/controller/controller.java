package com.example.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.service.service;


@RestController
@RequestMapping("/items")
public class controller {

	@Autowired
	service is;
	
	@RequestMapping("/all")
	public Hashtable<Integer, ArrayList<Item>> getAll(){
		return is.getAll();
	}
	@RequestMapping("{tag}")
	public Item getItem(@PathVariable("tag") Integer tag) {
		return is.getItem(tag);
	}

}
