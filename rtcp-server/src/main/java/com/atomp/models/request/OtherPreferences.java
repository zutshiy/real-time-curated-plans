package com.atomp.models.request;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class OtherPreferences{
	private Ratings ratings;
	private Pricing pricing;
}