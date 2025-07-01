package com.core.api_management.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.core.api_management.model.Api;
import com.core.api_management.service.Api_Service;

@RestController
public class Api_Manag_Controller {

	@Autowired
	private Api_Service apiService;
	
	/**
	 * Create - Add a new api
	 * @param api An object api
	 * @return The api object saved
	 */
	@PostMapping("/api")
	public Api createApi(@RequestBody Api api) {
		return apiService.saveApi(api);
	}
	
	
	/**
	 * Read - Get one api 
	 * @param id The id of the api
	 * @return An api object full filled
	 */
	@GetMapping("/api/{id}")
	public Api getApi(@PathVariable("id") final Long id) {
		Optional<Api> api = apiService.getApi(id);
		if(api.isPresent()) {
			return api.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Read - Get all api
	 * @return - An Iterable object of api full filled
	 */
	@GetMapping("/apis")
	public Iterable<Api> getApi() {
		return apiService.getApi();
	}
	
	/**
	 * Update - Update an existing api
	 * @param id - The id of the api to update
	 * @param api - The api object updated
	 * @return
	 */
	@PutMapping("/api/{id}")
	public Api updateApi(@PathVariable("id") final Long id, @RequestBody Api api) {
		Optional<Api> e = apiService.getApi(id);
		if(e.isPresent()) {
			Api currentApi = e.get();
			
			String nom_api = api.getNom_api();
			if(nom_api != null) {
				currentApi.setNom_api(nom_api);
			}
			String description_api = api.getDescription_api();
			if(description_api != null) {
				currentApi.setDescription_api(description_api);
			}
			String lien_api = api.getLien_api();
			if(lien_api != null) {
				currentApi.setLien_api(lien_api);
			}
			apiService.saveApi(currentApi);
			return currentApi;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete an employee
	 * @param id - The id of the employee to delete
	 */
	@DeleteMapping("/api/{id}")
	public void deleteApi(@PathVariable("id") final Long id) {
		apiService.deleteApi(id);
	}	

}
