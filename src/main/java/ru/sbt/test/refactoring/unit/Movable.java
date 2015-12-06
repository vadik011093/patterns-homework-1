package ru.sbt.test.refactoring.unit;

import javafx.geometry.Pos;

public interface Movable {

    public void moveForward();
    public void changePosition(Position position);
    public Position getPosition();

}
