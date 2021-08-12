package javaPractice;

public class PrimeNumberTest {

	public static void main(String[] args) {
		
		int checkForPrime =5;
		int temp = 0;
		
		for(int i = 2; i<checkForPrime-1;i++) {
			if(checkForPrime%i == 0) {
				temp = temp + 1;
			}
			
		}
		if (temp>0) {
			System.out.println("This Number is not prime "+checkForPrime);
		}
		else {
			System.out.println("This Number is prime "+checkForPrime);
		}
	}

}
