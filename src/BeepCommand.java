
public class BeepCommand implements ICommand {
    @Override
    public void execute(IRobot robot) {
        robot.beep();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BeepCommand;
    }
}
