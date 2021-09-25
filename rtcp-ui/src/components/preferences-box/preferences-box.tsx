import './preferences-box.scss';
import React from 'react';
import RatingControl from '../rating-control/rating-control';

const PreferencesBox = ({prefName, prefsList, onChange}: { prefName: string, prefsList: string[], onChange: (name: string, rating: number) => void }) =>
{
    return (
        <div className="internet-preferences">
            <h2>{prefName}: </h2>
            {
                prefsList.map((pref, index) =>
                    <RatingControl name={pref} key={index} onChange={onChange}/>
                )
            }
        </div>
    );
};

export default PreferencesBox;
