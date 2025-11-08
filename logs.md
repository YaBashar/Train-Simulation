[TOC]
#### Test-COMPILATION "Does the project compile?":
Yes
#### Test-LINTING "Is your project lint valid?": PASS
Yes
#### Test D-0 "DryRun Compilation": PASS
```
SUCCESS: Executed 0 tests in 553ms

SUCCESS
```
#### Test D-1 "DryRun testCreateStations": PASS
```
automarking.dryrun.TaskAExampleTests

  Test testCreateStations() PASSED

SUCCESS: Executed 1 tests in 455ms

SUCCESS
```
#### Test D-2 "DryRun testCreateTracks": PASS
```
automarking.dryrun.TaskAExampleTests

  Test testCreateTracks() PASSED

SUCCESS: Executed 1 tests in 364ms

SUCCESS
```
#### Test D-3 "DryRun testCreateTrains": PASS
```
automarking.dryrun.TaskAExampleTests

  Test testCreateTrains() PASSED

SUCCESS: Executed 1 tests in 431ms

SUCCESS
```
#### Test D-4 "DryRun testMultipleControllers": PASS
```
automarking.dryrun.TaskAExampleTests

  Test testMultipleControllers() PASSED

SUCCESS: Executed 1 tests in 444ms

SUCCESS
```
#### Test D-5 "DryRun testSimpleMovement": PASS
```
automarking.dryrun.TaskBExampleTests

  Test testSimpleMovement() PASSED

SUCCESS: Executed 1 tests in 466ms

SUCCESS
```
#### Test D-6 "DryRun testCreateDifferentPassengersAndCargo": PASS
```
automarking.dryrun.TaskBExampleTests

  Test testCreateDifferentPassengersAndCargo() PASSED

SUCCESS: Executed 1 tests in 433ms

SUCCESS
```
#### Test D-7 "DryRun testTrainPicksUpPassenger": PASS
```
automarking.dryrun.TaskBExampleTests

  Test testTrainPicksUpPassenger() PASSED

SUCCESS: Executed 1 tests in 415ms

SUCCESS
```
#### Test DM-1 "DryRun modified testCreateStations": PASS
```
automarking.dryrunModified.TaskAExampleTests

  Test testCreateStations() PASSED

SUCCESS: Executed 1 tests in 314ms

SUCCESS
```
#### Test DM-2 "DryRun modified testCreateTracks": PASS
```
automarking.dryrunModified.TaskAExampleTests

  Test testCreateTracks() PASSED

SUCCESS: Executed 1 tests in 307ms

SUCCESS
```
#### Test DM-3 "DryRun modified testCreateTrains": PASS
```
automarking.dryrunModified.TaskAExampleTests

  Test testCreateTrains() PASSED

SUCCESS: Executed 1 tests in 375ms

SUCCESS
```
#### Test DM-4 "DryRun modified testMultipleControllers": PASS
```
automarking.dryrunModified.TaskAExampleTests

  Test testMultipleControllers() PASSED

SUCCESS: Executed 1 tests in 382ms

SUCCESS
```
#### Test DM-5 "DryRun modified testSimpleMovement": PASS
```
automarking.dryrunModified.TaskBExampleTests

  Test testSimpleMovement() PASSED

SUCCESS: Executed 1 tests in 400ms

SUCCESS
```
#### Test DM-6 "DryRun modified testCreateDifferentPassengersAndCargo": PASS
```
automarking.dryrunModified.TaskBExampleTests

  Test testCreateDifferentPassengersAndCargo() PASSED

SUCCESS: Executed 1 tests in 363ms

SUCCESS
```
#### Test DM-7 "DryRun modified testTrainPicksUpPassenger": PASS
```
automarking.dryrunModified.TaskBExampleTests

  Test testTrainPicksUpPassenger() PASSED

SUCCESS: Executed 1 tests in 462ms

SUCCESS
```
#### Test A-1-1 "Test create train on linear route": PASS
```
automarking.taskA.BasicCreationTest

  Test Test create train on linear route PASSED

SUCCESS: Executed 1 tests in 451ms

SUCCESS
```
#### Test A-1-2 "Test create train on cyclical routes": PASS
```
automarking.taskA.BasicCreationTest

  Test Test create train on cyclical routes PASSED

SUCCESS: Executed 1 tests in 429ms

SUCCESS
```
#### Test A-1-3 "Test create train on more complex cyclical routes": PASS
```
automarking.taskA.BasicCreationTest

  Test Test create train on more complex cyclical routes PASSED

SUCCESS: Executed 1 tests in 341ms

SUCCESS
```
#### Test A-1-4 "Test create train on more complex linear routes": PASS
```
automarking.taskA.BasicCreationTest

  Test Test create train on more complex linear routes PASSED

SUCCESS: Executed 1 tests in 474ms

SUCCESS
```
#### Test A-1-5 "Test listStationIds": PASS
```
automarking.taskA.BasicCreationTest

  Test Test listStationIds PASSED

SUCCESS: Executed 1 tests in 340ms

SUCCESS
```
#### Test A-1-6 "Test listTrackIds": PASS
```
automarking.taskA.BasicCreationTest

  Test Test listTrackIds PASSED

SUCCESS: Executed 1 tests in 417ms

SUCCESS
```
#### Test A-1-7 "Test listTrainIDs": PASS
```
automarking.taskA.BasicCreationTest

  Test Test listTrainIDs PASSED

SUCCESS: Executed 1 tests in 524ms

SUCCESS
```
#### Test A-1-8 "Test tracks function bidirectionally for linear tracks": PASS
```
automarking.taskA.BasicCreationTest

  Test Test tracks function bidirectionally for linear tracks PASSED

SUCCESS: Executed 1 tests in 514ms

SUCCESS
```
#### Test A-1-9 "Test tracks function bidirectionally for cyclical routes": PASS
```
automarking.taskA.BasicCreationTest

  Test Test tracks function bidirectionally for cyclical routes PASSED

SUCCESS: Executed 1 tests in 480ms

SUCCESS
```
#### Test B-2-1 "Test passenger creation at passenger stations": PASS
```
automarking.taskB.LoadsTests

  Test Test passenger creation at passenger stations PASSED

SUCCESS: Executed 1 tests in 424ms

SUCCESS
```
#### Test B-2-2 "Test cargo creation at cargo stations": PASS
```
automarking.taskB.LoadsTests

  Test Test cargo creation at cargo stations PASSED

SUCCESS: Executed 1 tests in 603ms

SUCCESS
```
#### Test B-2-3 "Test cargo and passenger creation at central stations": PASS
```
automarking.taskB.LoadsTests

  Test Test cargo and passenger creation at central stations PASSED

SUCCESS: Executed 1 tests in 704ms

SUCCESS
```
#### Test B-2-4 "Test load taken to destination on linear route": PASS
```
automarking.taskB.LoadsTests

  Test Test load taken to destination on linear route PASSED

SUCCESS: Executed 1 tests in 387ms

SUCCESS
```
#### Test B-2-5 "Test loads taken to destination on cyclical route": FAIL
```
automarking.taskB.LoadsTests

  Test Test loads taken to destination on cyclical route FAILED

  org.opentest4j.AssertionFailedError: expected: <Position [x=3.0, y=0.0]> but was: <Position [x=2.0, y=1.0]>
      at app//automarking.taskB.LoadsTests.loadTakenOnCyclicalRoute(LoadsTests.java:155)


FAILURE: Executed 1 tests in 538ms (1 failed)

FAILURE
```
#### Test B-2-6 "Test only loads that will can be delivered will be picked up on linear route": FAIL
```
automarking.taskB.LoadsTests

  Test Test only loads that will can be delivered will be picked up on linear route FAILED

  org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
      at app//automarking.taskB.LoadsTests.correctLoadsTaken(LoadsTests.java:196)


FAILURE: Executed 1 tests in 469ms (1 failed)

FAILURE
```
#### Test B-2-7 "Test only loads that will can be delivered will be picked up on cyclical route": FAIL
```
automarking.taskB.LoadsTests

  Test Test only loads that will can be delivered will be picked up on cyclical route FAILED

  org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
      at app//automarking.taskB.LoadsTests.correctLoadsTakenCyclical(LoadsTests.java:226)


FAILURE: Executed 1 tests in 421ms (1 failed)

FAILURE
```
#### Test B-2-8 "Test PassengerTrain only picks up passengers": PASS
```
automarking.taskB.LoadsTests

  Test Test PassengerTrain only picks up passengers PASSED

SUCCESS: Executed 1 tests in 429ms

SUCCESS
```
#### Test B-2-9 "Test CargoTrain only picks up cargo": PASS
```
automarking.taskB.LoadsTests

  Test Test CargoTrain only picks up cargo PASSED

SUCCESS: Executed 1 tests in 418ms

SUCCESS
```
#### Test B-2-10 "Test CargoTrain only picks up cargo": PASS
```
automarking.taskB.LoadsTests

  Test Test CargoTrain only picks up cargo PASSED

SUCCESS: Executed 1 tests in 429ms

SUCCESS
```
#### Test B-2-11 "Test load capacity of passenger trains": PASS
```
automarking.taskB.LoadsTests

  Test Test load capacity of passenger trains PASSED

SUCCESS: Executed 1 tests in 394ms

SUCCESS
```
#### Test B-2-12 "Test load capacity of cargo trains": FAIL
```
automarking.taskB.LoadsTests

  Test Test load capacity of cargo trains FAILED

  org.opentest4j.AssertionFailedError: expected: <45> but was: <0>
      at app//automarking.taskB.LoadsTests.testCapacityOfCargoTrains(LoadsTests.java:361)


FAILURE: Executed 1 tests in 438ms (1 failed)

FAILURE
```
#### Test B-2-13 "Test load capacity of bullet trains": FAIL
```
automarking.taskB.LoadsTests

  Test Test load capacity of bullet trains FAILED

  org.opentest4j.AssertionFailedError: expected: <45> but was: <0>
      at app//automarking.taskB.LoadsTests.testCapacityOfBulletTrains(LoadsTests.java:388)


FAILURE: Executed 1 tests in 486ms (1 failed)

FAILURE
```
#### Test B-2-14 "Test slowing down of cargo train with loads": FAIL
```
automarking.taskB.LoadsTests

  Test Test slowing down of cargo train with loads FAILED

  org.opentest4j.AssertionFailedError: expected: <Position [x=0.0, y=2.4]> but was: <Position [x=0.0, y=2.4512184206626406]>
      at app//automarking.taskB.LoadsTests.testLoadSlowingCargoTrains(LoadsTests.java:418)


FAILURE: Executed 1 tests in 408ms (1 failed)

FAILURE
```
#### Test B-2-15 "Test slowing down of bullet train with loads": FAIL
```
automarking.taskB.LoadsTests

  Test Test slowing down of bullet train with loads FAILED

  org.opentest4j.AssertionFailedError: expected: <Position [x=0.0, y=4.0]> but was: <Position [x=0.0, y=4.085364034437736]>
      at app//automarking.taskB.LoadsTests.testLoadSlowingBulletTrains(LoadsTests.java:448)


FAILURE: Executed 1 tests in 431ms (1 failed)

FAILURE
```
#### Test B-2-16 "Test priority of loading": FAIL
```
automarking.taskB.LoadsTests

  Test Test priority of loading FAILED

  org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
      at app//automarking.taskB.LoadsTests.priorityOfLoading(LoadsTests.java:488)


FAILURE: Executed 1 tests in 433ms (1 failed)

FAILURE
```
#### Test B-1-1 "Test passenger train movement on a simple linear route with two stations": FAIL
```
automarking.taskB.MovementTests

  Test Test passenger train movement on a simple linear route with two stations FAILED

  org.opentest4j.AssertionFailedError: expected: <t1-2> but was: <s1>
      at app//automarking.taskB.MovementTests.passengerTrainMovement(MovementTests.java:40)


FAILURE: Executed 1 tests in 452ms (1 failed)

FAILURE
```
#### Test B-1-2 "Test cargo train movement on a simple linear route with two stations": FAIL
```
automarking.taskB.MovementTests

  Test Test cargo train movement on a simple linear route with two stations FAILED

  org.opentest4j.AssertionFailedError: expected: <t1-2> but was: <s1>
      at app//automarking.taskB.MovementTests.cargoTrainMovement(MovementTests.java:67)


FAILURE: Executed 1 tests in 378ms (1 failed)

FAILURE
```
#### Test B-1-3 "Test bullet train movement on a simple linear route with two stations": FAIL
```
automarking.taskB.MovementTests

  Test Test bullet train movement on a simple linear route with two stations FAILED

  org.opentest4j.AssertionFailedError: expected: <t1-2> but was: <s1>
      at app//automarking.taskB.MovementTests.bulletTrainMovement(MovementTests.java:95)


FAILURE: Executed 1 tests in 456ms (1 failed)

FAILURE
```
#### Test B-1-4 "Test train docks at station from being inbound on a track prior": PASS
```
automarking.taskB.MovementTests

  Test Test train docks at station from being inbound on a track prior PASSED

SUCCESS: Executed 1 tests in 482ms

SUCCESS
```
#### Test B-1-5 "Test train docks at station from being inbound on a station prior": PASS
```
automarking.taskB.MovementTests

  Test Test train docks at station from being inbound on a station prior PASSED

SUCCESS: Executed 1 tests in 486ms

SUCCESS
```
#### Test B-1-6 "Test bullet train moving through a two cycles on a simple cyclical route with four stations": FAIL
```
automarking.taskB.MovementTests

  Test Test bullet train moving through a two cycles on a simple cyclical route with four stations FAILED

  org.opentest4j.AssertionFailedError: expected: <t1-2> but was: <s1>
      at app//automarking.taskB.MovementTests.bulletTrainCyclicalMovement(MovementTests.java:173)


FAILURE: Executed 1 tests in 487ms (1 failed)

FAILURE
```
#### Test B-1-7 "Test passenger train move to end of route then reverse direction back to start": FAIL
```
automarking.taskB.MovementTests

  Test Test passenger train move to end of route then reverse direction back to start FAILED

  org.opentest4j.AssertionFailedError: expected: <t1-2> but was: <s1>
      at app//automarking.taskB.MovementTests.passengerTrainLinearReverseMovement(MovementTests.java:227)


FAILURE: Executed 1 tests in 498ms (1 failed)

FAILURE
```
#### Test B-1-8 "Test correct movement of a train created mid way through a linear route": FAIL
```
automarking.taskB.MovementTests

  Test Test correct movement of a train created mid way through a linear route FAILED

  org.opentest4j.AssertionFailedError: expected: <Position [x=10.0, y=0.0]> but was: <Position [x=5.0, y=0.0]>
      at app//automarking.taskB.MovementTests.trainMovementWhenCreatedMidLinearRoute(MovementTests.java:271)


FAILURE: Executed 1 tests in 431ms (1 failed)

FAILURE
```
#### Test B-1-9 "Test correct movement of a train created mid way through a cyclical route": FAIL
```
automarking.taskB.MovementTests

  Test Test correct movement of a train created mid way through a cyclical route FAILED

  org.opentest4j.AssertionFailedError: expected: <Position [x=0.0, y=5.0]> but was: <Position [x=5.0, y=0.0]>
      at app//automarking.taskB.MovementTests.trainMovementWhenCreatedMidCyclicalRoute(MovementTests.java:319)


FAILURE: Executed 1 tests in 406ms (1 failed)

FAILURE
```
#### Test B-1-10 "Test linear movement with a range of differing distances between stations": FAIL
```
automarking.taskB.MovementTests

  Test Test linear movement with a range of differing distances between stations FAILED

  org.opentest4j.AssertionFailedError: expected: <t3-4> but was: <s3>
      at app//automarking.taskB.MovementTests.linearMovementDifferentRanges(MovementTests.java:381)


FAILURE: Executed 1 tests in 443ms (1 failed)

FAILURE
```
#### Test B-1-11 "Test prioritisation with 4 inbound trains, trying to docking an empty station with 2 train capacity": PASS
```
automarking.taskB.MovementTests

  Test Test prioritisation with 4 inbound trains, trying to docking an empty station with 2 train capacity PASSED

SUCCESS: Executed 1 tests in 438ms

SUCCESS
```
#### Test B-1-12 "Test trains prioritised, causing a train at a station from a prior tick to block an inbound train": PASS
```
automarking.taskB.MovementTests

  Test Test trains prioritised, causing a train at a station from a prior tick to block an inbound train PASSED

SUCCESS: Executed 1 tests in 454ms

SUCCESS
```
#### Test B-1-13 "Test simple deadlock": FAIL
```
automarking.taskB.MovementTests

  Test Test simple deadlock FAILED

  org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
      at app//automarking.taskB.MovementTests.trainsDeadlockedTest(MovementTests.java:506)


FAILURE: Executed 1 tests in 460ms (1 failed)

FAILURE
```
#### Test B-1-14 "Test complex deadlock": FAIL
```
automarking.taskB.MovementTests

  Test Test complex deadlock FAILED

  org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
      at app//automarking.taskB.MovementTests.allTrainsDeadlockedTest(MovementTests.java:566)


FAILURE: Executed 1 tests in 302ms (1 failed)

FAILURE
```
#### Test B-3-1 "Test perishable cargo picked up in linear route": FAIL
```
automarking.taskB.PerishableLoadTest

  Test Test perishable cargo picked up in linear route FAILED

  org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
      at app//automarking.taskB.PerishableLoadTest.testPerishableLoadPickedUp(PerishableLoadTest.java:46)


FAILURE: Executed 1 tests in 256ms (1 failed)

FAILURE
```
#### Test B-3-2 "Test perishable cargo picked up in cyclical route": FAIL
```
automarking.taskB.PerishableLoadTest

  Test Test perishable cargo picked up in cyclical route FAILED

  org.opentest4j.AssertionFailedError: expected: <0> but was: <2>
      at app//automarking.taskB.PerishableLoadTest.testPickedUpInCyclicalRoute(PerishableLoadTest.java:106)


FAILURE: Executed 1 tests in 345ms (1 failed)

FAILURE
```
#### Test B-3-3 "Test perishable cargo not PICKED up in linear route": FAIL
```
automarking.taskB.PerishableLoadTest

  Test Test perishable cargo not PICKED up in linear route FAILED

  org.opentest4j.AssertionFailedError: expected: <3> but was: <4>
      at app//automarking.taskB.PerishableLoadTest.testPerishableLoadNotPickedUp(PerishableLoadTest.java:137)


FAILURE: Executed 1 tests in 403ms (1 failed)

FAILURE
```
#### Test B-3-4 "Test perishable cargo not PICKED up in cyclical route": FAIL
```
automarking.taskB.PerishableLoadTest

  Test Test perishable cargo not PICKED up in cyclical route FAILED

  org.opentest4j.AssertionFailedError: expected: <4> but was: <5>
      at app//automarking.taskB.PerishableLoadTest.testNotPickedUpInCyclicalRoute(PerishableLoadTest.java:182)


FAILURE: Executed 1 tests in 392ms (1 failed)

FAILURE
```
#### Test B-3-5 "Test perishable cargo pickp accounts for cargo slow down": PASS
```
automarking.taskB.PerishableLoadTest

  Test Test perishable cargo pickp accounts for cargo slow down PASSED

SUCCESS: Executed 1 tests in 429ms

SUCCESS
```
#### Test B-3-6 "Test perishable cargo pickp accounts for cargo slow down - 2": FAIL
```
automarking.taskB.PerishableLoadTest

  Test Test perishable cargo pickp accounts for cargo slow down - 2 FAILED

  org.opentest4j.AssertionFailedError: expected: <Position [x=0.0, y=10.0]> but was: <Position [x=0.0, y=5.739375]>
      at app//automarking.taskB.PerishableLoadTest.pickupLaterSlowdown(PerishableLoadTest.java:243)


FAILURE: Executed 1 tests in 406ms (1 failed)

FAILURE
```
#### Test B-3-7 "Test perishable cargo accounts for reversed linear routes": FAIL
```
automarking.taskB.PerishableLoadTest

  Test Test perishable cargo accounts for reversed linear routes FAILED

  org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
      at app//automarking.taskB.PerishableLoadTest.perishableCargoReverseSectionOfLinearRoute(PerishableLoadTest.java:300)


FAILURE: Executed 1 tests in 389ms (1 failed)

FAILURE
```
#### Test C-1-1 "Test simple breaking of track": FAIL
```
automarking.taskC.BreakingAndRepairing

  Test Test simple breaking of track FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.BreakingAndRepairing.testSimpleBreakingOfTrackWithOneTrain(BreakingAndRepairing.java:42)


FAILURE: Executed 1 tests in 418ms (1 failed)

FAILURE
```
#### Test C-1-2 "Test simple repairing of track": FAIL
```
automarking.taskC.BreakingAndRepairing

  Test Test simple repairing of track FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.BreakingAndRepairing.simpleRepairingofTrack(BreakingAndRepairing.java:77)


FAILURE: Executed 1 tests in 447ms (1 failed)

FAILURE
```
#### Test C-1-3 "Test damage on track increases with load weights": FAIL
```
automarking.taskC.BreakingAndRepairing

  Test Test damage on track increases with load weights FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.BreakingAndRepairing.testUsesDurabilityBasedOnLoadWeight(BreakingAndRepairing.java:131)


FAILURE: Executed 1 tests in 362ms (1 failed)

FAILURE
```
#### Test C-1-4 "Test damage on track increases with load weights across multiple stations": FAIL
```
automarking.taskC.BreakingAndRepairing

  Test Test damage on track increases with load weights across multiple stations FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.BreakingAndRepairing.damageOnTrackAcrossMultipleTracks(BreakingAndRepairing.java:173)


FAILURE: Executed 1 tests in 404ms (1 failed)

FAILURE
```
#### Test C-1-5 "Test trains can't move onto broken tracks": FAIL
```
automarking.taskC.BreakingAndRepairing

  Test Test trains can't move onto broken tracks FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.BreakingAndRepairing.trainsCantMoveOnBrokenTracks(BreakingAndRepairing.java:220)


FAILURE: Executed 1 tests in 441ms (1 failed)

FAILURE
```
#### Test C-1-6 "Test trains get stuck on broken track when it breaks": FAIL
```
automarking.taskC.BreakingAndRepairing

  Test Test trains get stuck on broken track when it breaks FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.BreakingAndRepairing.trains(BreakingAndRepairing.java:289)


FAILURE: Executed 1 tests in 401ms (1 failed)

FAILURE
```
#### Test C-1-7 "On the tick a track should break, all trains should move": FAIL
```
automarking.taskC.BreakingAndRepairing

  Test On the tick a track should break, all trains should move FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.BreakingAndRepairing.testAllTrainsMoveInTickBeforeBreaking(BreakingAndRepairing.java:345)


FAILURE: Executed 1 tests in 404ms (1 failed)

FAILURE
```
#### Test C-1-8 "Test trains stuck at stations don't take loads": FAIL
```
automarking.taskC.BreakingAndRepairing

  Test Trains stuck at stations shouldn't take loads FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.BreakingAndRepairing.trainsStcuukDontTakeLoads(BreakingAndRepairing.java:382)


FAILURE: Executed 1 tests in 431ms (1 failed)

FAILURE
```
#### Test C-2-1 "Repair train doesn't damage a normal track": FAIL
```
automarking.taskC.RepairTrainAndMechanics

  Test Repair train doesn't damage a normal track FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Train.getLoadsOnTrain()" because "findTrain" is null
      at automarking.taskC.RepairTrainAndMechanics.repairTrainDoesntDamageNormalTrack(RepairTrainAndMechanics.java:39)


FAILURE: Executed 1 tests in 437ms (1 failed)

FAILURE
```
#### Test C-2-2 "Repair train doesn't damage a breakable track": FAIL
```
automarking.taskC.RepairTrainAndMechanics

  Test Repair train doesn't damage a breakable track FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Train.getLoadsOnTrain()" because "findTrain" is null
      at automarking.taskC.RepairTrainAndMechanics.repairTrainDoesntDamageBreakableTrack(RepairTrainAndMechanics.java:64)


FAILURE: Executed 1 tests in 400ms (1 failed)

FAILURE
```
#### Test C-2-3 "Repair train can move on a broken track": FAIL
```
automarking.taskC.RepairTrainAndMechanics

  Test Repair train can move on a broken track FAILED

  java.lang.NullPointerException
      at automarking.taskC.RepairTrainAndMechanics.repairTrainMoveOnBrokenTrack(RepairTrainAndMechanics.java:92)


FAILURE: Executed 1 tests in 534ms (1 failed)

FAILURE
```
#### Test C-2-4 "Repair train picks up passengers and mechanics": FAIL
```
automarking.taskC.RepairTrainAndMechanics

  Test Repair train picks up passengers and mechanics FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Train.getLoadsOnTrain()" because "findTrain" is null
      at automarking.taskC.RepairTrainAndMechanics.repairTrainPicksUpPassengersAndMechanics(RepairTrainAndMechanics.java:141)


FAILURE: Executed 1 tests in 489ms (1 failed)

FAILURE
```
#### Test C-2-5 "Repair train with one mechanic boosts repair rate": FAIL
```
automarking.taskC.RepairTrainAndMechanics

  Test Repair train with one mechanic boosts repair rate FAILED

  java.lang.NullPointerException
      at automarking.taskC.RepairTrainAndMechanics.repairTrainOneMechanic(RepairTrainAndMechanics.java:168)


FAILURE: Executed 1 tests in 353ms (1 failed)

FAILURE
```
#### Test C-2-6 "Repair train with boosts repair rate when inbound to next station": FAIL
```
automarking.taskC.RepairTrainAndMechanics

  Test Repair train w/ mechanics boots inbound from track FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.RepairTrainAndMechanics.repairBoostWHenInbound(RepairTrainAndMechanics.java:191)


FAILURE: Executed 1 tests in 551ms (1 failed)

FAILURE
```
#### Test C-2-7 "Repair train with three mechanics boosts repair rate": FAIL
```
automarking.taskC.RepairTrainAndMechanics

  Test Repair train with three mechanics boosts repair rate FAILED

  java.lang.NullPointerException
      at automarking.taskC.RepairTrainAndMechanics.repairTrainThreeMechanics(RepairTrainAndMechanics.java:234)


FAILURE: Executed 1 tests in 341ms (1 failed)

FAILURE
```
#### Test C-2-8 "Repair train with mechanics inbound": FAIL
```
automarking.taskC.RepairTrainAndMechanics

  Test Repair train w/ mechanics boots inbound from station FAILED

  java.lang.NullPointerException: Cannot invoke "unsw.trains.Track.getFromStationId()" because "findTrack" is null
      at automarking.taskC.RepairTrainAndMechanics.inboundFromStationMechanics(RepairTrainAndMechanics.java:260)


FAILURE: Executed 1 tests in 474ms (1 failed)

FAILURE
```
## Summary

- D-0: PASS
- D-1: PASS
- D-2: PASS
- D-3: PASS
- D-4: PASS
- D-5: PASS
- D-6: PASS
- D-7: PASS
- DM-1: PASS
- DM-2: PASS
- DM-3: PASS
- DM-4: PASS
- DM-5: PASS
- DM-6: PASS
- DM-7: PASS
- A-1-1: PASS
- A-1-2: PASS
- A-1-3: PASS
- A-1-4: PASS
- A-1-5: PASS
- A-1-6: PASS
- A-1-7: PASS
- A-1-8: PASS
- A-1-9: PASS
- B-2-1: PASS
- B-2-2: PASS
- B-2-3: PASS
- B-2-4: PASS
- B-2-5: FAIL
- B-2-6: FAIL
- B-2-7: FAIL
- B-2-8: PASS
- B-2-9: PASS
- B-2-10: PASS
- B-2-11: PASS
- B-2-12: FAIL
- B-2-13: FAIL
- B-2-14: FAIL
- B-2-15: FAIL
- B-2-16: FAIL
- B-1-1: FAIL
- B-1-2: FAIL
- B-1-3: FAIL
- B-1-4: PASS
- B-1-5: PASS
- B-1-6: FAIL
- B-1-7: FAIL
- B-1-8: FAIL
- B-1-9: FAIL
- B-1-10: FAIL
- B-1-11: PASS
- B-1-12: PASS
- B-1-13: FAIL
- B-1-14: FAIL
- B-3-1: FAIL
- B-3-2: FAIL
- B-3-3: FAIL
- B-3-4: FAIL
- B-3-5: PASS
- B-3-6: FAIL
- B-3-7: FAIL
- C-1-1: FAIL
- C-1-2: FAIL
- C-1-3: FAIL
- C-1-4: FAIL
- C-1-5: FAIL
- C-1-6: FAIL
- C-1-7: FAIL
- C-1-8: FAIL
- C-2-1: FAIL
- C-2-2: FAIL
- C-2-3: FAIL
- C-2-4: FAIL
- C-2-5: FAIL
- C-2-6: FAIL
- C-2-7: FAIL
- C-2-8: FAIL
