import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task3 implements Task, Runnable {

    private Date startDate;
    private Date endDate;

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        long number = 600851475143L;

        System.out.println("Task3 - Каков самый большой делитель числа 600851475143, являющийся простым числом?");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        System.out.println("Start time: " + dateFormat.format(startDate));

        ArrayList allFactors = factors(number);

        endDate = new Date();
        System.out.println("End time: " + dateFormat.format(endDate));

        System.out.println("Duration: " + getProcessTime() + " seconds");
        System.out.print("Max prime factor: " + Collections.max(allFactors));
    }

    static ArrayList factors(long number) {
        ArrayList<Long> factors = new ArrayList<>();
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0 & TaskMath.isPrime(i)) {
                factors.add(i);
            }
        }
        System.out.println("All prime factors: " + factors);
        return factors;
    }
}