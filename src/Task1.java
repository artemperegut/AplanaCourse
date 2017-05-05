import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task1 implements Task, Runnable {

    private Date startDate;
    private Date endDate;

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        System.out.println("Task1 - Найдите сумму всех чисел меньше 1000, кратных 3 или 5.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        System.out.println("Start time: " + dateFormat.format(startDate));

        sum();

        endDate = new Date();
        System.out.println("End time: " + dateFormat.format(endDate));

        System.out.println("Duration: " + getProcessTime() + " seconds");
    }

    static void sum() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                sum = +sum + i;
            }
        }
        System.out.println(sum);
    }
}
