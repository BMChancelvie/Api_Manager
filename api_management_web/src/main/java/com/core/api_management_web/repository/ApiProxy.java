package com.core.api_management_web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.core.api_management_web.CustomProperties;
import com.core.api_management_web.model.Api;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Component
public class ApiProxy {

	@Autowired
	private CustomProperties props;

	/**
	 * Get all apis
	 * @return An iterable of all apis
	 */
	public Iterable<Api> getApi() {

		String baseApiUrl = props.getApiUrl();
		String getApiUrl = baseApiUrl + "/apis";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Api>> response = restTemplate.exchange(
				getApiUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Api>>() {}
			);
		
		log.debug("Liste des Apis " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Get an api by the id
	 * @param id The id of the api
	 * @return The api which matches the id
	 */
	public Api getApi(int id) {
		String baseApiUrl = props.getApiUrl();
		String getApiUrl = baseApiUrl + "/api/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Api> response = restTemplate.exchange(
				getApiUrl, 
				HttpMethod.GET, 
				null,
				Api.class
			);
		
		log.debug("Liste des apis " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Add a new employee api
	 * @param e A new api (without an id)
	 * @return The api full filled (with an id)
	 */
	public Api createApi(Api e) {
		String baseApiUrl = props.getApiUrl();
		String createApiUrl = baseApiUrl + "/api";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Api> request = new HttpEntity<Api>(e);
		ResponseEntity<Api> response = restTemplate.exchange(
				createApiUrl, 
				HttpMethod.POST, 
				request, 
				Api.class);
		
		log.debug("Créer une api " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Update an api - using the PUT HTTP Method.
	 * @param e Existing api to update
	 */
	public Api updateApi(Api e) {
		String baseApiUrl = props.getApiUrl();
		String updateApiUrl = baseApiUrl + "/api/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Api> request = new HttpEntity<Api>(e);
		ResponseEntity<Api> response = restTemplate.exchange(
				updateApiUrl, 
				HttpMethod.PUT, 
				request, 
				Api.class);
		
		log.debug("Mettre à jour l'Api " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Delete an api using exchange method of RestTemplate
	 * instead of delete method in order to log the response status code.
	 * @param e The api to delete
	 */
	public void deleteApi(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteApiUrl = baseApiUrl + "/api/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteApiUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Supprimer l'Api " + response.getStatusCode().toString());
	}

}
