import java.util.Scanner;
import java.util.InputMismatchException;

public class NthFibonacci {	

  public static void main(String argv[]){	

	int n = 0;
	int result = 0;
	int first = 1;
	int second = 0;
	boolean notAnswered = true;
	Scanner input = new Scanner(System.in);//Initalize scanner to read from commandline
	
	//While a valid response hasn't been given, do loop
	while(notAnswered){
		System.out.println("Which term of the fibonacci sequence do you desire?");
		try{
			//Attempt to read in an integer after the prompt. Exceptions result in an error message
			n = input.nextInt();
			if(n > 100 || n < 0) throw new InputMismatchException();//Throws an error message when outside valid input bounds

			place = input.nextInt();
			if(place > 100 || place < 0) throw new InputMismatchException();//Throws an error message when outside valid input bounds

			notAnswered = false;//If not exceptions are thrown, this is excuted to exit loop
		} catch (InputMismatchException error) {
			System.out.println("Please input a valid integer");
		}
	}

	for(int i = 0; i < (n-1); i++){
		result = first + second;
		second = first;
		first = result;
	}
	
	System.out.println(result);
  }
}