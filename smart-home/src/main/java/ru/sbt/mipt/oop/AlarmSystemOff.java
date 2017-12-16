package ru.sbt.mipt.oop;

public class AlarmSystemOff implements AlarmSystemInterface {
    AlarmSystem alarmSystem;
    AlarmSystemEnum state = AlarmSystemEnum.OFF;

    public AlarmSystemOff(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
        alarmSystem.setCurrentState(new AlarmSystemOn(alarmSystem));
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        if (sensorEvent.getType() == SensorEventType.DOOR_CLOSED) {
            alarmSystem.setCurrentState(new AlarmSystemOn(alarmSystem));
        }
    }

    @Override
    public void enterPassword(String password) {
        alarmSystem.setCurrentState(new AlarmSystemWaitForPassword(alarmSystem));
        alarmSystem.enterPassword(password);
    }

    @Override
    public void turnOff() {
    }

    @Override
    public AlarmSystemEnum getState() {
        return state;
    }
}
