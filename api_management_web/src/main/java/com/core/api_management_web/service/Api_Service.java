package com.core.api_management_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.api_management_web.model.Api;
import com.core.api_management_web.repository.ApiProxy;

import lombok.Data;

@Data
@Service

public class Api_Service {

	@Autowired
	private ApiProxy apiProxy;
	
	public Api getApi(final int id) {
		return apiProxy.getApi(id);
	}
	
	public Iterable<Api> getApi() {
		return apiProxy.getApi();
	}
	
	public void deleteApi(final int id) {
		apiProxy.deleteApi(id);
	}
	
	public Api saveApi(Api api) {
		
		Api savedApi;
		
		// Functional rule : name api must be capitalized
		api.setNom_api(api.getNom_api().toUpperCase());

		if(api.getId() == null) {
			// If id is null, then it is a new api.
			savedApi = apiProxy.createApi(api);
		} else {
			savedApi = apiProxy.updateApi(api);
		}
		
		return savedApi;
	}

}
