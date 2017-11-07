
import java.util.List;

public interface ICommandCache {


    void store(ICommand ICommand);

    List<ICommand> retrieve();


}
