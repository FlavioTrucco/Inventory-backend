package com.company.inventory.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	@Autowired
	private ICategoryService service;
	
	/**
	 * get all the categories
	 * @return
	 */
	
	@GetMapping("/categories")
	public ResponseEntity <CategoryResponseRest> searchcategories(){
		
		ResponseEntity <CategoryResponseRest> response = service.search();
		return response;
		}
	
	/**
	 * get categories by id
	 * @param id
	 * @return
	 */
	
	@GetMapping("/categories/{id}")
	public ResponseEntity <CategoryResponseRest> searhCategoriesById(@PathVariable Long id){
		
		ResponseEntity <CategoryResponseRest> response = service.searchById(id);
		return response;
		}
	
	/**
	 * save categories 
	 * @param Category
	 * @return
	 */
	
	@PostMapping("/categories")
	public ResponseEntity <CategoryResponseRest> save(@RequestBody Category category){
		
		ResponseEntity <CategoryResponseRest> response = service.save(category);
		return response;
		}
	/**
	 * update categorias
	 * @param category
	 * @param id
	 * @return
	 */
	@PutMapping("/categories/{id}")
	public ResponseEntity <CategoryResponseRest> update(@RequestBody Category category, @PathVariable long id){
		
		ResponseEntity <CategoryResponseRest> response = service.update(category, id);
		return response;
		}
	
	/**
	 * delete category
	 * @param id
	 * @return
	 */
	@DeleteMapping("/categories/{id}")
	public ResponseEntity <CategoryResponseRest> delete( @PathVariable long id){
		
		ResponseEntity <CategoryResponseRest> response = service.deleteById( id);
		return response;
		}
}
