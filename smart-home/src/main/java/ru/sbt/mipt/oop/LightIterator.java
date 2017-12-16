package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LightIterator {

    private final SmartHome smartHome;
    private ArrayList<Light> light;
    private Collection<Room> rooms;
    private Iterator<Light> iterator;

    public LightIterator(SmartHome smartHome) {
        this.smartHome = smartHome;
        this.rooms = smartHome.getRooms();
        this.light = new ArrayList<>(getAllLights(rooms));
        this.iterator = light.iterator();

    }

    private Collection<Light> getAllLights(Collection<Room> rooms) {
        Collection<Light> lightArrayList = new ArrayList<>();
        for (Room room : rooms) {
            lightArrayList.addAll(room.getLights());
        }
        return lightArrayList;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Light next() {

        return iterator.next();

    }
}

