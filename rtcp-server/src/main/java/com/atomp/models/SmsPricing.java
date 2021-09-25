
package com.atomp.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SmsPricing {

    @Expose
    private List<DomesticPricing> domesticPricing;
    @Expose
    private List<InternationalPricing> internationalPricing;

    public List<DomesticPricing> getDomesticPricing() {
        return domesticPricing;
    }

    public List<InternationalPricing> getInternationalPricing() {
        return internationalPricing;
    }

    public static class Builder {

        private List<DomesticPricing> domesticPricing;
        private List<InternationalPricing> internationalPricing;

        public SmsPricing.Builder withDomesticPricing(List<DomesticPricing> domesticPricing) {
            this.domesticPricing = domesticPricing;
            return this;
        }

        public SmsPricing.Builder withInternationalPricing(List<InternationalPricing> internationalPricing) {
            this.internationalPricing = internationalPricing;
            return this;
        }

        public SmsPricing build() {
            SmsPricing smsPricing = new SmsPricing();
            smsPricing.domesticPricing = domesticPricing;
            smsPricing.internationalPricing = internationalPricing;
            return smsPricing;
        }

    }

}
