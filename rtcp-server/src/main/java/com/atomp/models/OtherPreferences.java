
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class OtherPreferences {

    @Expose
    private Pricing pricing;
    @Expose
    private Ratings ratings;

    public Pricing getPricing() {
        return pricing;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public static class Builder {

        private Pricing pricing;
        private Ratings ratings;

        public OtherPreferences.Builder withPricing(Pricing pricing) {
            this.pricing = pricing;
            return this;
        }

        public OtherPreferences.Builder withRatings(Ratings ratings) {
            this.ratings = ratings;
            return this;
        }

        public OtherPreferences build() {
            OtherPreferences otherPreferences = new OtherPreferences();
            otherPreferences.pricing = pricing;
            otherPreferences.ratings = ratings;
            return otherPreferences;
        }

    }

}
