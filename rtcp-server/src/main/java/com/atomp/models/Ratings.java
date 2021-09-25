
package com.atomp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Ratings {

    @Expose
    private Long audioStreamingRating;
    @Expose
    private CallRatings callRatings;
    @Expose
    private Long messagingRating;
    @Expose
    private SmsRatings smsRatings;
    @Expose
    private Long surfingRating;
    @Expose
    private Long videoStreamingRating;
    @Expose
    private Long voipRating;
    @Expose
    private Long voipVideoRating;

    public Long getAudioStreamingRating() {
        return audioStreamingRating;
    }

    public CallRatings getCallRatings() {
        return callRatings;
    }

    public Long getMessagingRating() {
        return messagingRating;
    }

    public SmsRatings getSmsRatings() {
        return smsRatings;
    }

    public Long getSurfingRating() {
        return surfingRating;
    }

    public Long getVideoStreamingRating() {
        return videoStreamingRating;
    }

    public Long getVoipRating() {
        return voipRating;
    }

    public Long getVoipVideoRating() {
        return voipVideoRating;
    }

    public static class Builder {

        private Long audioStreamingRating;
        private CallRatings callRatings;
        private Long messagingRating;
        private SmsRatings smsRatings;
        private Long surfingRating;
        private Long videoStreamingRating;
        private Long voipRating;
        private Long voipVideoRating;

        public Ratings.Builder withAudioStreamingRating(Long audioStreamingRating) {
            this.audioStreamingRating = audioStreamingRating;
            return this;
        }

        public Ratings.Builder withCallRatings(CallRatings callRatings) {
            this.callRatings = callRatings;
            return this;
        }

        public Ratings.Builder withMessagingRating(Long messagingRating) {
            this.messagingRating = messagingRating;
            return this;
        }

        public Ratings.Builder withSmsRatings(SmsRatings smsRatings) {
            this.smsRatings = smsRatings;
            return this;
        }

        public Ratings.Builder withSurfingRating(Long surfingRating) {
            this.surfingRating = surfingRating;
            return this;
        }

        public Ratings.Builder withVideoStreamingRating(Long videoStreamingRating) {
            this.videoStreamingRating = videoStreamingRating;
            return this;
        }

        public Ratings.Builder withVoipRating(Long voipRating) {
            this.voipRating = voipRating;
            return this;
        }

        public Ratings.Builder withVoipVideoRating(Long voipVideoRating) {
            this.voipVideoRating = voipVideoRating;
            return this;
        }

        public Ratings build() {
            Ratings ratings = new Ratings();
            ratings.audioStreamingRating = audioStreamingRating;
            ratings.callRatings = callRatings;
            ratings.messagingRating = messagingRating;
            ratings.smsRatings = smsRatings;
            ratings.surfingRating = surfingRating;
            ratings.videoStreamingRating = videoStreamingRating;
            ratings.voipRating = voipRating;
            ratings.voipVideoRating = voipVideoRating;
            return ratings;
        }

    }

}
