import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskEnvironment {
    public static void main(String[] args) {
        PrintWriter pw;
        try {
            pw = new PrintWriter("output.txt");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Object o = new Object();
        Task1 task1 = new Task1(o);
        Task2 task2 = new Task2(o);
        Task3 task3 = new Task3(o);
        Task4 task4 = new Task4(o);
        Task5 task5 = new Task5(o);
        Task6 task6 = new Task6(o);
        Task7 task7 = new Task7(o);
        Task8 task8 = new Task8(o);
        Task9 task9 = new Task9(o);
        Task10 task10 = new Task10(o);
    }
}
