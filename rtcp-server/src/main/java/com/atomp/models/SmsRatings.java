
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SmsRatings {

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

        public SmsRatings.Builder withDomesticRating(Long domesticRating) {
            this.domesticRating = domesticRating;
            return this;
        }

        public SmsRatings.Builder withInternationalRating(Long internationalRating) {
            this.internationalRating = internationalRating;
            return this;
        }

        public SmsRatings build() {
            SmsRatings smsRatings = new SmsRatings();
            smsRatings.domesticRating = domesticRating;
            smsRatings.internationalRating = internationalRating;
            return smsRatings;
        }

    }

}
