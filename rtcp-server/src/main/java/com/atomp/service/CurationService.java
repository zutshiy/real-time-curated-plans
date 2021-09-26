package com.atomp.service;

import com.atomp.models.Plan;
import com.atomp.models.Pricing;
import com.atomp.models.RealtimeCuratedPlansRequest;
import com.atomp.models.RealtimeCuratedPlansResponse;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class CurationService
{

	public RealtimeCuratedPlansResponse execute(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest)
	{
		Long videoStreamingRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getVideoStreamingRating();
		Long audioStreamingRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getAudioStreamingRating();
		Long voipRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getVoipRating();
		Long voipVideoRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getVoipVideoRating();
		Long messagingRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getMessagingRating();
		Long surfingRating = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getRatings().getSurfingRating();

		double videoBandwidth = videoStreamingRating.doubleValue() * Constants.VIDEO_STREAMING_FACTOR;
		double audioBandwidth = audioStreamingRating.doubleValue() * Constants.AUDIO_STREAMING_FACTOR;
		double voipBandwidth = voipRating.doubleValue() * Constants.VOIP_FACTOR;
		double voipVideoBandwidth = voipVideoRating.doubleValue() * Constants.VOIP_VIDEO_FACTOR;
		double messagingBandwidth = messagingRating.doubleValue() * Constants.MESSAGING_FACTOR;
		double surfingBandwidth = surfingRating.doubleValue() * Constants.SURFING_FACTOR;

		double totalBandwidth = videoBandwidth + audioBandwidth + voipBandwidth + voipVideoBandwidth + messagingBandwidth + surfingBandwidth;
		double finalBandwidth = Math.ceil(Math.round(totalBandwidth * 100.0) / 10.0) / 10.0;
		List<Pricing> allPricing = realtimeCuratedPlansRequest.getPreferences().getInternetPreferences().getPricing();

		Optional<Pricing> pricingForBandwidth = allPricing.stream().sorted(Comparator.comparing(Pricing::getBandwidth))
				.filter(cb -> cb.getBandwidth() > finalBandwidth).findFirst();
		RealtimeCuratedPlansResponse realtimeCuratedPlansResponse = null;
		if (pricingForBandwidth.isPresent())
		{
			RealtimeCuratedPlansResponse.Builder builder = new RealtimeCuratedPlansResponse.Builder();

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

			List<Plan> allPlans = new ArrayList<>();

			Plan perfectPlan = createPlan(finalBandwidth, pricingForBandwidth.get());
			allPlans.add(perfectPlan);
			if (lowerLimit != 0)
			{
				Plan lowerLimitPlan = createPlan(lowerLimit, pricingForBandwidth.get());
				allPlans.add(lowerLimitPlan);
			}

			Plan uperLimitPlan = createPlan(upperLimit, pricingForBandwidth.get());
			allPlans.add(uperLimitPlan);

			double monthlyBandwidth = finalBandwidth * 28;

			if (monthlyBandwidth < 21)
			{
				Optional<Pricing> pricingForBandwidthForMonth = allPricing.stream().filter(a -> a.getBandwidthPeriod() == 28)
						.sorted(Comparator.comparing(Pricing::getBandwidth)).filter(cb -> cb.getBandwidth() > monthlyBandwidth).findFirst();
				if (pricingForBandwidthForMonth.isPresent())
				{
					Plan monthlyPlan = createPlan(monthlyBandwidth, pricingForBandwidthForMonth.get(), 28);
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
					Plan yearlyPlan = createPlan(yearlyBandwidth, pricingForBandwidthForYear.get(), 365);
					allPlans.add(yearlyPlan);
				}
			}
			realtimeCuratedPlansResponse = builder.withPlans(allPlans).build();
		}
		return realtimeCuratedPlansResponse;
	}

	private Plan createPlan(double finalBandwidth, Pricing pricing)
	{
		Plan.Builder plaBuilder = new Plan.Builder();
		double unit = (double) pricing.getRate() / pricing.getBandwidth();
		long finalRate = (long) (finalBandwidth * unit);
		DecimalFormat df = new DecimalFormat("#.#");
		plaBuilder.withInternetBandwidth(df.format(finalBandwidth) + " GB/Day").withPrice("Rs. " + finalRate).withPeriod(28 + " Days")
				.withCallingBandwidth("Unlimited STD Calls").withSmsBandwidth("500 SMS"); return plaBuilder.build();
	}

	private Plan createPlan(double finalBandwidth, Pricing pricing, int period)
	{
		Plan.Builder plaBuilder = new Plan.Builder();
		long finalRate = pricing.getRate();
		DecimalFormat df = new DecimalFormat("#.#");
		plaBuilder.withInternetBandwidth(df.format(pricing.getBandwidth()) + " GB").withPrice("Rs. " + finalRate).withPeriod(period + " Days")
				.withCallingBandwidth("Unlimited STD Calls").withSmsBandwidth("500 SMS");
		return plaBuilder.build();
	}
}
