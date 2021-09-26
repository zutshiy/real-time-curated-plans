package com.atomp.creators;

import com.atomp.models.*;
import com.atomp.models.request.PricingItem;
import com.atomp.models.request.RealtimeCuratedPlansRequest;
import com.atomp.service.BasePlanHelper;
import com.atomp.service.Constants;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class InternetPlanCreator extends PlanCreator
{
	public InternetPlanCreator(PlanCreator planCreator)
	{
		super(planCreator);
	}

	@Override
	public void create(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest, List<PlansItem> allPlans)
	{
		super.create(realtimeCuratedPlansRequest,allPlans);
		double totalBandwidth = getTotalBandwidthForInternet(realtimeCuratedPlansRequest);
		double calculatedBandwidth = Math.ceil(Math.round(totalBandwidth * 100.0) / 10.0) / 10.0;
		double finalBandwidth=calculatedBandwidth==0.0?0.1:calculatedBandwidth;
		List<PricingItem> allPricing = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getPricing();

		Optional<PricingItem> pricingForBandwidth = allPricing.stream().sorted(Comparator.comparing(PricingItem::getBandwidth))
				.filter(cb -> cb.getBandwidth() > finalBandwidth).findFirst();
		if (pricingForBandwidth.isPresent())
		{
			double upperLimitBeforeFloor = finalBandwidth + 0.5;
			double upperLimit = 0;
			if (upperLimitBeforeFloor % 0.5 == 0)
			{
				upperLimit = upperLimitBeforeFloor;
			}
			else
			{
				upperLimit = (upperLimitBeforeFloor - (upperLimitBeforeFloor % 0.5)) + 0.5;
			}
			double lowerLimitBeforeFloor = finalBandwidth > 0.5 ? finalBandwidth - 0.5 : 0;

			double lowerLimit = (lowerLimitBeforeFloor - (lowerLimitBeforeFloor % 0.5)) * 10.0 / 10.0;

			PlansItem perfectPlan = BasePlanHelper.createPlan(finalBandwidth, pricingForBandwidth.get(),"(Most Recommended)");
			allPlans.add(perfectPlan);
			if (lowerLimit != 0)
			{
				PlansItem lowerLimitPlan = BasePlanHelper.createPlan(lowerLimit, pricingForBandwidth.get(),"");
				allPlans.add(lowerLimitPlan);
			}

			PlansItem uperLimitPlan =  BasePlanHelper.createPlan(upperLimit, pricingForBandwidth.get(),"");
			allPlans.add(uperLimitPlan);
		}
	}

	private double getTotalBandwidthForInternet(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest)
	{
		int videoStreamingRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getVideoStreamingRating();
		int audioStreamingRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getAudioStreamingRating();
		int voipRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getVoipRating();
		int voipVideoRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getVoipVideoRating();
		int messagingRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getMessagingRating();
		int surfingRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getSurfingRating();

		double videoBandwidth = videoStreamingRating * Constants.VIDEO_STREAMING_FACTOR;
		double audioBandwidth = audioStreamingRating * Constants.AUDIO_STREAMING_FACTOR;
		double voipBandwidth = voipRating * Constants.VOIP_FACTOR;
		double voipVideoBandwidth = voipVideoRating * Constants.VOIP_VIDEO_FACTOR;
		double messagingBandwidth = messagingRating * Constants.MESSAGING_FACTOR;
		double surfingBandwidth = surfingRating * Constants.SURFING_FACTOR;

		return videoBandwidth + audioBandwidth + voipBandwidth + voipVideoBandwidth + messagingBandwidth + surfingBandwidth;
	}

}
