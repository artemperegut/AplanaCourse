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

        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Task4 task4 = new Task4();
        Task5 task5 = new Task5();
        Task6 task6 = new Task6();
        Task7 task7 = new Task7();
        Task8 task8 = new Task8();
        Task9 task9 = new Task9();
        Task10 task10 = new Task10();
    }
}
