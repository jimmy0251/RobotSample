public class CommandCacheRobot implements IRobot {

    private final IRobot robot;
    private final ICommandCache commandCache;

    public CommandCacheRobot(IRobot robot, ICommandCache commandCache) {
        this.robot = robot;
        this.commandCache = commandCache;
    }


    @Override
    public void move(double distance) {
        robot.move(distance);
        commandCache.store(new MoveCommand(distance));
    }

    @Override
    public void turn(double angle) {
        robot.turn(angle);
        commandCache.store(new TurnCommand(angle));

    }

    @Override
    public void beep() {
        robot.beep();
        commandCache.store(new BeepCommand());

    }

}
