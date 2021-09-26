package com.atomp.models.request;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class RealtimeCuratedPlansRequest{
	private Preferences preferences;
	private String status;
}