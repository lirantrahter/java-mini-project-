package Q1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	final static int N =  10;
	final static int M = 1000 ;
	
	public static void main(String[] args) {
		// Split the range [1, M] into N segments
		int start = 1;
		int end = M;
		int segmentSize = (end - start + 1) / N;

		// Create and start threads to check for prime numbers in each segment
		List<PrimeNumber> runnables = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int segmentStart = start + i * segmentSize;
			int segmentEnd = i == N - 1  ? end : segmentStart + segmentSize - 1;

			PrimeNumber primeNumber = new PrimeNumber(segmentStart, segmentEnd);
			runnables.add(primeNumber);

			Thread thread = new Thread(primeNumber);
			threads.add(thread);

			thread.start();
			
		}

		// Wait for all threads to finish
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Collect all primes and sort them
		List<Integer> allPrimes = new ArrayList<>();
		for (PrimeNumber runnable : runnables) {
			allPrimes.addAll(runnable.getPrimes());
		}

		// Print the sorted results
		System.out.println("Sorted Primes from 1 to " + M + " :");
		for(int num : allPrimes) {
		System.out.println(num);
		}
	}
}
