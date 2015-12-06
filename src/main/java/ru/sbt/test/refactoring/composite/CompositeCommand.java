package ru.sbt.test.refactoring.composite;

import ru.sbt.test.refactoring.command.UnitCommand;

public interface CompositeCommand extends UnitCommand {

    public void addChild(UnitCommand unitCommand);
    public void deleteChild(UnitCommand unitCommand);

}