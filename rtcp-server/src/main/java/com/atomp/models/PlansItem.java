package com.atomp.models;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class PlansItem{
	private int period;
	private int domesticCallingBandwidth;
	private int internationalCallingBandwidth;
	private double price;
	private int domesticSMSBandwidth;
	private int internationalSMSBandwidth;
	private double internetBandwidth;
}