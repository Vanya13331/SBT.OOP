package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorScenarioRunner implements EventProcessor {
    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (event.getType() == SensorEventType.DOOR_CLOSED || event.getType() == SensorEventType.DOOR_OPEN) {
            for (Room room : home.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId()) && room.getName().equals("kitchen")) {
                        if (event.getType() == SensorEventType.DOOR_CLOSED) {
                            for (Room room1 : home.getRooms()) {
                                for (Door door1 : room1.getDoors()) {
                                    door1.setOpen(false);
                                }
                            }
                        } else {
                            for (Room room2 : home.getRooms()) {
                                for (Door door2 : room2.getDoors()) {
                                    door2.setOpen(true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
