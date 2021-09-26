package com.atomp.models.request;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class Ratings{
	private CallRatings callRatings;
	private SmsRatings smsRatings;
	private int messagingRating;
	private int voipRating;
	private int videoStreamingRating;
	private int audioStreamingRating;
	private int voipVideoRating;
	private int surfingRating;
}