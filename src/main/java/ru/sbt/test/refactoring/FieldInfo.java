package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.unit.Position;

public class FieldInfo {

    private final Position position;

    private FieldInfo(Position position) {
        this.position = position;
    }

    private static class FieldInfoSingleton {
        private static final FieldInfo fieldInfo = new FieldInfo(new Position(5, 5));
    }

    public static FieldInfo instance() {
        return FieldInfoSingleton.fieldInfo;
    }

    public int getMaxXPosition() {
        return position.getPositionX();
    }

    public int getMaxYPosition() {
        return position.getPositionY();
    }

}