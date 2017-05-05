import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task6 implements Task, Runnable {

    private Date startDate;
    private Date endDate;

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        System.out.println("Task6 - Найдите разность между суммой квадратов и квадратом суммы первых ста натуральных чисел.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        System.out.println("Start time: " + dateFormat.format(startDate));

        int difference = squareOfSums(100) - sumOfSquares(100);

        endDate = new Date();
        System.out.println("End time: " + dateFormat.format(endDate));

        System.out.println("Duration: " + getProcessTime() + " seconds");
        System.out.println("Difference: " + difference);
    }

    static int squareOfSums(int limit) {
        int sum = (limit * (limit + 1)) / 2;
        return sum * sum;
    }

    static int sumOfSquares(int limit) {
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            sum += i * i;
        }
        return sum;
    }
}
