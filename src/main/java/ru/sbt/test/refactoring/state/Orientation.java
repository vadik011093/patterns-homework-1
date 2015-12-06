package ru.sbt.test.refactoring.state;

import ru.sbt.test.refactoring.unit.Unit;

public enum Orientation implements OrienatationState, PositionState {

    NORTH {
        @Override
        public void turnClockwise(Unit unit) {
            unit.changeOrientation(EAST);
        }

        @Override
        public void moveForwards(Unit unit) {
            unit.getPosition().moveY(1);
        }
    }, EAST {
        @Override
        public void turnClockwise(Unit unit) {
            unit.changeOrientation(SOUTH);
        }

        @Override
        public void moveForwards(Unit unit) {
            unit.getPosition().moveX(1);
        }
    }, SOUTH {
        @Override
        public void turnClockwise(Unit unit) {
            unit.changeOrientation(WEST);
        }

        @Override
        public void moveForwards(Unit unit) {
            unit.getPosition().moveY(-1);
        }
    }, WEST {
        @Override
        public void turnClockwise(Unit unit) {
            unit.changeOrientation(NORTH);
        }

        @Override
        public void moveForwards(Unit unit) {
            unit.getPosition().moveX(-1);
        }
    };

}