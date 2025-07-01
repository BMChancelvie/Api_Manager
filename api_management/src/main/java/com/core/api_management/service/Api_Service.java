package com.core.api_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.core.api_management.model.Api;
import com.core.api_management.repository.Api_Repository;

import lombok.Data;

@Data
@Service
public class Api_Service {

	@Autowired
	private Api_Repository apiRepository;
	
	public Optional<Api> getApi(final Long id) {
		return apiRepository.findById(id);
	}
	
	public Iterable<Api> getApi() {
		return apiRepository.findAll();
	}
	
	public void deleteApi(final Long id) {
		apiRepository.deleteById(id);
	}
	
	public Api saveApi(Api api) {
		Api savedApi = apiRepository.save(api);
		return savedApi;
	}

}
