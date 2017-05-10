import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task6 extends Thread implements Task {

    private final Object o;

    Task6(Object o) {
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
        out.add("\nTask6 - Найдите разность между суммой квадратов и квадратом суммы первых ста натуральных чисел.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        int difference = squareOfSums(100) - sumOfSquares(100);
        out.add("Difference: " + difference);

        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskLogger logger = new TaskLogger();
        logger.log(out);
    }

    static synchronized int squareOfSums(int limit) {
        int sum = (limit * (limit + 1)) / 2;
        return sum * sum;
    }

    static synchronized int sumOfSquares(int limit) {
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            sum += i * i;
        }
        return sum;
    }
}
