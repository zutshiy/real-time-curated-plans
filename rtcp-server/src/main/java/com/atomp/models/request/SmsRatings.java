package com.atomp.models.request;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class SmsRatings{
	private int domesticRating;
	private int internationalRating;
}