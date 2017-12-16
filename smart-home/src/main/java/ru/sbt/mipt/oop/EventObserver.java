package ru.sbt.mipt.oop;


import java.util.ArrayList;
import java.util.List;

public class EventObserver {
    public List<EventProcessor> handlers = new ArrayList<>();

    public EventObserver(List<EventProcessor> handlers) {
        this.handlers = handlers;
    }

    public void randomObserve(SmartHome smartHome) {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            observeOnSensorEvent(smartHome, event);
            event = getNextSensorEvent();
        }
    }

    public void observeOnSensorEvent(SmartHome smartHome, SensorEvent event) {
        System.out.println("New event: " + event.getType());
        for (EventProcessor handler : handlers) {
            handler.handle(smartHome, event);
        }
    }


    public static SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}