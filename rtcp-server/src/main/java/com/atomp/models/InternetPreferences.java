
package com.atomp.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InternetPreferences {

    @Expose
    private List<Pricing> pricing;
    @Expose
    private Ratings ratings;

    public List<Pricing> getPricing() {
        return pricing;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public static class Builder {

        private List<Pricing> pricing;
        private Ratings ratings;

        public InternetPreferences.Builder withPricing(List<Pricing> pricing) {
            this.pricing = pricing;
            return this;
        }

        public InternetPreferences.Builder withRatings(Ratings ratings) {
            this.ratings = ratings;
            return this;
        }

        public InternetPreferences build() {
            InternetPreferences internetPreferences = new InternetPreferences();
            internetPreferences.pricing = pricing;
            internetPreferences.ratings = ratings;
            return internetPreferences;
        }

    }

}
