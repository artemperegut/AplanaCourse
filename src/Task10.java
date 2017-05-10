import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task10 extends Thread implements Task {

    private final Object o;
    Task10(Object o) {
        this.o = o;
        start();
    }

    private Date startDate;
    private Date endDate;
    private ArrayList<String> out = new ArrayList<>();

    public synchronized double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        out.add("\nTask10 - Найдите сумму всех простых чисел меньше двух миллионов.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        out.add("Sum: " + primeSum(2000000));

        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskEnvironment.outS.addAll(out);
        TaskEnvironment.printStats(out);
    }

    synchronized Long primeSum(int limit) {
        long sum = 0;

        for (long i = 2; i < limit; i++) {
            if (TaskMath.isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
