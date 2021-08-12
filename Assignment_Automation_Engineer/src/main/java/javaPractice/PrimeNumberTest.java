package javaPractice;

public class PrimeNumberTest {

	public static void main(String[] args) {
		
		int checkForPrime =5;
		int temp = 0;
		
		for(int i = 2; i<checkForPrime-1;i++) {
			
			/*
			 * Starting the loop from 2, as prime number gets divided by 1 or itself.
			 * Checking upto just one number before the checked number		 * 
			 * if we are checking for 5-- 2,3,4 are the numbers which we will try to divide with 5
			 * if 5 is getting divided with any number, then that is not prime.
			 * */
			if(checkForPrime%i == 0) //check if 5 is getting divided by any number 2,3,4 and reminder is coming 0
			{
				temp = temp + 1;//if the checked number will have 0 reminder, then temp value will be increased to 1
			}
			
		}
		if (temp>0) //if temp value is greater than 0, that means it got divided from any number between the loop and it is not prime.
		{
			System.out.println("This Number is not prime "+checkForPrime);
		}
		else {
			System.out.println("This Number is prime "+checkForPrime);
		}
	}

}
