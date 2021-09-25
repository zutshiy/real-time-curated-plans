
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Pricing {

    @Expose
    private Long bandwidth;
    @Expose
    private Long bandwidthPeriod;
    @Expose
    private Long billingPeriod;
    @Expose
    private CallPricing callPricing;
    @Expose
    private Long rate;
    @Expose
    private SmsPricing smsPricing;

    public Long getBandwidth() {
        return bandwidth;
    }

    public Long getBandwidthPeriod() {
        return bandwidthPeriod;
    }

    public Long getBillingPeriod() {
        return billingPeriod;
    }

    public CallPricing getCallPricing() {
        return callPricing;
    }

    public Long getRate() {
        return rate;
    }

    public SmsPricing getSmsPricing() {
        return smsPricing;
    }

    public static class Builder {

        private Long bandwidth;
        private Long bandwidthPeriod;
        private Long billingPeriod;
        private CallPricing callPricing;
        private Long rate;
        private SmsPricing smsPricing;

        public Pricing.Builder withBandwidth(Long bandwidth) {
            this.bandwidth = bandwidth;
            return this;
        }

        public Pricing.Builder withBandwidthPeriod(Long bandwidthPeriod) {
            this.bandwidthPeriod = bandwidthPeriod;
            return this;
        }

        public Pricing.Builder withBillingPeriod(Long billingPeriod) {
            this.billingPeriod = billingPeriod;
            return this;
        }

        public Pricing.Builder withCallPricing(CallPricing callPricing) {
            this.callPricing = callPricing;
            return this;
        }

        public Pricing.Builder withRate(Long rate) {
            this.rate = rate;
            return this;
        }

        public Pricing.Builder withSmsPricing(SmsPricing smsPricing) {
            this.smsPricing = smsPricing;
            return this;
        }

        public Pricing build() {
            Pricing pricing = new Pricing();
            pricing.bandwidth = bandwidth;
            pricing.bandwidthPeriod = bandwidthPeriod;
            pricing.billingPeriod = billingPeriod;
            pricing.callPricing = callPricing;
            pricing.rate = rate;
            pricing.smsPricing = smsPricing;
            return pricing;
        }

    }

}
