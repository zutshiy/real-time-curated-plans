export interface PlanCardProps
{
    planHeader: string,
    planPeriod: string,
    internetBandwidth: string,
    domesticCallingBandwidth: string,
    internationalCallingBandwidth: string,
    domesticSMSBandwidth: string
    internationalSMSBandwidth: string
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
                voipVideoRating: number,
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

export interface RealTimeCuratedPlansResponse
{
    plans: [
        {
            price: string,
            period: string,
            internetBandwidth: string,
            domesticCallingBandwidth: string,
            internationalCallingBandwidth: string,
            domesticSMSBandwidth: string
            internationalSMSBandwidth: string
        }
    ]
}
