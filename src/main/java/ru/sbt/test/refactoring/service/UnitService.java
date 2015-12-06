package ru.sbt.test.refactoring.service;

import ru.sbt.test.refactoring.FieldInfo;
import ru.sbt.test.refactoring.unit.Movable;

public class UnitService {

    public boolean checkCorrectPosition(Movable movable) {
        FieldInfo fieldInfo = FieldInfo.instance();
        return movable.getPosition().getPositionX() <= fieldInfo.getMaxXPosition() && movable.getPosition().getPositionY() <= fieldInfo.getMaxYPosition();
    }

}