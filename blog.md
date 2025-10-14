Week 1) 

After reading the spec I focused on single entities including Train, and Station.
I then also created their respective subclasses while noting differences from the super class.
Each Train Type had a different speed, and Each Station Type has a maximum number of trains which I implemented.

I changed Station to an abstract class as each station type can then implement addTrainsToStation while adhering to 
constraints of maximum number of trains for each station type.

I then thought about the relationships between Train and Station which are closely
linked within this system. I realised that each Station must hold a particular number of Trains and therefore refers
to a has-a relationship. 

I then started to think about how to model routes within my design. I initially created a Route class which stores list of tracks, and stationIds to determine whether a route is linear of cyclical. Moreover the route class also stored a routeIndex which indicated where the train was respective to the route.

After determining the type of route I then moved to train movement. I first implemented movement
within the train superclass, however I realised that each train moves differently depending on the type 
of route. (Cargo and Passenger run on linear routes while BulletTrain runs on cyclical), Hence I converted Train to an abstract class and refactored movement logic to each individual subclass.
I noticed that both Cargo and Passenger had the exact same logic which lead to unnecessary repetition.
Considering this the responsiblity of calculating next station based and updating trains position was moved to the route class so that train only focuses on movement. 
This allowed me to refactor and improve my code according to single responsiblity principle.

I also finished implementing side effect functionalities of stations such as removing and adding trains
during the movement phase.


Week 2)

I then created the Load class and also Cargo/Passenger Subclasses before implementing embarking and disembarking of loads.

During testing I encountered a bug with train movement in that route class was updating the trains routeIndex and position prematurely in cases where the train did not reach the next station and instead was positioned between two positions. To mitigate this I refactored the route class and split up the functions which calculated the next station, to only update after reaching a station.

I initially gave the train the responsiblity of embarking and disembarking, however upon rereviewing 
section 2.2.4.5 of the spec I realised that this was in fact the stations responsibility.
This refactor also allowed me to improve my design according to the single responsiblity principle as train is only responsible for moving between stations, while embarking & disembarking of loads is managed
by the station.

I also implemented Cargo Slowdown within the cargo class.


Week 3)

I spent most of my time trying to optimise my desing in terms of coupling and cohesion.
I realised that my design was tightly coupled with each entity having a static helper function with
shared data being constantly passed from trains controller and around everywhere within my system.

I thought of minimising coupling by creating a TrainSystemData class responsible for handling data 
and the respective helper functions to obtain objects from stringIds. However that also posed an issue
of passing unnecessary data which entities did not need.

So instead I decided to use helper functions within my TrainsControllerClass to only pass in the 
required parameters instead of sending lists of data (ie Station, Train, Track lists). This allowed me
to remove unnecessary parameters within my classes. 

Moreover I refactored route again so that instead of using a list of tracks, every station would hold a list of tracks associated with it. This also resulted in high coupling as Station was dependent on Tracks and Routes was dependent on Tracks. Therefore instead of using a list of objects I decided that route should instead store a list of Stations with each station holding a string of trackId's. This minimised coupling by removing dependencies for track.

Furthermore I realised I had also violated LSP, by defining recalculateSpeed in the Train superclass, meaning that PassengerClass which doesnt hold cargo also inherited this unnecessary behaviour. To fix this I created an interface carriesCargo so that Cargo and Bullet Train could implement recalculateSpeed instead.

Lastly I realised that TrainSystemData was redundant and that I could move my helper functions into TrainController class. I chose this approach rather than moving the helper functions such as findStationById into the respective entity class as this would increase coupling.