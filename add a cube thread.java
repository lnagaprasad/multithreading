//please add cube thread for this program

package lab;
import java.util.*;
public class multithread {
	
	public static void main(String[] args) {
		RandomThread obj = new RandomThread();
		Thread t1=new Thread(obj);
		t1.start();
	}
}
class squarethread implements Runnable
{
	int x;
	 squarethread(int x)
	{
		this.x=x;
	}
	public void run()
	{
		System.out.println("on squaring "+x*x);
	}
}
class RandomThread implements Runnable
{
	Thread t2;
	public void run()
	{
		int num;
		Random r = new Random();
		try
		{
			while(true)
			{
				num=r.nextInt(1000);
				System.out.println("main thread value: "+num);
				t2=new Thread(new squarethread(num));
				t2.start();
				Thread.sleep(1000);
				System.out.println("----------------------------------------------------");
				
			}
		}
		catch(Exception e)
		{
			System.out.println("interrrupt has occured");
		}
	}
}
