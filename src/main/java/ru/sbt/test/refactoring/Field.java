package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.unit.Position;
import ru.sbt.test.refactoring.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Field {
    
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
    }

    public List<Unit> getUnits() {
        return units;
    }



}