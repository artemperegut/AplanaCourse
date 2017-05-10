import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class TaskLogger {
    synchronized void log(ArrayList<String> stats) {
        for (String element : stats) {
            System.out.println(element);
            try {
                Files.write(Paths.get("output.txt"), (element + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
