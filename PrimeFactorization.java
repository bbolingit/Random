import java.util.Scanner;
import java.util.InputMismatchException;

public class PrimeFactorization {	

  private static boolean prime(int n){
	if (n < 2) return false;
	
	for(int i=2; i < n; i++){
		if(n % i == 0) return false;
	}
	return true;
  }

  public static void main(String argv[]){	

	boolean notAnswered = true;
	Scanner input = new Scanner(System.in);//Initalize scanner to read from commandline
	int n = 0;
	//While a valid response hasn't been given, do loop
	while(notAnswered){
		System.out.println("Enter a value to get its prime factors:");
		try{
			//Attempt to read in an integer after the prompt. Exceptions result in an error message
			n = input.nextInt();
			if(n > 50000 || n < 2) throw new InputMismatchException();//Throws an error message when outside valid input bounds

			notAnswered = false;//If not exceptions are thrown, this is excuted to exit loop
		} catch (InputMismatchException error) {
			System.out.println("Please input a valid integer");
		}
	}

	int middle = n;
	for(int i = 2; i < n; i++){
		if (prime(i) && (middle % i == 0)){
			middle = middle/i;
			System.out.print(i + " ");
			i--;
		}
	}
  }
}