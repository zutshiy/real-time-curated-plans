export interface PlanCardProps
{
    planHeader: string,
    planPeriod: string,
    internetBandwidth: string,
    callingBandwidth: string,
    smsBandwidth: string
}

export interface Pricing
{
    bandwidth: number,
    rate: number,
    bandwidthPeriod: number,
    billingPeriod: number
}

export interface RealTimeCuratedPlansRequest
{
    status: string,
    preferences: {
        internetPreferences: {
            "ratings": {
                videoStreamingRating: number,
                audioStreamingRating: number,
                voipRating: number,
                messagingRating: number,
                surfingRating: number
            },
            pricing: Pricing[]

        },
        otherPreferences: {
            ratings: {
                callRatings: {
                    "domesticRating": number,
                    "internationalRating": number
                }
                smsRatings: {
                    "domesticRating": number,
                    "internationalRating": number
                },
            },
            pricing: {
                callPricing: {
                    domesticPricing: Pricing[],
                    internationalPricing: Pricing[]
                }
                smsPricing: {
                    domesticPricing: Pricing[],
                    internationalPricing: Pricing[],
                },
            }
        }
    }
}


export const rtcpRequest = {
    "status": "New",
    "preferences": {
        "internetPreferences": {
            "ratings": {
                "videoStreamingRating": 0,
                "audioStreamingRating": 0,
                "voipRating": 0,
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
                    "bandwidthPeriod": 350,
                    "billingPeriod": 350
                }
            ]
        },
        "otherPreferences": {
            "ratings": {
                "callRatings": {
                    "domesticRating": 0,
                    "internationalRating": 0
                },
                "smsRatings": {
                    "domesticRating": 0,
                    "internationalRating": 0
                }
            },
            "pricing": {
                "callPricing": {
                    "domesticPricing": [
                        {
                            "bandwidth": -1,
                            "rate": 100,
                            "bandwidthPeriod": 28,
                            "billingPeriod": 28
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
                },
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
                }
            }
        }
    }
}
