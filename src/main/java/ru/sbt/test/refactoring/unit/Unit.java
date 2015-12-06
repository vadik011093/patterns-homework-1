package ru.sbt.test.refactoring.unit;


import ru.sbt.test.refactoring.state.Orientation;

public abstract class Unit implements Movable, Turnable {

    protected Orientation orientation;
    protected Position position;

    public Unit() {
        this(Orientation.NORTH, new Position());
    }

    public Unit(Orientation orientation, Position position) {
        this.orientation = orientation;
        this.position = position;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void changeOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void turnClockwise() {
        orientation.turnClockwise(this);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void changePosition(Position position) {
        this.position = position;
    }

    @Override
    public void moveForward() {
        orientation.moveForwards(this);
    }

    public int getPositionX() {
        return position.getPositionX();
    }

    public int getPositionY() {
        return position.getPositionY();
    }

}