import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task5 implements Task, Runnable {

    private Date startDate;
    private Date endDate;

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        System.out.println("Task5 - Какое самое маленькое число делится нацело на все числа от 1 до 20?");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        System.out.println("Start time: " + dateFormat.format(startDate));

        smallest();

        endDate = new Date();
        System.out.println("End time: " + dateFormat.format(endDate));

        System.out.println("Duration: " + getProcessTime() + " seconds");
    }

    static void smallest() {
        long a = 21;
        while (true) {
            boolean all = true;
            for (int i = 1; i < 21; i++) {
                all = true;
                if (a % i != 0) {
                    all = false;
                    break;
                }
            }
            if (all) {
                System.out.println("Smalles number: " + a);
                break;
            }
            a++;
        }
    }
}
