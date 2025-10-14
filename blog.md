Week 1) 

After reading the spec I focused on single entities including Train, and Station.
I then also created their respective subclasses while noting differences from the super class.
Each Train Type had a different speed, and Each Station Type has a maximum number of trains which I implemented.

I changed Station to an abstract class as each station type can then implement addTrainsToStation while adhering to 
constraints of maximum number of trains for each station type.

I then thought about the relationships between Train and Station which are closely
linked within this system. I realised that each Station must hold a particular number of Trains and therefore refers
to a has-a relationship. 

I then started to think about how to model routes within my design. I initially created a Route class which stores
list of tracks, and stationIds to determine whether a route is linear of cyclical.

After determining the type of route I then moved to train movement. As each train moves differently based on the 
route type

Cargo and Passenger Train had similar code for calculating the next station in linear route
so continued to refactor and add more responsibility to route class

Week 2) 

After finishing movement I decided to implement embarking and disembarking.
However I found a major bug with train movement in that route was updating its position prematurely
even when the train did not reach the next station causing inconsisties between route position and
trains current position. So i went back and refactored route again.

Then I realised that train should not be in charge of embarking and disembarking,
and rather these actions happen from the context of the station. (You embark from a station and you
disembark on to a station)

This also meant that train was only responsible for movement and not managing loads activity

Then implemented cargo slowdown


Week 3)
Introduced TrainSystemData class to minimise coupling