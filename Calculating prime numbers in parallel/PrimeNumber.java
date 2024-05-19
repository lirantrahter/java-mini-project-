package Q1;

import java.util.ArrayList;
import java.util.List;

class PrimeNumber implements Runnable {
    private final int start;
    private final int end;
    private List<Integer> primes;

    public PrimeNumber(int start, int end) {
        this.start = start;
        this.end = end;
        this.primes = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }
    
    //return list of prime number 
    public List<Integer> getPrimes() {
        return primes;
    }

    
    //check if the number is prime and return true 
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}