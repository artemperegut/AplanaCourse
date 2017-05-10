import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task3 extends Thread implements Task {

    private final Object o;
    Task3(Object o) {
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
        long number = 600851475143L;

        out.add("\nTask3 - Каков самый большой делитель числа 600851475143, являющийся простым числом?");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        ArrayList allFactors = factors(number);
        out.add("Max prime factor: " + Collections.max(allFactors));

        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskEnvironment.printStats(out);
    }

    static ArrayList factors(long number) {
        ArrayList<Long> factors = new ArrayList<>();
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0 & TaskMath.isPrime(i)) {
                factors.add(i);
            }
        }
        return factors;
    }
}