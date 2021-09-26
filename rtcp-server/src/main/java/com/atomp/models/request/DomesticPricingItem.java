package com.atomp.models.request;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class DomesticPricingItem{
	private int bandwidth;
	private double rate;
	private int billingPeriod;
	private int bandwidthPeriod;
}