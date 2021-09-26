# real-time-curated-plans 
**AOTMP Industry Hackathon - Submission**
<br><br>
_(This is just a POC submitted for the sake of the demo and does not represent the complete actual implementation of our idea)._

# Problem Statement 
A lot of the telecom plans today are not designed around the needs of a specific customer, but instead
follow a more general approach to cover a wide percentage of potential customers. This leads to a few
issues like high churn rates, low acquisition nrates and customer satisfaction problems.

# Solution 
A more curated plan that is created using a customer’s preferences can help foster
better relations between the network and their consumers. Our new service will take
multiple inputs from the network as well as the user, based on which it can return such
curated plans and send them back to the client app to show the customer
This allows for the customers to get a more personalized experienced as soon
as they start with the subscription and be able to choose the services they actually require and
want to pay for when going for the subscription.


# Design

A backend service deployed on the cloud which will be called by NSPs to get curated plans per customer by providing it with the relevant inputs (customer preferences, etc).

![image](https://user-images.githubusercontent.com/34692418/134796342-8a1777fa-0ec8-45d8-8cb5-74241978866c.png)


# Demo

A small POC was done by our team to showcase the backend service and its capabilities for new customers who provide their preferences to the provider which in turn are passed down to the rtcp server. We then curate special plans for the customer using these inputs and send them back.

![image](https://user-images.githubusercontent.com/34692418/134796380-b00d9dff-276d-455f-a7c7-1eaedcb3f5fa.png)

(The UI was developed only to showcase the capabilities of the backend service).
