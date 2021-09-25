import React, {useCallback, useEffect, useState} from 'react';
import './App.scss';
import PreferencesBox from './components/preferences-box/preferences-box';
import {Button, Transition} from 'semantic-ui-react';
import {PlanCardProps, RealTimeCuratedPlansRequest, rtcpRequest} from './types';
import PlanCardGroup from './components/plan-card-group/plan-card-group';

const planCards: PlanCardProps[] = [
    {
        planHeader: "Rs.901",
        planPeriod: "28 Days",
        internetBandwidth: "3gb / day",
        callingBandwidth: "Unlimited STD Calls",
        smsBandwidth: "500 SMS"
    },
    {
        planHeader: "Rs.501",
        planPeriod: "28 Days",
        internetBandwidth: "1.5gb / day",
        callingBandwidth: "Unlimited STD Calls",
        smsBandwidth: "250 SMS"
    },
    {
        planHeader: "Rs.351",
        planPeriod: "28 Days",
        internetBandwidth: "1gb / day",
        callingBandwidth: "200min / day",
        smsBandwidth: "300 SMS"
    },
    {
        planHeader: "Rs.151",
        planPeriod: "28 Days",
        internetBandwidth: "0.5gb / day",
        callingBandwidth: "100min / day",
        smsBandwidth: "100 SMS"
    }
]

function App()
{
    const internetPrefs = ['Video Streaming', 'Audio Streaming', 'VoIP', 'Messaging', 'Surfing/Reading'];
    const smsPrefs = ['Domestic SMS', 'International SMS'];
    const callingPrefs = ['Domestic Calls', 'International Calls'];

    const [request, setRequest] = useState<RealTimeCuratedPlansRequest>(rtcpRequest);
    const [showPlans, setShowPlans] = useState(false);

    const updateRequest = (name: string, rating: number) =>
    {
        let newRequest = {...request};
        switch (name)
        {
            case "Video Streaming":
                newRequest.preferences.internetPreferences.ratings.videoStreamingRating = rating;
                break;
            case "Audio Streaming":
                newRequest.preferences.internetPreferences.ratings.audioStreamingRating = rating;
                break;
            case "VoIP":
                newRequest.preferences.internetPreferences.ratings.voipRating = rating;
                break;
            case "Messaging":
                newRequest.preferences.internetPreferences.ratings.messagingRating = rating;
                break;
            case "Domestic Calls":
                newRequest.preferences.otherPreferences.ratings.callRatings.domesticRating = rating;
                break;
            case "International Calls":
                newRequest.preferences.otherPreferences.ratings.callRatings.internationalRating = rating;
                break;
            case "Domestic SMS":
                newRequest.preferences.otherPreferences.ratings.smsRatings.domesticRating = rating;
                break;
            case "International SMS":
                newRequest.preferences.otherPreferences.ratings.smsRatings.internationalRating = rating;
                break;
            default:
                break;
        }

        setRequest(newRequest);
    }

    useEffect(() => console.log(request), [request]);

    const transitionDuration = 500;
    const togglePlans = () =>
    {
        if (showPlans)
        {
            setShowPlans(false);
            setTimeout(() => setShowPlans(true), transitionDuration + 100);
        }
        else
        {
            setShowPlans(true);
        }
    }

    return (
        <div className="app-container">
            <h1>Real Time Curated Plans</h1>
            <div className="preferences-container">
                <PreferencesBox prefName={"Internet Preferences"} prefsList={internetPrefs} onChange={updateRequest}/>
                <PreferencesBox prefName={"Calling Preferences"} prefsList={callingPrefs} onChange={updateRequest}/>
                <PreferencesBox prefName={"SMS Preferences"} prefsList={smsPrefs} onChange={updateRequest}/>
            </div>
            <Button primary className="plans-button" onClick={togglePlans}>Get Plans</Button>
            {
                <Transition visible={showPlans} animation='fade' duration={transitionDuration}>
                    <div className="plan-cards-box">
                        <PlanCardGroup planCards={planCards}/>
                    </div>
                </Transition>
            }
        </div>
    );
}

export default App;
