import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Task4 implements Task, Runnable {

    private Date startDate;
    private Date endDate;

    public double getProcessTime() {
        return (endDate.getTime() - startDate.getTime()) / 1000d;
    }

    public void run() {
        System.out.println("Task4 - Найдите самый большой палиндром, полученный умножением двух трёхзначных чисел.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        System.out.println("Start time: " + dateFormat.format(startDate));

        ArrayList allPalindromesArray = allPalindromes();
        System.out.println("Max palindrome is: " + Collections.max(allPalindromesArray));


        endDate = new Date();
        System.out.println("End time: " + dateFormat.format(endDate));

        System.out.println("Duration: " + getProcessTime() + " seconds");
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
