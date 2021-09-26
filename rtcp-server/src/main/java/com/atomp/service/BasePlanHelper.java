package com.atomp.service;

import com.atomp.models.PlansItem;
import com.atomp.models.request.PricingItem;

import java.text.DecimalFormat;

public class BasePlanHelper
{
	public static PlansItem createPlan(double finalBandwidth, PricingItem pricing, String mostRecommended)
	{
		double unit = (double) pricing.getRate() / pricing.getBandwidth();
		double finalRate = (double) (finalBandwidth * unit);
		DecimalFormat df = new DecimalFormat("#.#");
		String price = "Rs. " + finalRate + " " + mostRecommended;
		return PlansItem.builder().internetBandwidth(finalBandwidth).price(finalRate).period(28).build();
	}


	private PlansItem createPlan(double finalBandwidth, PricingItem pricing, int period)
	{
		long finalRate = pricing.getRate();
		DecimalFormat df = new DecimalFormat("#.#");
		return PlansItem.builder().internetBandwidth(pricing.getBandwidth()).price(finalRate).period(period).build();
//		return PlansItem.builder().internetBandwidth(df.format(pricing.getBandwidth()) + " GB").price("Rs. " + finalRate).period(period + " Days")
//				.callingBandwidth("Unlimited STD Calls").smsBandwidth("500 SMS").build();
	}

}
