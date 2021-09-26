package com.atomp.creators;

import com.atomp.models.request.DomesticPricingItem;
import com.atomp.models.request.InternationalPricingItem;
import com.atomp.models.PlansItem;
import com.atomp.models.request.RealtimeCuratedPlansRequest;
import com.atomp.service.Constants;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SMSPlanCreator extends PlanCreator
{
	public SMSPlanCreator(PlanCreator planCreator)
	{
		super(planCreator);
	}

	@Override
	public void create(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest, List<PlansItem> allPlans)
	{
		super.create(realtimeCuratedPlansRequest,allPlans);

		int domesticRating = realtimeCuratedPlansRequest.getPreferences().getOtherPreferences().getRatings().getSmsRatings().getDomesticRating();
		int internationalSMSRating = realtimeCuratedPlansRequest.getPreferences().getOtherPreferences().getRatings().getSmsRatings().getInternationalRating();
		double domesticSMSBandwidth = domesticRating * Constants.DOMESTIC_SMS_FACTOR * 60;
		double internationalSMSBandwidth = internationalSMSRating * Constants.INTERNATIONAL_SMS_FACTOR * 60;

		Optional<DomesticPricingItem> domesticPricingForBandwidth = Optional.empty();
		if (domesticRating > 0.0)
		{
			List<DomesticPricingItem> allDomesticPricing = realtimeCuratedPlansRequest.getPreferences().getOtherPreferences().getPricing().getSmsPricing()
					.getDomesticPricing();

			domesticPricingForBandwidth = allDomesticPricing.stream().sorted(Comparator.comparing(DomesticPricingItem::getBandwidth))
					.filter(cb -> cb.getBandwidth() > domesticSMSBandwidth).findFirst();
		}
		Optional<InternationalPricingItem> internationalPricingForBandwidth = Optional.empty();
		if (internationalSMSRating > 0.0)
		{
			List<InternationalPricingItem> allInternationalPricing = realtimeCuratedPlansRequest.getPreferences().getOtherPreferences().getPricing()
					.getSmsPricing().getInternationalPricing();

			internationalPricingForBandwidth = allInternationalPricing.stream()
					.sorted(Comparator.comparing(InternationalPricingItem::getBandwidth)).filter(cb -> cb.getBandwidth() > internationalSMSBandwidth).findFirst();
		}
		for (PlansItem plansItem : allPlans)
		{
			if (plansItem.getInternetBandwidth() < 1)
			{
				double rate = 0.0;
				if (domesticPricingForBandwidth.isPresent())
				{
					rate += plansItem.getPrice() + domesticPricingForBandwidth.get().getRate();
					plansItem.setDomesticSMSBandwidth(domesticPricingForBandwidth.get().getBandwidth());
				}
				if (internationalPricingForBandwidth.isPresent())
				{
					rate += plansItem.getPrice() + internationalPricingForBandwidth.get().getRate();
					plansItem.setInternationalSMSBandwidth(internationalPricingForBandwidth.get().getBandwidth());
				}
				plansItem.setPrice(rate);
			}
		}
	}
}
