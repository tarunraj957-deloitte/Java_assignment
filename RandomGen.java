
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Collections.synchronizedList(new ArrayList<>());
		Random r = new Random();
		for(int i=0;i<10;i++)
		{
			int randomNumber = r.nextInt(30 + 10) - 10;
			nums.add(randomNumber);
		
		}
		//thread to find negative numbers
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int value = 0;
			      for (int i = 0; i < 10; i++) {
			         value = nums.get(i);
			         if(value<0)
			         {
			        	 System.out.println("Negative Number: "+value);
			         }
			      }
				
				
			}		
			
		});
		//thread to find positive odd and even numbers
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int value = 0;
			      for (int i = 0; i < 10; i++) {
			         value = nums.get(i);
			         if(value>0)
			         {
			        	 if((value % 2) == 0)
			        	 {
			        		 System.out.println("Positive Even Number: "+value);
			        	 }
			        	 else
			        	 {
			        		 System.out.println("Positive Odd Number: "+value);

			        	 }
			         }
			      }
			   }
			
		});
	
		t1.start();
		t2.start();
	}

}

