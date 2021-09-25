
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InternationalPricing {

    @Expose
    private Long bandwidth;
    @Expose
    private Long bandwidthPeriod;
    @Expose
    private Long billingPeriod;
    @Expose
    private Long rate;

    public Long getBandwidth() {
        return bandwidth;
    }

    public Long getBandwidthPeriod() {
        return bandwidthPeriod;
    }

    public Long getBillingPeriod() {
        return billingPeriod;
    }

    public Long getRate() {
        return rate;
    }

    public static class Builder {

        private Long bandwidth;
        private Long bandwidthPeriod;
        private Long billingPeriod;
        private Long rate;

        public InternationalPricing.Builder withBandwidth(Long bandwidth) {
            this.bandwidth = bandwidth;
            return this;
        }

        public InternationalPricing.Builder withBandwidthPeriod(Long bandwidthPeriod) {
            this.bandwidthPeriod = bandwidthPeriod;
            return this;
        }

        public InternationalPricing.Builder withBillingPeriod(Long billingPeriod) {
            this.billingPeriod = billingPeriod;
            return this;
        }

        public InternationalPricing.Builder withRate(Long rate) {
            this.rate = rate;
            return this;
        }

        public InternationalPricing build() {
            InternationalPricing internationalPricing = new InternationalPricing();
            internationalPricing.bandwidth = bandwidth;
            internationalPricing.bandwidthPeriod = bandwidthPeriod;
            internationalPricing.billingPeriod = billingPeriod;
            internationalPricing.rate = rate;
            return internationalPricing;
        }

    }

}
