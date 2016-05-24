package com.tenoch.warrantysafe.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tenoch.warrantysafe.core.repositories.entities.Warranty;

public interface IWarrantyRepository extends MongoRepository<Warranty, String>{

}
