import java.util.Scanner;
import java.util.InputMismatchException;


public class TileCost {

  public static void main(String argv[]){

	boolean notAnswered = true;
	Scanner input = new Scanner(System.in);//Initalize scanner to read from commandline
	double length = 0;
	double width = 0;
	double price = 0;	

	//While a valid response hasn't been given, do loop
	while(notAnswered){
		try{
			//Attempt to read in an integer after the prompt. Exceptions result in an error message
			System.out.println("What is the width of the room?");
			length = input.nextDouble();
			if(length > 1000 || length < 0) throw new InputMismatchException();//Throws an error message when outside valid input bounds

			System.out.println("What is the length of the room?");
			width = input.nextDouble();
			if(width > 1000 || width < 0) throw new InputMismatchException();//Throws an error message when outside valid input bounds

			System.out.println("What is the price of the tile per square foot?");
			price = input.nextDouble();
			if(price > 1000 || price < 0) throw new InputMismatchException();//Throws an error message when outside valid input bounds

			notAnswered = false;//If not exceptions are thrown, this is excuted to exit loop
		} catch (InputMismatchException error) {
			System.out.println("Please input a valid number");
		}
	}

	System.out.println("The cost is " + (length * width * price));
  }
}