package com.atomp.models.request;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class PricingItem{
	private double bandwidth;
	private int rate;
	private int billingPeriod;
	private int bandwidthPeriod;
}