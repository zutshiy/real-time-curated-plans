package com.atomp.controllers;

import com.atomp.models.request.RealtimeCuratedPlansRequest;
import com.atomp.models.response.RealtimeCuratedPlansResponse;
import com.atomp.service.CurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:3000")
@RestController
public class CurationController
{
	@Autowired
	private CurationService curationService;

	@RequestMapping(method = RequestMethod.POST, value = "/curate-plan", consumes = "application/json", produces = "application/json")
	public ResponseEntity<RealtimeCuratedPlansResponse> getCuratedPlans(@RequestBody RealtimeCuratedPlansRequest realtimeCuratedPlansRequest)
	{
		RealtimeCuratedPlansResponse realtimeCuratedPlansResponse = curationService.execute(realtimeCuratedPlansRequest);
		return ResponseEntity.ok(realtimeCuratedPlansResponse);
	}
}
