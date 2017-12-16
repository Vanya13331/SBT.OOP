package ru.sbt.mipt.oop;

public class Light implements Actionable{
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public String getId() {
        return this.id;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }

    @Override
    public void executeAction(Action action) {
            action.execute(this);
    }
}
