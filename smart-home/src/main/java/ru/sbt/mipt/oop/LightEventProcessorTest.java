package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

class LightEventProcessorTest {
    @Test
    public void testLightOn() {
        LightEventProcessor handler = new LightEventProcessor();
        List<Light> lights1 = Arrays.asList(new Light("1", false), new Light("2", false));
        List<Door> doors1 = Collections.singletonList(new Door(false, "1"));
        Room kitchen = new Room(lights1, doors1, "kitchen");

        List<Light> lights2 = Collections.singletonList(new Light("3", false));
        List<Door> doors2 = Collections.singletonList(new Door(false, "2"));
        Room bathroom = new Room(lights2, doors2, "bathroom");

        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom));
        LightIterator lightIterator = new LightIterator(smartHome);
        while (lightIterator.hasNext()) {
            Light light = lightIterator.next();
            SensorEvent event = new SensorEvent(LIGHT_ON, light.getId());

            handler.handle(smartHome, event);
            assertTrue(light.isOn());
        }
    }

    @Test
    public void testLightOff() {
        LightEventProcessor handler = new LightEventProcessor();
        List<Light> lights1 = Arrays.asList(new Light("1", true), new Light("2", true));
        List<Door> doors1 = Collections.singletonList(new Door(false, "1"));
        Room kitchen = new Room(lights1, doors1, "kitchen");

        List<Light> lights2 = Collections.singletonList(new Light("3", true));
        List<Door> doors2 = Collections.singletonList(new Door(false, "2"));
        Room bathroom = new Room(lights2, doors2, "bathroom");

        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom));
        LightIterator lightIterator = new LightIterator(smartHome);
        while (lightIterator.hasNext()) {
            Light light = lightIterator.next();
            SensorEvent event = new SensorEvent(LIGHT_OFF, light.getId());

            handler.handle(smartHome, event);
            assertFalse(light.isOn());
        }
    }

}