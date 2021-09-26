import './rating-control.scss'
import React, {useState} from 'react';
import {Rating} from 'semantic-ui-react';
import {RatingProps} from 'semantic-ui-react/dist/commonjs/modules/Rating/Rating';
import {
    audioStreamUsages,
    callingDomesticUsages,
    callingInternationalUsages,
    messagingUsages, smsDomesticUsages, smsInternationalUsages,
    surfingUsages,
    videoStreamUsages,
    voipUsages,
    voipVideoUsages
} from '../../constants';


const RatingControl = ({name, onChange}: { name: string, onChange: (name: string, rating: number) => void }) =>
{
    const [usage, setUsage] = useState(calculateUsage(name, 0));
    const handleRate = (event: React.MouseEvent<HTMLDivElement>, data: RatingProps) =>
    {
        const rating = data.rating as number;
        let usage = calculateUsage(name, rating);
        setUsage(usage);
        onChange(name, rating);
    };

    return (
        <div className="rating-container">
            <span>{name}</span>
            <div className="rating-stars">
                <Rating maxRating={5} size={"huge"} onRate={handleRate} clearable/>
                <span>{usage}</span>
            </div>
        </div>
    );
};

const calculateUsage = (name: string, rating: number): string => {
    switch (name)
    {
        case "Video Streaming":
            return videoStreamUsages[rating];
        case "Audio Streaming":
            return audioStreamUsages[rating];
        case "VoIP":
            return voipUsages[rating];
        case "VoIP Video":
            return voipVideoUsages[rating];
        case "Messaging":
            return messagingUsages[rating];
        case "Surfing/Reading":
            return surfingUsages[rating];
        case "Domestic Calls":
            return callingDomesticUsages[rating];
        case "International Calls":
            return callingInternationalUsages[rating];
        case "Domestic SMS":
            return smsDomesticUsages[rating];
        case "International SMS":
            return smsInternationalUsages[rating];
        default:
            return "";
    }
}

export default RatingControl;
