import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Task8 extends Thread implements Task {

    private final Object o;

    Task8(Object o) {
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
        out.add("\nTask8 - Найдите наибольшее произведение тринадцати последовательных цифр в данном числе.");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        startDate = new Date();
        out.add("Start time: " + dateFormat.format(startDate));

        out.add("Max : " + multiplication(13));

        endDate = new Date();
        out.add("End time: " + dateFormat.format(endDate));

        out.add("Duration: " + getProcessTime() + " seconds\n");

        TaskLogger logger = new TaskLogger();
        logger.log(out);
    }

    static synchronized Long multiplication(int numbers) {
        String number = "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";
        long max = 0;

        for (int i = 0; i < number.length() - numbers - 1; i++) {
            int min = number.charAt(i) - '0';
            long product = 1;
            for (int k = i; k < numbers + i; k++) {
                int numK = number.charAt(k) - '0';
                min = Math.min(numK, min);
                if (min == 0) {
                    product = 0;
                    i = k + 1;
                    break;
                } else {
                    product = product * numK;
                }
            }
            if (product > max) {
                max = product;
            }
        }
        return max;
    }
}