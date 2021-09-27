package com.atomp.service;

import com.atomp.models.PlansItem;
import com.atomp.models.request.PricingItem;

import java.text.DecimalFormat;

public class BasePlanHelper
{
	public static PlansItem createPlan(double finalBandwidth, PricingItem pricing)
	{
		double unit = (double) pricing.getRate() / pricing.getBandwidth();
		double finalRate = finalBandwidth * unit;
		return PlansItem.builder().internetBandwidth(finalBandwidth).price(finalRate).period(28).build();
	}
}
