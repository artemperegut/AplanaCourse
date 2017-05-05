import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task2 implements Task, Runnable {

    private Date startDate;
    private Date endDate;

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        System.out.println("Task2 - Найдите сумму всех четных элементов ряда Фибоначчи, которые не превышают четыре миллиона.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        System.out.println("Start time: " + dateFormat.format(startDate));

        fib();

        endDate = new Date();
        System.out.println("End time: " + dateFormat.format(endDate));

        System.out.println("Duration: " + getProcessTime() + " seconds");
    }

    static void fib() {
        int fibNext = 0;
        int fib1 = 1;
        int fib2 = 2;
        int totalSum = 0;
        while (true) {
            fibNext = fib2 + fib1;
            fib1 = fib2;
            fib2 = fibNext;
            if (fib2 >= 4000000) {
                break;
            }
            System.out.print(fibNext + " ");
            if (fibNext % 2 == 0) {
                totalSum = totalSum + fibNext;
            }
        }
        System.out.println("\n" + (totalSum + 2));
    }
}
