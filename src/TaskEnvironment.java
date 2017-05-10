import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TaskEnvironment {
    static ArrayList<String> outS = new ArrayList<>();

    public static void main(String[] args) {

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

        TaskEnvironment.writeFile(outS);
    }

    static void printStats(ArrayList<String> array) {
        for (String element : array) {
            System.out.println(element);
        }
    }

    static void writeFile(ArrayList<String> array) {
        try {
            Files.write(Paths.get("output.txt"), array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
