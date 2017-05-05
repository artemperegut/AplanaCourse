import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task7 implements Task, Runnable {

    private Date startDate;
    private Date endDate;

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        System.out.println("Task7 - Какое число является 10001-ым простым числом?");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        System.out.println("Start time: " + dateFormat.format(startDate));

        System.out.println("10001 prime is: " + primeIndex(10001));

        endDate = new Date();
        System.out.println("End time: " + dateFormat.format(endDate));

        System.out.println("Duration: " + getProcessTime() + " seconds");
    }

    static long primeIndex(int index) {
        int primesIndex = 1;
        long i = 2;
        while (primesIndex <= index) {
            if (TaskMath.isPrime(i)) {
                i++;
                primesIndex++;
            } else i++;
        }
        return i - 1;
    }
}
