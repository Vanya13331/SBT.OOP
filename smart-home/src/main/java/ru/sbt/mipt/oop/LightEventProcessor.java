package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {
    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (event.getType() != LIGHT_ON && event.getType() != LIGHT_OFF) return;
        LightIterator iterator = new LightIterator(home);
        while (iterator.hasNext()) {
            Light light = iterator.next();
            if (light.getId().equals(event.getObjectId())) {
                if (event.getType() == LIGHT_ON) {
                    light.setOn(true);
                    System.out.println("Light " + light.getId() + " on");
                } else if (event.getType() == LIGHT_OFF){
                    light.setOn(false);
                    System.out.println("Light " + light.getId() + " off");
                }
            }
        }
    }


}
