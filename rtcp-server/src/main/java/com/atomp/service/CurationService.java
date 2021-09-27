package com.atomp.service;

import com.atomp.models.*;
import com.atomp.models.request.RealtimeCuratedPlansRequest;
import com.atomp.models.response.Plans;
import com.atomp.models.response.RealtimeCuratedPlansResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurationService
{
	public RealtimeCuratedPlansResponse execute(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest)
	{
		CuratePlans curatePlans = new CuratePlans();
		List<PlansItem> allPlansItems = curatePlans.curate(realtimeCuratedPlansRequest);

		List<Plans> allPlans = allPlansItems.stream()
				.map(plansItem -> Plans.builder().period(plansItem.getPeriod() + " Days").domesticCallingBandwidth(getDomesticCallingBandwidth(plansItem))
						.internationalCallingBandwidth(getInternationalCallingBandwidth(plansItem)).domesticSMSBandwidth(getDomesticSMSBandwidth(plansItem))
						.internationalSMSBandwidth(getInternationalSMSBandwidth(plansItem)).internetBandwidth(plansItem.getInternetBandwidth() + " GB / Day")
						.price(getPrice(allPlansItems, plansItem)).build()).collect(Collectors.toList());

		return RealtimeCuratedPlansResponse.builder().plans(allPlans).build();
	}

	private String getPrice(List<PlansItem> allPlansItems, PlansItem plansItem)
	{
		return "₹ " + Math.round(plansItem.getPrice()) + (allPlansItems.indexOf(plansItem) == 0 ? " (Recommended)" : "");
	}

	private String getDomesticSMSBandwidth(PlansItem plansItem)
	{
		return plansItem.getDomesticSMSBandwidth() == -1 ? "Unlimited SMS" : plansItem.getDomesticSMSBandwidth() + " SMS / Day";
	}

	private String getInternationalSMSBandwidth(PlansItem plansItem)
	{
		return plansItem.getInternationalSMSBandwidth() == 0 ? null : plansItem.getInternationalSMSBandwidth() + " Intl. SMS / Day";
	}

	private String getDomesticCallingBandwidth(PlansItem plansItem)
	{
		return plansItem.getDomesticCallingBandwidth() == -1 ? " Unlimited STD Calls" : plansItem.getDomesticCallingBandwidth() + " min / Day";
	}

	private String getInternationalCallingBandwidth(PlansItem plansItem)
	{
		return plansItem.getInternationalCallingBandwidth() == 0.0 ? null : plansItem.getInternationalCallingBandwidth() + " Intl. min / Day";
	}
}
