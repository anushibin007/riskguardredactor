package com.rg.riskguardredactor.service.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rg.riskguardredactor.db.model.DocumentState;
import com.rg.riskguardredactor.db.model.ProcessStatusModel;
import com.rg.riskguardredactor.db.repo.DocumentStateRepo;

@Service
public class DocumentStateService {

	@Autowired
	DocumentStateRepo repo;

	public DocumentState setRedactedUrl(String id, String redactedDocUrl) {
		DocumentState state = getDocumentState(id);
		state.setRedactedDocUrl(redactedDocUrl);
		repo.save(state);
		return state;
	}

	public DocumentState setCoreCaptureStatus(String id, ProcessStatusModel coreCaptureStatus) {
		DocumentState state = getDocumentState(id);
		state.setCoreCaptureStatus(coreCaptureStatus);
		repo.save(state);
		return state;
	}

	private DocumentState getDocumentState(String id) {
		// Find current item in the DB
		Optional<DocumentState> findById = repo.findById(id);

		// If we found something, simply return it
		if (findById.isPresent()) {
			return findById.get();
		}

		// If we didn't, create a new one and return it
		DocumentState state = new DocumentState();
		state.setId(id);
		return state;
	}
}
