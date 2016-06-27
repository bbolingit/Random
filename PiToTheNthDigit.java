import java.util.Scanner;
import java.math.BigDecimal;
import java.util.InputMismatchException;

public class PiToTheNthDigit {

  public static void main(String argv[]){

	int place = 0;
	boolean notAnswered = true;
	BigDecimal seven = new BigDecimal(7.0);
	Scanner input = new Scanner(System.in);
	while(notAnswered){
		System.out.println("To what decimal place do you want pi?");
		try{
			place = input.nextInt();
			if(place > 100 || place < 0) throw new InputMismatchException();
			notAnswered = false;
		} catch (InputMismatchException error) {
			System.out.println("Please input a valid integer");
		}
	}

	BigDecimal output = new BigDecimal(22.0).divide(seven, place, BigDecimal.ROUND_UP);

	System.out.println(output);
  }
}