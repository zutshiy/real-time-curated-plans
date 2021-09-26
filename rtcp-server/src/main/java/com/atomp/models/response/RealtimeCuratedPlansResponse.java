package com.atomp.models.response;

import com.atomp.models.PlansItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public @Data @Builder class RealtimeCuratedPlansResponse{
	private List<Plans> plans;
}