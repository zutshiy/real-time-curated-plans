package com.atomp.creators;

import com.atomp.models.*;
import com.atomp.models.request.DomesticPricingItem;
import com.atomp.models.request.InternationalPricingItem;
import com.atomp.models.request.RealtimeCuratedPlansRequest;
import com.atomp.service.Constants;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CallingPlanCreator extends PlanCreator
{
	public CallingPlanCreator(PlanCreator planCreator)
	{
		super(planCreator);
	}

	@Override
	public void create(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest, List<PlansItem> allPlans)
	{
		super.create(realtimeCuratedPlansRequest, allPlans);
		int domesticRating = realtimeCuratedPlansRequest.getPreferences().getOtherPreferences().getRatings().getCallRatings().getDomesticRating();
		int internationalCallRating = realtimeCuratedPlansRequest.getPreferences().getOtherPreferences().getRatings().getCallRatings().getInternationalRating();
		double domesticCallBandwidth = domesticRating * Constants.DOMESTIC_CALL_FACTOR * 60;
		double internationalCallBandwidth = internationalCallRating * Constants.INTERNATIONAL_CALL_FACTOR * 60;

		Optional<DomesticPricingItem> domesticPricingForBandwidth = Optional.empty();
		if (domesticCallBandwidth > 0.0)
		{
			List<DomesticPricingItem> allDomesticPricing = realtimeCuratedPlansRequest.getPreferences().getOtherPreferences().getPricing().getCallPricing()
					.getDomesticPricing();

			domesticPricingForBandwidth = allDomesticPricing.stream().sorted(Comparator.comparing(DomesticPricingItem::getBandwidth))
					.filter(cb -> cb.getBandwidth() >= domesticCallBandwidth).findFirst();
		}

		Optional<InternationalPricingItem> internationalPricingForBandwidth = Optional.empty();
		if (internationalCallBandwidth > 0.0)
		{
			List<InternationalPricingItem> allInternationalPricing = realtimeCuratedPlansRequest.getPreferences().getOtherPreferences().getPricing()
					.getCallPricing().getInternationalPricing();
			internationalPricingForBandwidth = allInternationalPricing.stream().sorted(Comparator.comparing(InternationalPricingItem::getBandwidth))
					.filter(cb -> cb.getBandwidth() >= internationalCallBandwidth).findFirst();
		}

		for (PlansItem plansItem : allPlans)
		{
			double rate = plansItem.getPrice();
			if (plansItem.getInternetBandwidth() < 1)
			{
				if (domesticPricingForBandwidth.isPresent())
				{
					rate += (domesticPricingForBandwidth.get().getRate() / domesticPricingForBandwidth.get().getBandwidth()) * domesticCallBandwidth;
					plansItem.setDomesticCallingBandwidth(domesticPricingForBandwidth.get().getBandwidth());
				}
				if (internationalPricingForBandwidth.isPresent())
				{
					rate += (internationalPricingForBandwidth.get().getRate() / internationalPricingForBandwidth.get().getBandwidth())
							* internationalCallBandwidth;
					plansItem.setInternationalCallingBandwidth(internationalPricingForBandwidth.get().getBandwidth());
				}
			}
			else
			{
				plansItem.setDomesticCallingBandwidth(-1);

				List<DomesticPricingItem> allDomesticPricing = realtimeCuratedPlansRequest.getPreferences().getOtherPreferences().getPricing().getCallPricing()
						.getDomesticPricing();

				Optional<DomesticPricingItem> unlimitedPriceOptional = allDomesticPricing.stream().filter(pricing -> pricing.getBandwidth() == -1).findFirst();
				if (unlimitedPriceOptional.isPresent())
				{
					rate += unlimitedPriceOptional.get().getRate();
				}

				if (internationalPricingForBandwidth.isPresent())
				{
					rate += internationalPricingForBandwidth.get().getRate();
					plansItem.setInternationalCallingBandwidth(internationalPricingForBandwidth.get().getBandwidth());
				}
			}
			plansItem.setPrice(rate);
		}
	}
}
