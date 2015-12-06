package ru.sbt.test.refactoring.command;

import ru.sbt.test.refactoring.TractorInDitchException;
import ru.sbt.test.refactoring.service.UnitService;
import ru.sbt.test.refactoring.unit.Movable;
import ru.sbt.test.refactoring.unit.Position;

public class MoveForward implements UnitCommand {

    private final UnitService unitService = new UnitService();
    private final Movable movable;
    private final Position oldPosition;

    public MoveForward(Movable unit) {
        this.movable = unit;
        this.oldPosition = unit.getPosition();
    }

    public void execute() {
        movable.moveForward();
        if (unitService.checkCorrectPosition(movable)) return;

        movable.changePosition(oldPosition);
        throw new TractorInDitchException();
    }

}