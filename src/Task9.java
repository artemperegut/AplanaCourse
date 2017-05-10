import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task9 extends Thread implements Task {

    private final Object o;

    Task9(Object o) {
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
        out.add("\nTask9 - Найдите произведение abc.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        triple();

        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskLogger logger = new TaskLogger();
        logger.log(out);
    }

    synchronized void triple() {
        double doubleC;
        outerloop:
        for (int a = 1; a < 500; a++) {
            for (int b = 2; b < 500; b++) {
                doubleC = Math.sqrt(a * a + b * b);
                int c = (int) doubleC;

                if ((doubleC - c == 0) & ((a + b + c) == 1000)) {
                    out.add("a = " + a + ", b = " + b + ", c = " + c);
                    out.add("a*b*c = " + a * b * c);
                    break outerloop;
                }
            }
        }
    }
}
