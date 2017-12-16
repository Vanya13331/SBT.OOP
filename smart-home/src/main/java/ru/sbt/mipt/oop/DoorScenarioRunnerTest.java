package ru.sbt.mipt.oop;


import org.junit.jupiter.api.Test;



import static org.junit.Assert.assertFalse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.junit.Assert.assertTrue;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

class DoorScenarioRunnerTest {

    @Test
    public void testClosingOfTheDoor() {
        List<Light> lights1 = Arrays.asList(new Light("1", false), new Light("2", true));
        List<Door> doors1 = Collections.singletonList(new Door(true, "1"));
        Room kitchen = new Room(lights1, doors1, "kitchen");

        List<Light> lights2 = Collections.singletonList(new Light("3", true));
        List<Door> doors2 = Collections.singletonList(new Door(true, "2"));
        Room bathroom = new Room(lights2, doors2, "bathroom");

        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom));

            SensorEvent event = new SensorEvent(DOOR_CLOSED, doors1.get(0).getId());
            DoorScenarioRunner handler = new DoorScenarioRunner();

            handler.handle(smartHome, event);
            assertFalse(doors1.get(0).isOpen());

    }

    @Test
    public void testOpeningOfTheDoor() {
        DoorEventProcessor handler = new DoorEventProcessor();
        List<Light> lights1 = Arrays.asList(new Light("1", false), new Light("2", true));
        List<Door> doors1 = Collections.singletonList(new Door(false, "1"));
        Room kitchen = new Room(lights1, doors1, "kitchen");

        List<Light> lights2 = Collections.singletonList(new Light("3", true));
        List<Door> doors2 = Collections.singletonList(new Door(false, "2"));
        Room bathroom = new Room(lights2, doors2, "bathroom");

        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom));
        DoorIterator doorIterator = new DoorIterator(smartHome);
        while (doorIterator.hasNext()) {
            Door door = doorIterator.next();
            SensorEvent event = new SensorEvent(DOOR_OPEN, door.getId());

            handler.handle(smartHome, event);
            assertTrue(door.isOpen());
        }
    }

}