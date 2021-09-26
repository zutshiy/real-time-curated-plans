import React, {useState} from 'react';
import './App.scss';
import PreferencesBox from './components/preferences-box/preferences-box';
import {Button, Transition} from 'semantic-ui-react';
import {PlanCardProps, RealTimeCuratedPlansRequest, RealTimeCuratedPlansResponse, rtcpRequest} from './types';
import PlanCardGroup from './components/plan-card-group/plan-card-group';

function App()
{
    const internetPrefs = ['Video Streaming', 'Audio Streaming', 'VoIP', 'VoIP Video Streaming', 'Messaging', 'Surfing/Reading'];
    const smsPrefs = ['Domestic SMS', 'International SMS'];
    const callingPrefs = ['Domestic Calls', 'International Calls'];

    const [request, setRequest] = useState<RealTimeCuratedPlansRequest>(rtcpRequest);
    const [showPlans, setShowPlans] = useState(false);
    const [planCards, setPlanCards] = useState<PlanCardProps[]>([]);

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
            case "VoIP Video Streaming":
                newRequest.preferences.internetPreferences.ratings.voipVideoRating = rating;
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

    const transitionDuration = 500;

    function callRestAndUpdateCards()
    {
        const requestOptions: RequestInit = {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(request),
        };

        fetch(" http://localhost:8080/curate-plan", requestOptions)
            .then(res => res.json())
            .then((data: RealTimeCuratedPlansResponse) =>
            {
                const newPlanCards: PlanCardProps[] = [];
                data.plans.forEach(plan => newPlanCards.push({
                    planHeader: plan.price,
                    planPeriod: plan.period,
                    internetBandwidth: plan.internetBandwidth,
                    callingBandwidth: plan.callingBandwidth,
                    smsBandwidth: plan.smsBandwidth,
                }))
                setPlanCards(newPlanCards);
                setShowPlans(true);
            })
            .catch(console.log)
    }

    const togglePlans = () =>
    {
        if (showPlans)
        {
            setShowPlans(false);
        }
        callRestAndUpdateCards();
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
