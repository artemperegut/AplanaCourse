import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task2 extends Thread implements Task {

    private final Object o;
    Task2(Object o) {
        this.o = o;
        start();
    }

    private Date startDate;
    private Date endDate;
    private ArrayList<String> out = new ArrayList<>();

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        out.add("\nTask2 - Найдите сумму всех четных элементов ряда Фибоначчи, которые не превышают четыре миллиона.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        out.add("Sum: " + String.valueOf(fib()));

        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskEnvironment.outS.addAll(out);
        TaskEnvironment.printStats(out);
    }

    static int fib() {
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
            //System.out.print(fibNext + " ");
            if (fibNext % 2 == 0) {
                totalSum = totalSum + fibNext;
            }
        }
        return (totalSum + 2);
    }
}
