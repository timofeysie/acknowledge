import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
 
public class OddAndEvenSignalling
{
     
    private static final int MAX_NUMBER = 10;
     
    public static void main(String[] args)
    {
        BlockingQueue<Integer> odds = new LinkedBlockingQueue<Integer>();
        BlockingQueue<Integer> evens = new LinkedBlockingQueue<Integer>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
         
        //odd numbers are 
	//removed from the "from" queue 
	//--> printed 
	//--> incremented 
	//--> placed on the "to" queue by one thread
        //"from" queue is "odd number" queue and "to" queue is "even number" queue
        executorService.submit(new TakeAndOfferNext(odds, evens, MAX_NUMBER));
         
        //even numbers are 
	//removed from the "from" queue 
	//--> printed 
	//--> incremented 
	//--> placed on the "to" queue by another thread
        //"from" queue is "even number" queue and "to" queue is "odd number" queue
        executorService.submit(new TakeAndOfferNext(evens, odds, MAX_NUMBER));
        odds.offer(1);
    }
}
