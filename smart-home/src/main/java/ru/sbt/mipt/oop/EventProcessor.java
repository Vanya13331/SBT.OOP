package ru.sbt.mipt.oop;

public interface EventProcessor {
    void handle(SmartHome home, SensorEvent event);
}
