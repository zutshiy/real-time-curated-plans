package com.atomp.models.request;

import com.atomp.models.request.DomesticPricingItem;
import com.atomp.models.request.InternationalPricingItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public @Data @Builder class SmsPricing{
	private List<DomesticPricingItem> domesticPricing;
	private List<InternationalPricingItem> internationalPricing;
}