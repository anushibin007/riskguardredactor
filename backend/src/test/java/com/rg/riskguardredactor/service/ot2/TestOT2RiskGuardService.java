package com.rg.riskguardredactor.service.ot2;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ot2.riskguard.invoker.JSON;
import com.ot2.riskguard.model.ContentResponse;

@SpringBootTest
public class TestOT2RiskGuardService {

	@Autowired
	OT2RiskGuardService riskGuardService;

	String contentResponseForProcess = "{\"header\":{\"documentId\":\"\",\"status\":{\"message\":\"SUCCESS\",\"description\":\"Processing succeeded.\"}},\"results\":{\"tme\":{\"status\":{\"message\":\"SUCCESS\",\"description\":\"Processing succeeded with warnings.\"},\"result\":{\"Version\":\"3.0\",\"ID\":\"minesweeper_en\",\"ErrorID\":{\"Type\":\"Status\",\"value\":0.0},\"ErrorDescription\":\"Success\",\"Warnings\":{\"Warning\":[\"No relevant rules are loaded for pre-processing\",\"Skipped rule - SSN No match found\",\"Skipped rule - CreditCard No match found\",\"Skipped rule - BankAccount No match found\",\"Skipped rule - DriversLicence No match found\",\"Skipped rule - Username No match found\",\"Skipped rule - Password No match found\"]},\"Results\":{\"ncategorizer\":[{\"KnowledgeBase\":[{\"KBid\":\"PersonalInformation\",\"Categories\":{\"Category\":[{\"Name\":[\"NO CATEGORIES\"]}]},\"RejectedCategories\":{\"RejectedCategory\":[{\"Name\":[\"NO REJECTED CATEGORIES\"]}]}},{\"KBid\":\"Hatred\",\"Categories\":{\"Category\":[{\"Name\":[\"NO CATEGORIES\"]}]},\"RejectedCategories\":{\"RejectedCategory\":[{\"Name\":[\"NO REJECTED CATEGORIES\"]}]}}]}],\"nfinder\":[{\"nfExtract\":[{\"ExtractedTerm\":[{\"CartridgeID\":\"Phone\",\"ConfidenceScore\":68.5714,\"RelevancyScore\":71.6735,\"Frequency\":1.0,\"nfinderNormalized\":\"877-485-5336\",\"ClientNormalized\":\"\",\"Subterms\":{\"Subterm\":[{\"Position\":45.0,\"Length\":12.0,\"Candidate\":1.0,\"value\":\"877-485-5336\"}]},\"DynamicAttributes\":{},\"Hierarchy\":{\"Base\":{\"Attributes\":{}}}},{\"CartridgeID\":\"Address\",\"ConfidenceScore\":70.7143,\"RelevancyScore\":72.3618,\"Frequency\":1.0,\"nfinderNormalized\":\"5895 Shiloh Rd\",\"ClientNormalized\":\"\",\"Subterms\":{\"Subterm\":[{\"Position\":1.0,\"Length\":14.0,\"Candidate\":1.0,\"value\":\"5895 Shiloh Rd\"}]},\"DynamicAttributes\":{},\"Hierarchy\":{\"Base\":{\"Attributes\":{}}}},{\"CartridgeID\":\"PN\",\"ConfidenceScore\":77.7943,\"RelevancyScore\":65.8561,\"Frequency\":2.0,\"nfinderNormalized\":\"Diane Farhi\",\"ClientNormalized\":\"\",\"Subterms\":{\"Subterm\":[{\"Position\":1177.0,\"Length\":11.0,\"Candidate\":1.0,\"value\":\"Diane Farhi\"},{\"Position\":1378.0,\"Length\":11.0,\"Candidate\":1.0,\"value\":\"Diane Farhi\"}]},\"DynamicAttributes\":{},\"Hierarchy\":{\"Base\":{\"Attributes\":{}}}},{\"CartridgeID\":\"ON\",\"ConfidenceScore\":85.2996,\"RelevancyScore\":55.4632,\"Frequency\":1.0,\"ClientNormalized\":\"\",\"MainTerm\":{\"value\":\"Diagnostic Solutions Inc. Laboratory\"},\"Subterms\":{\"Subterm\":[{\"Position\":1307.0,\"Length\":31.0,\"Candidate\":1.0,\"value\":\"Diagnostic Solutions Laboratory\"}]},\"DynamicAttributes\":{},\"Hierarchy\":{\"Base\":{\"Attributes\":{}}}},{\"CartridgeID\":\"PN\",\"ConfidenceScore\":89.8528,\"RelevancyScore\":57.1037,\"Frequency\":1.0,\"ClientNormalized\":\"\",\"Id\":\"B5160E34-BBF8-432C-B44A-74F0F4FEDBD8\",\"MainTerm\":{\"language\":\"UN\",\"value\":\"Jane Doe\"},\"Subterms\":{\"Subterm\":[{\"Id\":\"B5160E34-BBF8-432C-B44A-74F0F4FEDBD8\",\"Position\":1204.0,\"Length\":8.0,\"Candidate\":0.0,\"value\":\"Jane Doe\"}]},\"DynamicAttributes\":{},\"Hierarchy\":{\"Base\":{\"Attributes\":{}}}}]}]}]}}},\"ia\":{\"status\":{\"message\":\"SKIPPED\",\"description\":\"Processing was skipped by \\u0027IA\\u0027 based on a component activation rule.\"}}}}";

	@BeforeAll
	public static void init() {
		// Run this so that the static block in the JSON class gets called and required
		// stuff get initialized there.
		JSON json = new JSON();
	}

	@Test
	public void testProcessAndGetResults() throws IOException {
		ContentResponse processResults = new ContentResponse().fromJson(contentResponseForProcess);
		List<String> processAndGetResults = riskGuardService.processAndGetResults(processResults);
		List<String> expectedResults = Arrays.asList(new String[] { "877-485-5336", "5895 Shiloh Rd", "Diane Farhi",
				"Diagnostic Solutions Laboratory", "Jane Doe" });
		assertIterableEquals(expectedResults, processAndGetResults);
	}
}
