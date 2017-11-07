import org.junit.Test;

import static org.junit.Assert.*;

public class MemoryCacheTest {

    @Test
    public void testEmptyMemory() {
        ICommandCache memoryCache = new MemoryCache();
        assertTrue(memoryCache.retrieve().isEmpty());
    }

    @Test
    public void testStoredSingleCommand() {
        ICommandCache memoryCache = new MemoryCache();
        ICommand beepCommand = new BeepCommand();
        memoryCache.store(beepCommand);
        assertFalse(memoryCache.retrieve().isEmpty());
        assertEquals(beepCommand, memoryCache.retrieve().get(0));
    }

    @Test
    public void testStoredMultipleCommands() {
        ICommandCache memoryCache = new MemoryCache();
        ICommand beepCommand = new BeepCommand();
        ICommand moveCommand = new MoveCommand(5);
        memoryCache.store(beepCommand);
        memoryCache.store(moveCommand);
        assertEquals(2, memoryCache.retrieve().size());
        assertEquals(beepCommand, memoryCache.retrieve().get(0));
        assertEquals(moveCommand, memoryCache.retrieve().get(1));
    }

}