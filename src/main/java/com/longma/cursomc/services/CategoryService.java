package com.longma.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longma.cursomc.domain.Category;
import com.longma.cursomc.repositories.CategoryRepository;
import com.longma.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category search(Integer id) {
		Category obj = repo.findById(id).orElse(null);
		if(obj == null) {
			throw new ObjectNotFoundException("Object not found with Id " + id);
		}
		return obj;
	}
}
