package ru.sbt.test.refactoring.composite;

import ru.sbt.test.refactoring.command.UnitCommand;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommandBase implements CompositeCommand {

    protected final List<UnitCommand> commands = new ArrayList<>();

    @Override
    public void addChild(UnitCommand unitCommand) {
        commands.add(unitCommand);
    }

    @Override
    public void deleteChild(UnitCommand unitCommand) {
        commands.remove(unitCommand);
    }

    @Override
    public void execute() {
        commands.forEach(UnitCommand::execute);
    }

}