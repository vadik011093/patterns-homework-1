package ru.sbt.test.refactoring.command;

import ru.sbt.test.refactoring.unit.Turnable;

public class TurnClockWise implements UnitCommand {

    private final Turnable turnable;

    public TurnClockWise(Turnable turnable) {
        this.turnable = turnable;
    }

    @Override
    public void execute() {
        turnable.turnClockwise();
    }

}
