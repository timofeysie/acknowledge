import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
 
public class TakeAndOfferNext implements Callable<Object>
{
     
    BlockingQueue<Integer> takeFrom;
    BlockingQueue<Integer> offerTo;
    int maxNumber;
     
    public TakeAndOfferNext(BlockingQueue<Integer> takeFrom, BlockingQueue<Integer> offerTo, int maxNumber)
    {
        this.takeFrom = takeFrom;
        this.offerTo = offerTo;
        this.maxNumber = maxNumber;
    }
     
    public Object call() throws Exception
    {
        print();
        return null;
    }
     
    public void print()
    {
        while (true)
        {
            try
            {
                int i = takeFrom.take(); //removes the value in the "from" queue
                System.out.println(Thread.currentThread().getName() + " --> " + i);
                offerTo.offer(i + 1); 
		//increments the value by 1 & puts it in the "to" queue.
                if (i >= (maxNumber - 1))
                {
                    System.exit(0);
                }
            }
            catch (InterruptedException e)
            {
                throw new IllegalStateException("Unexpected interrupt", e);
            }
        }
    }
     
}
