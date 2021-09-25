
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RealtimeCuratedPlansRequest {

    @Expose
    private Preferences preferences;
    @Expose
    private String status;

    public Preferences getPreferences() {
        return preferences;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {

        private Preferences preferences;
        private String status;

        public RealtimeCuratedPlansRequest.Builder withPreferences(Preferences preferences) {
            this.preferences = preferences;
            return this;
        }

        public RealtimeCuratedPlansRequest.Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public RealtimeCuratedPlansRequest build() {
            RealtimeCuratedPlansRequest realtimeCuratedPlansRequest = new RealtimeCuratedPlansRequest();
            realtimeCuratedPlansRequest.preferences = preferences;
            realtimeCuratedPlansRequest.status = status;
            return realtimeCuratedPlansRequest;
        }

    }

}
