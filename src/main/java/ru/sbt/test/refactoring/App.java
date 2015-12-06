package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.command.MoveForward;
import ru.sbt.test.refactoring.command.ShotCommand;
import ru.sbt.test.refactoring.command.TurnClockWise;
import ru.sbt.test.refactoring.command.UnitCommand;
import ru.sbt.test.refactoring.composite.CompositeCommand;
import ru.sbt.test.refactoring.composite.CompositeCommandBase;
import ru.sbt.test.refactoring.unit.Soldier;
import ru.sbt.test.refactoring.unit.Tractor;
import ru.sbt.test.refactoring.unit.Unit;

public class App {

    public static void main(String[] args) {
        Field field = new Field();

        Tractor belarus = new Tractor();
        Tractor k700 = new Tractor();

        Soldier soldier = new Soldier(10);

        field.addUnit(belarus);
        field.addUnit(k700);
        field.addUnit(soldier);

        new ShotCommand(soldier).execute();
//        new ShotCommand(belarus).execute(); // Compile error

        UnitCommand knightsMove = createKnightsMove(belarus);
        knightsMove.execute();

    }

    private static UnitCommand createKnightsMove(Unit unit) {
        CompositeCommand knightsMove = new CompositeCommandBase();

        CompositeCommand up = new CompositeCommandBase();
        up.addChild(new MoveForward(unit));
        up.addChild(new MoveForward(unit));
        knightsMove.addChild(up);

        CompositeCommand turn = new CompositeCommandBase();
        turn.addChild(new TurnClockWise(unit));
        knightsMove.addChild(turn);

        CompositeCommand right = new CompositeCommandBase();
        right.addChild(new MoveForward(unit));
        knightsMove.addChild(right);

        return knightsMove;
    }

}