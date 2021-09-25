package com.atomp.controllers;

import com.atomp.models.RealtimeCuratedPlansRequest;
import com.atomp.models.RealtimeCuratedPlansResponse;
import com.atomp.service.CurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurationController
{
	
	@Autowired
	private CurationService curationService;
	

	@PostMapping("/curate-plan")
	public RealtimeCuratedPlansResponse getCuratedPlans(@RequestBody RealtimeCuratedPlansRequest realtimeCuratedPlansRequest)
	{
		RealtimeCuratedPlansResponse realtimeCuratedPlansResponse = curationService.execute(realtimeCuratedPlansRequest);

		return realtimeCuratedPlansResponse;
	}

}
