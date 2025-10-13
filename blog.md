Week 1) Started of with creating entities Train and Station along with subclasses.
Then implemented dependency between station and train, every station holds trains

Then started to think about how train would move based on route constraints
considered creating a class to manage where train is within its route.

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