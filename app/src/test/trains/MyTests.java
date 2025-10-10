package trains;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

import unsw.exceptions.InvalidRouteException;
import unsw.response.models.LoadInfoResponse;
import unsw.response.models.StationInfoResponse;
import unsw.response.models.TrainInfoResponse;
import unsw.trains.TrainsController;
import unsw.utils.Position;

// @Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
public class MyTests {
    
    @Test public void getPassengerStationInfoWithTrains() {
        TrainsController controller = new TrainsController();
        controller.createStation("s1", "DepotStation", 1.0, 1.0);
        controller.createStation("s2", "PassengerStation", 10.0, 10.0);
        controller.createStation("s3", "PassengerStation", 3.0, 19.0);
        controller.createTrack("t1-2", "s1", "s2");
        controller.createTrack("t2-3", "s2", "s3");

        // Make and check the passenger train was created.
        assertDoesNotThrow(() -> {
            controller.createTrain("train1", "PassengerTrain", "s2", List.of("s1", "s2", "s3"));
        });

        assertEquals(new TrainInfoResponse("train1", "s2", "PassengerTrain", new Position(10.0, 10.0),
                Collections.emptyList()), controller.getTrainInfo("train1"));

        assertEquals(
                new StationInfoResponse(
                    "s2",
                    "PassengerStation",
                    new Position(10.0, 10.0), 
                    List.of(new TrainInfoResponse("train1", "s2", "PassengerTrain", new Position(10.0, 10.0)))
                ),
                controller.getStationInfo("s2")
            );
    }

    @Test public void maxTrainsAtPassengerStation() {
        TrainsController controller = new TrainsController();
        controller.createStation("s1", "DepotStation", 1.0, 1.0);
        controller.createStation("s2", "PassengerStation", 10.0, 10.0);
        controller.createStation("s3", "PassengerStation", 3.0, 19.0);
        controller.createTrack("t1-2", "s1", "s2");
        controller.createTrack("t2-3", "s2", "s3");

        // Make and check the passenger train was created.
        assertDoesNotThrow(() -> {
            controller.createTrain("train1", "PassengerTrain", "s2", List.of("s1", "s2", "s3"));
        });

        assertEquals(new TrainInfoResponse("train1", "s2", "PassengerTrain", new Position(10.0, 10.0),
                Collections.emptyList()), controller.getTrainInfo("train1"));

        // Make and check the passenger train was created.
        assertDoesNotThrow(() -> {
            controller.createTrain("train2", "PassengerTrain", "s2", List.of("s1", "s2", "s3"));
        });

        assertEquals(new TrainInfoResponse("train2", "s2", "PassengerTrain", new Position(10.0, 10.0),
                Collections.emptyList()), controller.getTrainInfo("train2"));

        assertDoesNotThrow(() -> {
            controller.createTrain("train3", "PassengerTrain", "s2", List.of("s1", "s2", "s3"));
        });

        assertEquals(
            new StationInfoResponse(
                "s2",
                "PassengerStation",
                new Position(10.0, 10.0), 
                List.of(new TrainInfoResponse("train1", "s2", "PassengerTrain", new Position(10.0, 10.0)),
                        new TrainInfoResponse("train2", "s2", "PassengerTrain", new Position(10.0, 10.0))
                )
            ),
            controller.getStationInfo("s2")
        );
    }

    @Test public void trainMovementInboundStation() {
        TrainsController controller = new TrainsController();
        controller.createStation("s1", "CentralStation", 0.0, 0.0);
        controller.createStation("s2", "PassengerStation", 2.0, 0.0);
        controller.createTrack("t1-2", "s1", "s2");
        assertDoesNotThrow(() -> {
            controller.createTrain("train1", "BulletTrain", "s1", List.of("s1", "s2"));
        });

        // Check that trains was created.
        assertEquals(new Position(0.0, 0.0), controller.getTrainInfo("train1").getPosition());

        controller.simulate();

        // Check that Bullet train type has moved up to the next station.
        assertEquals(new Position(2.0, 0.0), controller.getTrainInfo("train1").getPosition());

        assertEquals(
            new TrainInfoResponse("train1", "s2", "BulletTrain", new Position(2.0, 0.0), Collections.emptyList()),
            controller.getTrainInfo("train1")
        );
    }

    @Test public void inboundTrainCannotMove() {
        TrainsController controller = new TrainsController();
        controller.createStation("s1", "CentralStation", 0.0, 0.0);
        controller.createStation("s2", "PassengerStation", 2.0, 0.0);
        controller.createTrack("t1-2", "s1", "s2");
        assertDoesNotThrow(() -> {
            controller.createTrain("train1", "BulletTrain", "s1", List.of("s1", "s2"));
            controller.createTrain("train2", "PassengerTrain", "s2", List.of("s2", "s1"));
            controller.createTrain("train3", "PassengerTrain", "s2", List.of("s2", "s1"));
        });

        // Check that trains was created.
        assertEquals(new Position(0.0, 0.0), controller.getTrainInfo("train1").getPosition());
        assertEquals(new Position(2.0, 0.0), controller.getTrainInfo("train2").getPosition());
        assertEquals(new Position(2.0, 0.0), controller.getTrainInfo("train3").getPosition());

        controller.simulate();

        // Check that Bullet train type has not moved to the next station since max capacity at s2
        assertEquals(new Position(0.0, 0.0), controller.getTrainInfo("train1").getPosition());

        assertEquals(
            new TrainInfoResponse("train1", "s1", "BulletTrain", new Position(0.0, 0.0), Collections.emptyList()),
            controller.getTrainInfo("train1")
        );
    }

    @Test public void BulletTrainCyclicalRoute() {
        TrainsController controller = new TrainsController();
        controller.createStation("s1", "CentralStation", 0.0, 0.0);
        controller.createStation("s2", "PassengerStation", 5.0, 0.0);
        controller.createStation("s3", "PassengerStation", 10.0, 0.0);

        controller.createTrack("t1-2", "s1", "s2");
        controller.createTrack("t2-3", "s2", "s3");
        controller.createTrack("t3-1", "s3", "s1");

        assertDoesNotThrow(() -> {
            controller.createTrain("train1", "BulletTrain", "s1", List.of("s1", "s2", "s3"));
        });

        assertEquals(new Position(0.0, 0.0), controller.getTrainInfo("train1").getPosition());

        controller.simulate();

        assertEquals(new Position(5.0, 0.0), controller.getTrainInfo("train1").getPosition());

        controller.simulate();

        assertEquals(new Position(10.0, 0.0), controller.getTrainInfo("train1").getPosition());

        controller.simulate();
        controller.simulate();
        assertEquals(new Position(0.0, 0.0), controller.getTrainInfo("train1").getPosition());
        assertEquals(
                new StationInfoResponse(
                    "s1",
                    "CentralStation",
                    new Position(0.0, 0.0), 
                    List.of(new TrainInfoResponse("train1", "s1", "BulletTrain", new Position(0.0, 0.0)))
                ),
                controller.getStationInfo("s1")
            );
    }


    @Test public void bulletTrainLinearRoute() {
        TrainsController controller = new TrainsController();
        controller.createStation("s1", "CentralStation", 0.0, 0.0);
        controller.createStation("s2", "PassengerStation", 5.0, 0.0);
        controller.createStation("s3", "PassengerStation", 10.0, 0.0);

        controller.createTrack("t1-2", "s1", "s2");
        controller.createTrack("t2-3", "s2", "s3");

        assertDoesNotThrow(() -> {
            controller.createTrain("train1", "BulletTrain", "s1", List.of("s1", "s2", "s3"));
        });

        assertEquals(new Position(0.0, 0.0), controller.getTrainInfo("train1").getPosition());
        controller.simulate();
        assertEquals(new Position(5.0, 0.0), controller.getTrainInfo("train1").getPosition());
        controller.simulate();
        assertEquals(new Position(10.0, 0.0), controller.getTrainInfo("train1").getPosition());

        
        assertEquals(
                new StationInfoResponse(
                    "s1",
                    "CentralStation",
                    new Position(0.0, 0.0), 
                    List.of()
                ),
                controller.getStationInfo("s1")
            );

        assertEquals(
                new StationInfoResponse(
                    "s2",
                    "PassengerStation",
                    new Position(5.0, 0.0), 
                    List.of()
                ),
                controller.getStationInfo("s2")
            );

        assertEquals(
                new StationInfoResponse(
                    "s3",
                    "PassengerStation",
                    new Position(10.0, 0.0), 
                    List.of(new TrainInfoResponse("train1", "s3", "BulletTrain", new Position(10.0, 0.0)))
                ),
                controller.getStationInfo("s3")
            );
    }

    @Test public void InvalidRouteForTrain() {
        TrainsController controller = new TrainsController();
        controller.createStation("s1", "CentralStation", 0.0, 0.0);
        controller.createStation("s2", "PassengerStation", 5.0, 0.0);
        controller.createStation("s3", "PassengerStation", 10.0, 0.0);

        controller.createTrack("t1-2", "s1", "s2");
        controller.createTrack("t2-3", "s2", "s3");
        controller.createTrack("t3-1", "s3", "s1");

        assertThrows(InvalidRouteException.class, () -> {
            controller.createTrain("train1", "PassengerTrain", "s1", List.of("s1", "s2", "s3"));
        });

        assertThrows(InvalidRouteException.class, () -> {
            controller.createTrain("train2", "CargoTrain", "s1", List.of("s1", "s2", "s3"));
        });

    }

    @Test
    public void testTrainPicksUpAndDropsPassenger() {
        TrainsController controller = new TrainsController();
        controller.createStation("s1", "PassengerStation", 0, 0);
        controller.createStation("s2", "PassengerStation", 4, 0);
        controller.createTrack("t1-2", "s1", "s2");
        controller.createPassenger("s1", "s2", "p1");
        assertDoesNotThrow(() -> {
            controller.createTrain("train1", "PassengerTrain", "s1", List.of("s1", "s2"));
        });

        // Check that the load was created at the station.
        assertEquals(List.of(new LoadInfoResponse("p1", "Passenger")), controller.getStationInfo("s1").getLoads());

        // After the first tick, the train with id t1 should have picked up the passenger.
        controller.simulate();
        assertEquals(new Position(2.0, 0.0), controller.getTrainInfo("train1").getPosition());
        assertEquals(0, controller.getStationInfo("s1").getLoads().size());
        assertEquals(List.of(new LoadInfoResponse("p1", "Passenger")), controller.getTrainInfo("train1").getLoads());

        controller.simulate();
        assertEquals(new Position(4.0, 0.0), controller.getTrainInfo("train1").getPosition());
        assertEquals(1, controller.getStationInfo("s2").getLoads().size());
         assertEquals(List.of(), controller.getTrainInfo("train1").getLoads());

    }
}
