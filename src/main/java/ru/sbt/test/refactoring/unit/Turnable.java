package ru.sbt.test.refactoring.unit;

import ru.sbt.test.refactoring.state.Orientation;

public interface Turnable {

    public void turnClockwise();
    public void changeOrientation(Orientation orientation);
    public Orientation getOrientation();

}