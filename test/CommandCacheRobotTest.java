import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;


public class CommandCacheRobotTest {

    @Mock
    ICommandCache commandCache;
    @Mock
    IRobot robot;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    IRobot commandCacheRobot;

    @Before
    public void setUp() throws Exception {
        commandCacheRobot = new CommandCacheRobot(robot, commandCache);
    }

    @After
    public void tearDown() throws Exception {
        commandCacheRobot = null;
    }

    @Test
    public void testCachesBeep() {
        commandCacheRobot.beep();
        verify(commandCache).store(new BeepCommand());
    }

    @Test
    public void testCachesMove() {
        commandCacheRobot.move(5);
        verify(commandCache).store(new MoveCommand(5));
    }

    @Test
    public void testCachesTurn() {
        commandCacheRobot.turn(0.5);
        verify(commandCache).store(new TurnCommand(0.5));
    }


    @Test
    public void testBeepsRobot() {
        commandCacheRobot.beep();
        verify(robot).beep();
    }

    @Test
    public void testMovesRobot() {
        commandCacheRobot.move(5);
        verify(robot).move(5);
    }

    @Test
    public void testTurnsRobot() {
        commandCacheRobot.turn(0.5);
        verify(robot).turn(0.5);
    }
}