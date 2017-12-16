package ru.sbt.mipt.oop;


import java.io.IOException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {

        List<Light> lights1 = Arrays.asList(new Light("1", false), new Light("2", true), new Light("3", true));
        List<Door> doors1 = Collections.singletonList(new Door(false, "1"));
        Room bathroom = new Room(lights1, doors1, "bathroom");

        List<Light> lights2 = Arrays.asList(new Light("4", true), new Light("5", true));
        List<Door> doors2 = Arrays.asList(new Door(false, "2"),new Door(false, "3"));
        Room bedroom = new Room(lights2, doors2, "bedroom");

        List<Light> lights3 = Collections.singletonList(new Light("6", true));
        List<Door> doors3 = Collections.singletonList(new Door(true, "4"));
        Room kitchen = new Room(lights3, doors3, "kitchen");


        SmartHome smartHome = new SmartHome(Arrays.asList(bathroom,bedroom,kitchen));
        EventObserver observer = new EventObserver(Arrays.asList(new LightEventProcessor(), new DoorEventProcessor(), new DoorScenarioRunner()));
        observer.randomObserve(smartHome);

        new CodeToXml().save(smartHome);
    }

}
