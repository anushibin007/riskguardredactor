package com.rg.riskguardredactor.service.db;

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
		DocumentState state = new DocumentState();
		state.setId(id);
		state.setRedactedDocUrl(redactedDocUrl);
		repo.save(state);
		return state;
	}

	public DocumentState setCoreCaptureStatus(String id, ProcessStatusModel coreCaptureStatus) {
		DocumentState state = new DocumentState();
		state.setId(id);
		state.setCoreCaptureStatus(coreCaptureStatus);
		repo.save(state);
		return state;
	}
}
