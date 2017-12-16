package ru.sbt.mipt.oop;

public class AlarmSystem {
    private AlarmSystemInterface alarmSystemInterface;
    private AlarmSystemEnum state;

    public AlarmSystem() {
        this.alarmSystemInterface = new AlarmSystemOff(this);
    }

    public void setCurrentState(AlarmSystemInterface alarmSystemInterface) {
        this.alarmSystemInterface = alarmSystemInterface;
    }

    public void turnOn() {
        alarmSystemInterface.turnOn();
    }

    public void onSensorEvent(SensorEvent sensorEvent) {
        alarmSystemInterface.onSensorEvent(sensorEvent);
    }

    public void enterPassword(String password) {
        alarmSystemInterface.enterPassword(password);
    }

    public void turnOff() {
        alarmSystemInterface.turnOff();
    }

    public AlarmSystemEnum getState() {
        return alarmSystemInterface.getState();
    }
}
