import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task9 extends Thread implements Task {

    private final Object o;
    Task9(Object o) {
        this.o = o;
        start();
    }

    private Date startDate;
    private Date endDate;

    public synchronized double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        System.out.println("Task9 - Найдите произведение abc.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        System.out.println("Start time: " + dateFormat.format(startDate));

        triple();

        endDate = new Date();
        System.out.println("End time: " + dateFormat.format(endDate));

        System.out.println("Duration: " + getProcessTime() + " seconds");
    }

    static synchronized void triple() {
        double doubleC;
        outerloop:
        for (int a = 1; a < 500; a++) {
            for (int b = 2; b < 500; b++) {
                doubleC = Math.sqrt(a * a + b * b);
                int c = (int) doubleC;

                if ((doubleC - c == 0) & ((a + b + c) == 1000)) {
                    System.out.println("a = " + a + ", b = " + b + ", c = " + c);
                    System.out.println("a*b*c = " + a * b * c);
                    break outerloop;
                }
            }
        }
    }
}
