import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task5 extends Thread implements Task {

    Task5() {
        start();
    }

    private Date startDate;
    private Date endDate;
    private ArrayList<String> out = new ArrayList<>();

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        out.add("\nTask5 - Какое самое маленькое число делится нацело на все числа от 1 до 20?");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        out.add("Smalles number: " + smallest());

        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskLogger logger = new TaskLogger();
        logger.log(out);
    }

    static synchronized Long smallest() {
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
                return a;
            }
            a++;
        }
    }
}
