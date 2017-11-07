public class TurnCommand implements ICommand {

    private final double angle;

    public TurnCommand(double angle) {
        this.angle = angle;
    }

    @Override
    public void execute(IRobot robot) {
        robot.turn(angle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TurnCommand that = (TurnCommand) o;

        return Double.compare(that.angle, angle) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(angle);
        return (int) (temp ^ (temp >>> 32));
    }
}
