export const videoStreamUsages = ["< 1 hr", "~ 1 hr", "~ 2 hr", "~ 3 hr", "~ 4 hr", "~ 5 hr"];
export const audioStreamUsages = ["< 1 hr", "~ 0.5 hr", "~ 1 hr", "~ 1.5 hr", "~ 2 hr", "~ 3 hr"];
export const voipUsages = ["< 1 hr", "~ 1 hr", "~ 2 hr", "~ 3 hr", "~ 4.5 hr", "~ 6 hr"];
export const voipVideoUsages = ["< 1 hr", "~ 0.5 hr", "~ 1 hr", "~ 1.5 hr", "~ 3 hr", "~ 4 hr"];
export const messagingUsages = ["< 1 hr", "~ 0.5 hr", "~ 1 hr", "~ 1.5 hr", "~ 3 hr", "~ 4 hr"];
export const surfingUsages = ["< 1 hr", "~ 1 hr", "~ 2 hr", "~ 3 hr", "~ 4 hr", "~ 5 hr"];


export const callingDomesticUsages = ["< 1 hr", "~ 1 hr", "~ 2 hr", "~ 3 hr", "~ 4 hr", "~ 5 hr"];
export const callingInternationalUsages = ["< 1 hr", "~ 1 hr", "~ 2 hr", "~ 3 hr", "~ 4 hr", "~ 5 hr"];


export const smsDomesticUsages = ["< 1 hr", "~ 1 hr", "~ 2 hr", "~ 3 hr", "~ 4 hr", "~ 5 hr"];
export const smsInternationalUsages = ["< 1 hr", "~ 1 hr", "~ 2 hr", "~ 3 hr", "~ 4 hr", "~ 5 hr"];



export const rtcpRequest = {
    "status": "New",
    "preferences": {
        "internetPreferences": {
            "ratings": {
                "videoStreamingRating": 0,
                "audioStreamingRating": 0,
                "voipRating": 0,
                "voipVideoRating": 0,
                "messagingRating": 0,
                "surfingRating": 0
            },
            "pricing": [
                {
                    "bandwidth": 1,
                    "rate": 200,
                    "bandwidthPeriod": 1,
                    "billingPeriod": 28
                },
                {
                    "bandwidth": 3,
                    "rate": 300,
                    "bandwidthPeriod": 1,
                    "billingPeriod": 28
                },
                {
                    "bandwidth": 5,
                    "rate": 400,
                    "bandwidthPeriod": 1,
                    "billingPeriod": 28
                },
                {
                    "bandwidth": 7,
                    "rate": 500,
                    "bandwidthPeriod": 28,
                    "billingPeriod": 28
                },
                {
                    "bandwidth": 12,
                    "rate": 1000,
                    "bandwidthPeriod": 365,
                    "billingPeriod": 365
                }
            ]
        },
        "otherPreferences": {
            "ratings": {
                "smsRatings": {
                    "domesticRating": 0,
                    "internationalRating": 0
                },
                "callRatings": {
                    "domesticRating": 0,
                    "internationalRating": 0
                }
            },
            "pricing": {
                "smsPricing": {
                    "domesticPricing": [
                        {
                            "bandwidth": 500,
                            "rate": 100,
                            "bandwidthPeriod": 28,
                            "billingPeriod": 28
                        }
                    ],
                    "internationalPricing": [
                        {
                            "bandwidth": 100,
                            "rate": 100,
                            "bandwidthPeriod": 28,
                            "billingPeriod": 28
                        },
                        {
                            "bandwidth": 300,
                            "rate": 200,
                            "bandwidthPeriod": 28,
                            "billingPeriod": 28
                        },
                        {
                            "bandwidth": 500,
                            "rate": 300,
                            "bandwidthPeriod": 28,
                            "billingPeriod": 28
                        }
                    ]
                },
                "callPricing": {
                    "domesticPricing": [
                        {
                            "bandwidth": -1,
                            "rate": 100,
                            "bandwidthPeriod": 0,
                            "billingPeriod": 0
                        }
                    ],
                    "internationalPricing": [
                        {
                            "bandwidth": 200,
                            "rate": 300,
                            "bandwidthPeriod": 28,
                            "billingPeriod": 28
                        },
                        {
                            "bandwidth": 300,
                            "rate": 400,
                            "bandwidthPeriod": 28,
                            "billingPeriod": 28
                        },
                        {
                            "bandwidth": 2400,
                            "rate": 1200,
                            "bandwidthPeriod": 365,
                            "billingPeriod": 365
                        }
                    ]
                }
            }
        }
    }
}
