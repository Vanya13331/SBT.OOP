package ru.sbt.mipt.oop;

public interface AlarmSystemInterface {
    public void turnOn();
    public void onSensorEvent(SensorEvent sensorEvent);
    public void enterPassword(String password);
    public void turnOff();
    public AlarmSystemEnum getState();
}
