package ru.sbt.mipt.oop;

public class AlarmSystemOn implements AlarmSystemInterface {
    AlarmSystem alarmSystem;
    AlarmSystemEnum state = AlarmSystemEnum.ON;

    public AlarmSystemOn(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        if (sensorEvent.getType() == SensorEventType.DOOR_OPEN) {
            alarmSystem.setCurrentState(new AlarmSystemOff(alarmSystem));
        }
    }

    @Override
    public void enterPassword(String password) {
        alarmSystem.setCurrentState(new AlarmSystemWaitForPassword(alarmSystem));
    }

    @Override
    public void turnOff() {
        alarmSystem.setCurrentState(new AlarmSystemOff(alarmSystem));
    }

    @Override
    public AlarmSystemEnum getState() {
        return state;
    }
}
