import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task1 extends Thread implements Task {

    private final Object o;

    Task1(Object o) {
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
        out.add("\nTask1 - Найдите сумму всех чисел меньше 1000, кратных 3 или 5.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        out.add("Sum: " + String.valueOf(sum()));

        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskEnvironment.outS.addAll(out);
        TaskEnvironment.printStats(out);
    }

    static int sum() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                sum = +sum + i;
            }
        }
        return sum;
    }
}
