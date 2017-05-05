import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task10 extends Thread implements Task {

    private final Object o;
    Task10(Object o) {
        this.o = o;
        start();
    }

    private Date startDate;
    private Date endDate;

    public synchronized double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        System.out.println("Task10 - Найдите сумму всех простых чисел меньше двух миллионов.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        System.out.println("Start time: " + dateFormat.format(startDate));

        primeSum(2000000);

        endDate = new Date();
        System.out.println("End time: " + dateFormat.format(endDate));

        System.out.println("Duration: " + getProcessTime() + " seconds");
    }

    static synchronized Long primeSum(int limit) {
        long sum = 0;

        for (long i = 2; i < limit; i++) {
            if (TaskMath.isPrime(i)) {
                sum += i;
            }
        }
        System.out.println("Sum: " + sum);
        return sum;
    }
}
