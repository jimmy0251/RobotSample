public class MoveCommand implements ICommand {

    private final double distance;

    public MoveCommand(double distance) {
        this.distance = distance;
    }

    @Override
    public void execute(IRobot robot) {
        robot.move(distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoveCommand that = (MoveCommand) o;

        return Double.compare(that.distance, distance) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(distance);
        return (int) (temp ^ (temp >>> 32));
    }
}
