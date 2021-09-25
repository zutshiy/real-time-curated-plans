
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Preferences {

    @Expose
    private InternetPreferences internetPreferences;
    @Expose
    private OtherPreferences otherPreferences;

    public InternetPreferences getInternetPreferences() {
        return internetPreferences;
    }

    public OtherPreferences getOtherPreferences() {
        return otherPreferences;
    }

    public static class Builder {

        private InternetPreferences internetPreferences;
        private OtherPreferences otherPreferences;

        public Preferences.Builder withInternetPreferences(InternetPreferences internetPreferences) {
            this.internetPreferences = internetPreferences;
            return this;
        }

        public Preferences.Builder withOtherPreferences(OtherPreferences otherPreferences) {
            this.otherPreferences = otherPreferences;
            return this;
        }

        public Preferences build() {
            Preferences preferences = new Preferences();
            preferences.internetPreferences = internetPreferences;
            preferences.otherPreferences = otherPreferences;
            return preferences;
        }

    }

}
