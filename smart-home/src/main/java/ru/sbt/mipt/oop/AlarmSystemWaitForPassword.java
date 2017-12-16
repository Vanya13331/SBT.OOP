package ru.sbt.mipt.oop;

public class AlarmSystemWaitForPassword implements AlarmSystemInterface {
    AlarmSystem alarmSystem;
    AlarmSystemEnum state = AlarmSystemEnum.WAIT_FOR_PASSWORD;

    public AlarmSystemWaitForPassword(AlarmSystem alarmSystem) {
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
            alarmSystem.setCurrentState(new AlarmSystemOff(alarmSystem));
        } else {
            alarmSystem.setCurrentState(new AlarmSystemAlarm(alarmSystem));
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
