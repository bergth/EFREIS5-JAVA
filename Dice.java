package com.company;

public class Dice {
    private
        int value;
        boolean keep;

    public Dice(){};

    public void setValue(int value) {
            this.value = value;
        }

    public void setKeep(boolean keep) {
        this.keep = keep;
    }

    public boolean isKeep() {
        return keep;
    }

    public int getValue() {
        return value;
    }
}
