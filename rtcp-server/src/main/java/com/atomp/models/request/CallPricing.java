package com.atomp.models.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

public @Data @Builder class CallPricing{
	private List<DomesticPricingItem> domesticPricing;
	private List<InternationalPricingItem> internationalPricing;
}