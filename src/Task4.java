import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Task4 extends Thread implements Task {

    private final Object o;
    Task4(Object o) {
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
        out.add("\nTask4 - Найдите самый большой палиндром, полученный умножением двух трёхзначных чисел.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        ArrayList allPalindromesArray = allPalindromes();
        out.add("Max palindrome is: " + Collections.max(allPalindromesArray));


        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskEnvironment.writeFile(out);
        TaskEnvironment.printStats(out);
    }

    static boolean isPalindrome(String s) {
        if (s.length() % 2 == 0) {
            s = s.substring(0, s.length() / 2) + s.substring((s.length() / 2));
        }
        return new StringBuffer(s.substring(0, s.length() / 2)).reverse().toString().equals(s.substring(s.length() / 2));
    }

    static ArrayList allPalindromes() {
        int a = 999;
        int b = 999;
        ArrayList<Long> palindromes = new ArrayList<>();

        for (int bb = b; bb > 0; bb--) {
            for (int aa = a; aa > 0; aa--) {
                if (isPalindrome(new Long(aa * bb).toString())) {
                    palindromes.add(new Long(aa * bb));
                }
            }
        }
        return palindromes;
    }
}
