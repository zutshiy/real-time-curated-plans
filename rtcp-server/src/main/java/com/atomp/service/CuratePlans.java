package com.atomp.service;

import com.atomp.creators.*;
import com.atomp.models.PlansItem;
import com.atomp.models.request.RealtimeCuratedPlansRequest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CuratePlans
{
	PlanCreator planCreator;
	List<PlansItem> allPlans;

	public CuratePlans()
	{
		buildPlans();
		allPlans= new LinkedList<>();
	}

	private void buildPlans()
	{
		planCreator = new SMSPlanCreator(new CallingPlanCreator(new InternetPlanCreator(null)));
	}

	public List<PlansItem> curate(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest)
	{
		planCreator.create(realtimeCuratedPlansRequest,allPlans);
		return allPlans;


//		double monthlyBandwidth=allPlans.get(0).getInternetBandwidth();
		/*if (monthlyBandwidth < 21)
		{
			Optional<Pricing> pricingForBandwidthForMonth = allPricing.stream().filter(a -> a.getBandwidthPeriod() == 28)
					.sorted(Comparator.comparing(Pricing::getBandwidth)).filter(cb -> cb.getBandwidth() > monthlyBandwidth).findFirst();
			if (pricingForBandwidthForMonth.isPresent())
			{
				Plan monthlyPlan = BasePlanHelper.createPlan(monthlyBandwidth, pricingForBandwidthForMonth.get(), 28);
				allPlans.add(monthlyPlan);
			}
		}
		double yearlyBandwidth = monthlyBandwidth + (monthlyBandwidth * 0.4);
		if (yearlyBandwidth < 31)
		{
			Optional<Pricing> pricingForBandwidthForYear = allPricing.stream().filter(a -> a.getBandwidthPeriod() == 365)
					.sorted(Comparator.comparing(Pricing::getBandwidth)).filter(cb -> cb.getBandwidth() > yearlyBandwidth).findFirst();
			if (pricingForBandwidthForYear.isPresent())
			{
				Plan yearlyPlan = BasePlanHelper.createPlan(yearlyBandwidth, pricingForBandwidthForYear.get(), 365);
				allPlans.add(yearlyPlan);
			}
		}*/
	}
}
