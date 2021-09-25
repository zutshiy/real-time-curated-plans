
package com.atomp.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RealtimeCuratedPlansResponse {

    @Expose
    private List<Plan> plans;

    public List<Plan> getPlans() {
        return plans;
    }

    public static class Builder {

        private List<Plan> plans;

        public RealtimeCuratedPlansResponse.Builder withPlans(List<Plan> plans) {
            this.plans = plans;
            return this;
        }

        public RealtimeCuratedPlansResponse build() {
            RealtimeCuratedPlansResponse realtimeCuratedPlansResponse = new RealtimeCuratedPlansResponse();
            realtimeCuratedPlansResponse.plans = plans;
            return realtimeCuratedPlansResponse;
        }

    }

}
