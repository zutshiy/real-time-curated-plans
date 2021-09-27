import React from 'react';
import {Button, Card} from 'semantic-ui-react';
import {PlanCardProps} from '../../types';


const PlanCardGroup = ({planCards}: { planCards: PlanCardProps[] }) =>
{
    return (
        <Card.Group>
            {
                planCards.map((planCard, index) => (
                    <Card key={index}>
                        <Card.Content>
                            <Card.Header>{planCard.planHeader}</Card.Header>
                            <Card.Meta>{planCard.planPeriod}</Card.Meta>
                            <Card.Description>
                                <ul>
                                    <li>{planCard.internetBandwidth}</li>
                                    <li>{planCard.domesticCallingBandwidth}</li>
                                    {planCard.internationalCallingBandwidth && <li>{planCard.internationalCallingBandwidth}</li>}
                                    <li>{planCard.domesticSMSBandwidth}</li>
                                    {planCard.internationalSMSBandwidth && <li>{planCard.internationalSMSBandwidth}</li>}
                                </ul>
                            </Card.Description>
                        </Card.Content>
                        <Card.Content extra>
                            <div className='ui two buttons'>
                                <Button color='green'>
                                    Select
                                </Button>
                                <Button basic color='grey'>
                                    Details
                                </Button>
                            </div>
                        </Card.Content>
                    </Card>
                ))
            }
        </Card.Group>
    );
};

export default PlanCardGroup;
