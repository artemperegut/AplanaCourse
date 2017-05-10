public class TaskMath {
    static synchronized boolean isPrime(Long number) {
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
