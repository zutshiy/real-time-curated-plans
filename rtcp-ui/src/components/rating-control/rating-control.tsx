import './rating-control.scss'
import React from 'react';
import {Rating} from 'semantic-ui-react';
import {RatingProps} from 'semantic-ui-react/dist/commonjs/modules/Rating/Rating';


const RatingControl = ({name, onChange}: { name: string, onChange: (name: string, rating: number) => void }) =>
{
    const handleRate = (event: React.MouseEvent<HTMLDivElement>, data: RatingProps) =>
    {
        onChange(name, data.rating as number);
    };

    return (
        <div className="rating-container">
            <span>{name}</span>
            <Rating maxRating={5} size={"huge"} onRate={handleRate} clearable/>
        </div>
    );
};

export default RatingControl;
