export const videoStreamUsages = ["< 1  hr / day", "~ 1  hr / day", "~ 2  hr / day", "~ 3  hr / day", "~ 4  hr / day", "~ 5  hr / day"];
export const audioStreamUsages = ["< 1  hr / day", "~ 0.5  hr / day", "~ 1  hr / day", "~ 1.5  hr / day", "~ 2  hr / day", "~ 3  hr / day"];
export const voipUsages = ["< 1  hr / day", "~ 1  hr / day", "~ 2  hr / day", "~ 3  hr / day", "~ 4.5  hr / day", "~ 6  hr / day"];
export const voipVideoUsages = ["< 1  hr / day", "~ 0.5  hr / day", "~ 1  hr / day", "~ 1.5  hr / day", "~ 3  hr / day", "~ 4  hr / day"];
export const messagingUsages = ["< 100 msgs / day", "~ 300 msgs / day", "~ 500 msgs / day", "~ 1000 msgs / day", "~ 1500 msgs / day", "~ 2000 msgs / day"];
export const surfingUsages = ["< 1  hr / day", "~ 1  hr / day", "~ 2  hr / day", "~ 3  hr / day", "~ 4  hr / day", "~ 5  hr / day"];


export const callingDomesticUsages = ["< 1  hr / day", "~ 1  hr / day", "~ 2  hr / day", "~ 3  hr / day", "~ 4  hr / day", "~ 5  hr / day"];
export const callingInternationalUsages = ["0 hr / day", "~ 1  hr / day", "~ 2  hr / day", "~ 3  hr / day", "~ 4  hr / day", "~ 5  hr / day"];


export const smsDomesticUsages = ["< 100 msgs / day", "~ 300 msgs / day", "~ 500 msgs / day", "~ 1000 msgs / day", "~ 1500 msgs / day", "~ 2000 msgs / day"];
export const smsInternationalUsages = ["0 msgs / day", "~ 300 msgs / day", "~ 500 msgs / day", "~ 1000 msgs / day", "~ 1500 msgs / day", "~ 2000 msgs / day"];



export const rtcpRequest = {
    "status": "New",
    "preferences": {
        "internetPreferences": {
            "ratings": {
                "videoStreamingRating": 0,
                "audioStreamingRating": 1,
                "voipRating": 3,
                "voipVideoRating": 0,
                "messagingRating": 3,
                "surfingRating":3
            },
            "pricing": [
                {
                    "bandwidth": 0.25,
                    "rate": 75,
                    "bandwidthPeriod": 1,
                    "billingPeriod": 28
                },
                {
                    "bandwidth": 0.5,
                    "rate": 100,
                    "bandwidthPeriod": 1,
                    "billingPeriod": 28
                },
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
                    "bandwidthPeriod": 1,
                    "billingPeriod": 28
                },
                {
                    "bandwidth": 10,
                    "rate": 700,
                    "bandwidthPeriod": 28,
                    "billingPeriod": 28
                },
                {
                    "bandwidth": 15,
                    "rate": 800,
                    "bandwidthPeriod": 28,
                    "billingPeriod": 28
                },
                {
                    "bandwidth": 20,
                    "rate": 90,
                    "bandwidthPeriod": 28,
                    "billingPeriod": 28
                },
                {
                    "bandwidth": 20,
                    "rate": 400,
                    "bandwidthPeriod": 365,
                    "billingPeriod": 365
                },
                {
                    "bandwidth": 25,
                    "rate": 600,
                    "bandwidthPeriod": 365,
                    "billingPeriod": 365
                },
                {
                    "bandwidth": 30,
                    "rate": 760,
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
                            "bandwidth": -1,
                            "rate": 20,
                            "bandwidthPeriod": 28,
                            "billingPeriod": 28
                        },{
                            "bandwidth": 300,
                            "rate": 10,
                            "bandwidthPeriod": 1,
                            "billingPeriod": 28
                        },{
                            "bandwidth": 500,
                            "rate": 15,
                            "bandwidthPeriod": 1,
                            "billingPeriod": 28
                        },{
                            "bandwidth": 1000,
                            "rate": 20,
                            "bandwidthPeriod": 1,
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
                            "rate": 60,
                            "bandwidthPeriod": 28,
                            "billingPeriod": 28
                        },{
                            "bandwidth": 450,
                            "rate": 200,
                            "bandwidthPeriod": 1,
                            "billingPeriod": 28
                        },{
                            "bandwidth": 300,
                            "rate": 130,
                            "bandwidthPeriod": 1,
                            "billingPeriod": 28
                        },{
                            "bandwidth": 100,
                            "rate": 60,
                            "bandwidthPeriod": 1,
                            "billingPeriod": 28
                        },{
                            "bandwidth": 50,
                            "rate": 35,
                            "bandwidthPeriod": 1,
                            "billingPeriod": 28
                        }
                    ],
                    "internationalPricing": [
                        {
                            "bandwidth": 50,
                            "rate": 300,
                            "bandwidthPeriod": 1,
                            "billingPeriod": 28
                        },
                        {
                            "bandwidth": 100,
                            "rate": 400,
                            "bandwidthPeriod": 1,
                            "billingPeriod": 28
                        },
                        {
                            "bandwidth": 400,
                            "rate": 750,
                            "bandwidthPeriod": 1,
                            "billingPeriod": 28
                        }
                    ]
                }
            }
        }
    }
}
