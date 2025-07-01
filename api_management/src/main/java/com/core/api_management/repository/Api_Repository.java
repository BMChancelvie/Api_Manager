package com.core.api_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.api_management.model.Api;


@Repository
public interface Api_Repository extends CrudRepository<Api, Long>{

}
