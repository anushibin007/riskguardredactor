package com.rg.riskguardredactor.db.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rg.riskguardredactor.db.model.DocumentState;

@Repository
public interface DocumentStateRepo extends MongoRepository<DocumentState, String> {

}
