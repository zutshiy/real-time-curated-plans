package com.atomp.service;

import com.atomp.models.RealtimeCuratedPlansRequest;
import com.atomp.models.RealtimeCuratedPlansResponse;
import org.springframework.stereotype.Service;

@Service
public class CurationService
{

	public RealtimeCuratedPlansResponse execute(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest)
	{
		return new RealtimeCuratedPlansResponse();
	}

}
