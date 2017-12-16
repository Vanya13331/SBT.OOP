package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlarmSystemTest {
    @Test
    public void testSystem() {
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(AlarmSystemEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void testSystemIsOn() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemEnum.ON, alarmSystem.getState());
    }

    @Test
    public void testSystemCorrectPassword() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.enterPassword("12344321");
        assertEquals(AlarmSystemEnum.OFF, alarmSystem.getState());

    }

    @Test
    public void testSystemIncorrectPassword() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.enterPassword("12131");
        assertEquals(AlarmSystemEnum.ALARM, alarmSystem.getState());
    }

    @Test
    public void testTurnOffAlarmAfterCorrectPassword() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.enterPassword("123654");
        assertEquals(AlarmSystemEnum.ALARM, alarmSystem.getState());
        alarmSystem.enterPassword("12344321");
        assertEquals(AlarmSystemEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void testSystemDoesNothingWhenInOffStateWeTryToDoOff() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOff();
        assertEquals(AlarmSystemEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void testSystemIsOffWhenDoorIsOpened() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_OPEN, "1");
        alarmSystem.onSensorEvent(sensorEvent);
        assertEquals(AlarmSystemEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void testSystemIsOnWhenDoorIsClosed() {
        AlarmSystem alarmSystem = new AlarmSystem();
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
        alarmSystem.onSensorEvent(sensorEvent);
        assertEquals(AlarmSystemEnum.ON, alarmSystem.getState());
    }

}