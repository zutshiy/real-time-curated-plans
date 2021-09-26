package com.atomp.service;

import com.atomp.models.*;
import com.atomp.models.request.RealtimeCuratedPlansRequest;
import com.atomp.models.response.Plans;
import com.atomp.models.response.RealtimeCuratedPlansResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service public class CurationService
{
	public RealtimeCuratedPlansResponse execute(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest)
	{
		CuratePlans curatePlans = new CuratePlans();
		List<PlansItem> allPlansItems = curatePlans.curate(realtimeCuratedPlansRequest);
		List<Plans> allPlans = allPlansItems.stream().map(plansItem -> {
			return Plans.builder().period(plansItem.getPeriod() + " Days").
							domesticCallingBandwidth(plansItem.getDomesticCallingBandwidth()==-1?" Unlimited mins/Day": plansItem.getDomesticCallingBandwidth()+ " mins/Day")
					.internationalCallingBandwidth(plansItem.getInternationalCallingBandwidth()==0.0?"Not Available ":+plansItem.getInternationalCallingBandwidth()+ " mins/Day").
							domesticSMSBandwidth(plansItem.getDomesticSMSBandwidth()+" /Day").
							internationalSMSBandwidth(plansItem.getInternationalSMSBandwidth()+" /Day").
							internetBandwidth(plansItem.getInternetBandwidth()+" GB/Day").price("₹ "+plansItem.getPrice()).build();
		}).collect(Collectors.toList());
		return RealtimeCuratedPlansResponse.builder().plans(allPlans).build();
	}



}
