package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {

    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (event.getType() != DOOR_OPEN && event.getType() != DOOR_CLOSED) return;
        DoorIterator doorIterator = new DoorIterator(home);
        while (doorIterator.hasNext()) {
            Door door = doorIterator.next();
            if (door.getId().equals(event.getObjectId())) {
                if (event.getType() == DOOR_OPEN) {
                    door.setOpen(true);
                    System.out.println("Door " + door.getId() + " opened");
                }
                else if (event.getType() == DOOR_CLOSED){
                    door.setOpen(false);
                    System.out.println("Door " + door.getId() + " closed");
                }
            }
        }
    }
}
