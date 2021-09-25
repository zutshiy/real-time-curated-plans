
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CallRatings {

    @Expose
    private Long domesticRating;
    @Expose
    private Long internationalRating;

    public Long getDomesticRating() {
        return domesticRating;
    }

    public Long getInternationalRating() {
        return internationalRating;
    }

    public static class Builder {

        private Long domesticRating;
        private Long internationalRating;

        public CallRatings.Builder withDomesticRating(Long domesticRating) {
            this.domesticRating = domesticRating;
            return this;
        }

        public CallRatings.Builder withInternationalRating(Long internationalRating) {
            this.internationalRating = internationalRating;
            return this;
        }

        public CallRatings build() {
            CallRatings callRatings = new CallRatings();
            callRatings.domesticRating = domesticRating;
            callRatings.internationalRating = internationalRating;
            return callRatings;
        }

    }

}
