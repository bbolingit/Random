public class EToNthDigit {

  public static void main(String argv[]){
	double result = 0;
	boolean notAnswered = true;
	Scanner input = new Scanner(System.in);//Initalize scanner to read from commandline
	
	//While a valid response hasn't been given, do loop
	while(notAnswered){
		System.out.println("To what decimal place do you want e?");
		try{
			//Ateempt to read in an integer after the prompt. Exceptions result in an error message
			place = input.nextInt();
			if(place > 100 || place < 0) throw new InputMismatchException();//Throws an error message when outside valid input bounds
			notAnswered = false;//If not exceptions are thrown, this is excuted to exit loop
		} catch (InputMismatchException error) {
			System.out.println("Please input a valid integer");
		}
	}
	
	//The actual math. It realies on the 
	result = (double) Math.round((long) Math.pow(10, n)) * Math.E)

	System.out.println(result);
	input.close();
  }
}
