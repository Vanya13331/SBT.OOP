package ru.sbt.mipt.oop;

public class AlarmSystemAlarm implements AlarmSystemInterface {
    AlarmSystem alarmSystem;
    AlarmSystemEnum state = AlarmSystemEnum.ALARM;

    public AlarmSystemAlarm(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
        alarmSystem.setCurrentState(new AlarmSystemOn(alarmSystem));
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {

    }

    @Override
    public void enterPassword(String password) {
        if (password.compareTo("12344321") == 0) {
            turnOff();
        } else {
            System.out.println(" Police is on the way to you. Write correct password or run as fast as you can");
        }
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
