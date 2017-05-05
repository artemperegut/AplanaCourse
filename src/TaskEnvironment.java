import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by user on 02.05.2017.
 */
public class TaskEnvironment {
    public static void main(String[] args) throws FileNotFoundException {
//        Task1 task1 = new Task1();
//        task1.run();
//        printSpacer();
//
//        Task2 task2 = new Task2();
//        task2.run();
//        printSpacer();
//
//        Task3 task3 = new Task3();
//        task3.run();
//        printSpacer();
//
//        Task4 task4 = new Task4();
//        task4.run();
//        printSpacer();
//
//        Task5 task5 = new Task5();
//        task5.run();
//        printSpacer();
//
//        Task6 task6 = new Task6();
//        task6.run();
//        printSpacer();
//
//        Task7 task7 = new Task7();
//        task7.run();
//        printSpacer();
//
//        Task8 task8 = new Task8();
//        task8.run();
//        printSpacer();
//
//        Task9 task9 = new Task9();
//        task9.run();
//        printSpacer();
//
//        Task10 task10 = new Task10();
//        task10.run();

//        Task1 task1 = new Task1();
//        Thread thread1 = new Thread(task1);
//        thread1.start();
//        printSpacer();
//
//        Task2 task2 = new Task2();
//        Thread thread2 = new Thread(task2);
//        thread2.start();
//        printSpacer();
//
//        Task3 task3 = new Task3();
//        Thread thread3 = new Thread(task3);
//        thread3.start();
//        printSpacer();
//
//        Task4 task4 = new Task4();
//        Thread thread4 = new Thread(task4);
//        thread4.start();
//        printSpacer();
//
//        Task5 task5 = new Task5();
//        Thread thread5 = new Thread(task5);
//        thread5.start();
//        printSpacer();
//
//        Task6 task6 = new Task6();
//        Thread thread6 = new Thread(task6);
//        thread6.start();
//        printSpacer();
//
//        Task7 task7 = new Task7();
//        Thread thread7 = new Thread(task7);
//        thread7.start();
//        printSpacer();
//
//        Task8 task8 = new Task8();
//        Thread thread8 = new Thread(task8);
//        thread8.start();
//        printSpacer();
//
//        Task9 task9 = new Task9();
//        Thread thread9 = new Thread(task9);
//        thread9.start();
//        printSpacer();
//
//        Task10 task10 = new Task10();
//        Thread thread10 = new Thread(task10);
//        thread10.start();

        Object o = new Object();
        Task9 task9 = new Task9(o);
        Task10 task10 = new Task10(o);
    }

    static void printSpacer() {
        System.out.println("\n=======================================================================\n");
    }
}
