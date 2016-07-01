import java.util.Scanner;

public class PrintPrimes {	

  public static void main(String argv[]){	

	boolean notAnswered = true;
	Scanner input = new Scanner(System.in);//Initalize scanner to read from commandline
	String yesOrNo = "";
	int prime = 2;
	while(notAnswered){
		System.out.println("Would you like to continue? (y/n)");
		yesOrNo  = input.next();
		if(yesOrNo.equals("y")){
			boolean isPrime = false;
			while(isPrime == false){
				isPrime = true;
				prime++;
				for(int i=2; i < prime/2; i++){
					if(prime % i == 0) isPrime = false;
				}
		 	}
			System.out.print(prime + " ");
		}
		else {
			System.exit(0);
		}
	}
  }
}