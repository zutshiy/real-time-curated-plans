package com.atomp.models.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

public @Data @Builder class InternetPreferences{
	private Ratings ratings;
	private List<PricingItem> pricing;
}