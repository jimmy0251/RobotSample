import java.util.ArrayList;
import java.util.List;

public class MemoryCache implements ICommandCache {

    List<ICommand> commands = new ArrayList<>();

    @Override
    public void store(ICommand command) {
        commands.add(command);
    }

    @Override
    public List<ICommand> retrieve() {
        return new ArrayList<>(commands);
    }

}
