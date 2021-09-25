
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Plan {

    @Expose
    private String callingBandwidth;
    @Expose
    private String internetBandwidth;
    @Expose
    private String period;
    @Expose
    private String price;
    @Expose
    private String smsBandwidth;

    public String getCallingBandwidth() {
        return callingBandwidth;
    }

    public String getInternetBandwidth() {
        return internetBandwidth;
    }

    public String getPeriod() {
        return period;
    }

    public String getPrice() {
        return price;
    }

    public String getSmsBandwidth() {
        return smsBandwidth;
    }

    public static class Builder {

        private String callingBandwidth;
        private String internetBandwidth;
        private String period;
        private String price;
        private String smsBandwidth;

        public Plan.Builder withCallingBandwidth(String callingBandwidth) {
            this.callingBandwidth = callingBandwidth;
            return this;
        }

        public Plan.Builder withInternetBandwidth(String internetBandwidth) {
            this.internetBandwidth = internetBandwidth;
            return this;
        }

        public Plan.Builder withPeriod(String period) {
            this.period = period;
            return this;
        }

        public Plan.Builder withPrice(String price) {
            this.price = price;
            return this;
        }

        public Plan.Builder withSmsBandwidth(String smsBandwidth) {
            this.smsBandwidth = smsBandwidth;
            return this;
        }

        public Plan build() {
            Plan plan = new Plan();
            plan.callingBandwidth = callingBandwidth;
            plan.internetBandwidth = internetBandwidth;
            plan.period = period;
            plan.price = price;
            plan.smsBandwidth = smsBandwidth;
            return plan;
        }

    }

}
