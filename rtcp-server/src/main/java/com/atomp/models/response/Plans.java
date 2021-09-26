package com.atomp.models.response;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class Plans
{
	private String period;
	private String domesticCallingBandwidth;
	private String internationalCallingBandwidth;
	private String price;
	private String domesticSMSBandwidth;
	private String internationalSMSBandwidth;
	private String internetBandwidth;
}