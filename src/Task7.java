import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task7 extends Thread implements Task {

    Task7() {
        start();
    }

    private Date startDate;
    private Date endDate;
    private ArrayList<String> out = new ArrayList<>();

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        out.add("\nTask7 - Какое число является 10001-ым простым числом?");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        out.add("10001 prime is: " + primeIndex(10001));

        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskLogger logger = new TaskLogger();
        logger.log(out);
    }

    static synchronized long primeIndex(int index) {
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
