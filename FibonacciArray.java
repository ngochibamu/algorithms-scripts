import java.util.List;
import java.util.ArrayList;

public class FibonacciArray {

	/**
		Calculates fibo sequence upto integer n, iteratively
		@param - limit integer n upto which fibonacci numbers should be computed
		@return - array of fibonacci numbers calculated upto interger n

	*/
	public int[] fibonacci (int n){

		int fn1 = 1, fn2 = 0;
		int[] fibos = null;

		if(n == 0){
			fibos = new int[1];
			fibos[0] = fn2;
			return fibos;
		}

		if(n == 1) {
			fibos = new int[2];
			fibos[0] = fn2;
			fibos[1] = fn1;
			return fibos;
		}

		if(n > 1){
		    fibos = new int[n];
			fibos[0] = fn2;
			fibos[1] = fn1;

			for(int i = 2; i < n; i++){
				fibos[i] = fn1 + fn2;
				fn2 = fn1;
				fn1 = fibos[i];
			}
		}

		return fibos;

	}
	/**
		Computes the sum of even fibonacci upto n
		@param - the limit 
		@return - sum of evenfibonacci numbers
	*/

	public int sumOfEvenFibonacci(int n){
		int fn1 = 1, fn2 = 0,sum = 0;
		
		if(n == 0 || n == 1){
			return fn2;
		}

		if(n > 1){
		
			for(int i = 2; i < n; i++){
				int fibo = fn1 + fn2;
				fn2 = fn1;
				fn1 = fibo;
				if(fibo % 2 == 0){
					sum += fibo;
				}
			}
		}

		return sum;

	}

	/**
		Computes array of factors of integer n
		@param - integer n whose factors must be found
		@return - array of factors for integer n
	*/

	public int[] factors(int n){

		List<Integer> factorsList = new ArrayList<Integer>();
		int[] factorArray = null;
		int factorNumber = 1;
		while(factorNumber <= n){
			if(n % factorNumber == 0){
				factorsList.add(factorNumber);
			}
			factorNumber++;
		}
		factorArray = new int[factorsList.size()];
		return factorsList.toArray(factorArray);
	}

	public static void main(String ... args){
		FibonacciArray fbo = new FibonacciArray();

		System.out.println(fbo.sumOfEvenFibonacci(12));
		/*
		for(int i = 0; i < fibos.length; i++){
			System.out.print(fibos[i] + "  ");
		}*/

		System.out.print("Done");
	}
}