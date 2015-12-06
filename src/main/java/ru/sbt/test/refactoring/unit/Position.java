package ru.sbt.test.refactoring.unit;

public class Position {

    private int positionX;
    private int positionY;

    public Position() {
        this(0, 0);
    }

    public Position(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void moveX(int positionX) {
        this.positionX += positionX;
    }

    public void moveY(int positionY) {
        this.positionY += positionY;
    }

}