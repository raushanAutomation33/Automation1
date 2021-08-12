package javaPractice;

public class ArmstrongNumber {
	public static void main(String[] args) {
		
		int checkArms = 153;
		
		int t1 = checkArms;
		int length = 0;
		while (t1!=0)//creating loop to findout length of checked number
		{
			t1=t1/10;
			length = length+1;
			
		}
		System.out.println("Length of the checked number is "+length);
		
		int reminder;
		int t2 = checkArms;
		int arms=0;
		while(t2!=0) 
		{	int multiple = 1;
			reminder=t2%10;
			
			for(int i=1;i<=length;i++) 
			{
				multiple = multiple*reminder;
				
			}
			arms = arms + multiple;
			t2=t2/10;
		}
		if(arms==checkArms) {
			System.out.println("The given number " +checkArms+" is Armstrong number");
		}
		else 
		{
			System.out.println("The given number " +checkArms+" is not Armstrong number");
		}
	}

}
