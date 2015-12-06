package ru.sbt.test.refactoring;

import junit.framework.TestCase;
import ru.sbt.test.refactoring.command.MoveForward;
import ru.sbt.test.refactoring.command.ShotCommand;
import ru.sbt.test.refactoring.command.TurnClockWise;
import ru.sbt.test.refactoring.composite.CompositeCommand;
import ru.sbt.test.refactoring.composite.CompositeCommandBase;
import ru.sbt.test.refactoring.state.Orientation;
import ru.sbt.test.refactoring.unit.Soldier;
import ru.sbt.test.refactoring.unit.Tractor;
import ru.sbt.test.refactoring.unit.Unit;

/**
 * @author Ben
 */
public class TractorTest extends TestCase {

    public void testShouldMoveForward() {
        Tractor tractor = new Tractor();

        new MoveForward(tractor).execute();

        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
    }

    public void testShouldTurn() {
        Tractor tractor = new Tractor();

        new TurnClockWise(tractor).execute();
        assertEquals(Orientation.EAST, tractor.getOrientation());

        new TurnClockWise(tractor).execute();
        assertEquals(Orientation.SOUTH, tractor.getOrientation());

        new TurnClockWise(tractor).execute();
        assertEquals(Orientation.WEST, tractor.getOrientation());

        new TurnClockWise(tractor).execute();
        assertEquals(Orientation.NORTH, tractor.getOrientation());
    }

    public void testShouldTurnAndMoveInTheRightDirection() {
        Tractor tractor = new Tractor();

        new TurnClockWise(tractor).execute();
        new MoveForward(tractor).execute();
        assertEquals(1, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());

        new TurnClockWise(tractor).execute();
        new MoveForward(tractor).execute();
        assertEquals(1, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());

        new TurnClockWise(tractor).execute();
        new MoveForward(tractor).execute();
        assertEquals(0, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());

        new TurnClockWise(tractor).execute();
        new MoveForward(tractor).execute();
        assertEquals(0, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
    }

    public void testShouldThrowExceptionIfFallsOffPlateau() {
        Tractor tractor = new Tractor();
        new MoveForward(tractor).execute();
        new MoveForward(tractor).execute();
        new MoveForward(tractor).execute();
        new MoveForward(tractor).execute();
        new MoveForward(tractor).execute();
        try {
            new MoveForward(tractor).execute();
            fail("Tractor was expected to fall off the plateau");
        } catch (TractorInDitchException expected) {
        }
    }

    public void testShouldBeExceptionIfWeaponsBulletIsNotEnouph() {
        Soldier soldier = new Soldier(3);
        new ShotCommand(soldier).execute();
        new ShotCommand(soldier).execute();
        new ShotCommand(soldier).execute();

        try {
            new ShotCommand(soldier).execute();
            fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    public void testCompositeCommand() {
        Unit tractor = new Tractor();

        CompositeCommand knightsMove = new CompositeCommandBase();

        CompositeCommand up = new CompositeCommandBase();
        up.addChild(new MoveForward(tractor));
        up.addChild(new MoveForward(tractor));
        knightsMove.addChild(up);

        CompositeCommand turn = new CompositeCommandBase();
        turn.addChild(new TurnClockWise(tractor));
        knightsMove.addChild(turn);

        CompositeCommand right = new CompositeCommandBase();
        right.addChild(new MoveForward(tractor));
        knightsMove.addChild(right);

        knightsMove.execute();

        assertEquals(2, tractor.getPositionY());
        assertEquals(1, tractor.getPositionX());

    }

}