
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DomesticPricing {

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

        public DomesticPricing.Builder withBandwidth(Long bandwidth) {
            this.bandwidth = bandwidth;
            return this;
        }

        public DomesticPricing.Builder withBandwidthPeriod(Long bandwidthPeriod) {
            this.bandwidthPeriod = bandwidthPeriod;
            return this;
        }

        public DomesticPricing.Builder withBillingPeriod(Long billingPeriod) {
            this.billingPeriod = billingPeriod;
            return this;
        }

        public DomesticPricing.Builder withRate(Long rate) {
            this.rate = rate;
            return this;
        }

        public DomesticPricing build() {
            DomesticPricing domesticPricing = new DomesticPricing();
            domesticPricing.bandwidth = bandwidth;
            domesticPricing.bandwidthPeriod = bandwidthPeriod;
            domesticPricing.billingPeriod = billingPeriod;
            domesticPricing.rate = rate;
            return domesticPricing;
        }

    }

}
