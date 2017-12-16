package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertTrue;


class EventObserverTest {

    @Test
    public void testObserve(){
        List<Light> lights1 = Arrays.asList(new Light("1", false), new Light("2", true), new Light("3", true));
        List<Door> doors1 = Collections.singletonList(new Door(false, "1"));
        Room bathroom = new Room(lights1, doors1, "bathroom");

        SmartHome smartHome = new SmartHome(Arrays.asList(bathroom));
        EventObserver observer = new EventObserver(Arrays.asList(new DoorEventProcessor()));
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_OPEN,doors1.get(0).getId());
        observer.observeOnSensorEvent(smartHome,sensorEvent);
        assertTrue(doors1.get(0).isOpen());

    }

}