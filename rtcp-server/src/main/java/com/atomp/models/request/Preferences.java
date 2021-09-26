package com.atomp.models.request;

import com.atomp.models.request.InternetPreferences;
import com.atomp.models.request.OtherPreferences;
import lombok.Builder;
import lombok.Data;

public @Data @Builder class Preferences{
	private InternetPreferences internetPreferences;
	private OtherPreferences otherPreferences;
}