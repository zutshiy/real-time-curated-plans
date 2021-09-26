package com.atomp.models.request;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class Pricing{
	private SmsPricing smsPricing;
	private CallPricing callPricing;
}