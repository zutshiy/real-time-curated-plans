package com.atomp.creators;

import com.atomp.models.PlansItem;
import com.atomp.models.request.RealtimeCuratedPlansRequest;

import java.util.List;

public abstract class PlanCreator
{
	private PlanCreator planCreator;
	public PlanCreator(PlanCreator planCreator)
	{
		this.planCreator=planCreator;
	}
	public void create(RealtimeCuratedPlansRequest realtimeCuratedPlansRequest, List<PlansItem> allPlans)
	{
		if(planCreator!=null)
		{
			planCreator.create(realtimeCuratedPlansRequest,allPlans);
		}
	}
}
