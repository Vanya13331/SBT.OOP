package ru.sbt.mipt.oop;

public class Door implements Actionable {
    private Room room;
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}
