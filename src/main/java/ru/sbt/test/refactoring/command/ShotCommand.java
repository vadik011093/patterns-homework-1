package ru.sbt.test.refactoring.command;

import ru.sbt.test.refactoring.unit.Combat;

public class ShotCommand implements UnitCommand {

    private final Combat combat;

    public ShotCommand(Combat combat) {
        this.combat = combat;
    }

    @Override
    public void execute() {
        combat.shoot();
    }
}
