package Ex2_2;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ourPriorityBlockingQueue extends PriorityBlockingQueue
{
    private AtomicInteger currMax;


    /**
     * function C'TOR
     * @param currMax from CustomExecutor (probably :)
     */
    ourPriorityBlockingQueue(AtomicInteger currMax)
    {
        this.currMax = currMax;
    }


    /**
     * function override take() and insert it
     * functionality that update currMax with the
     * right value.
     * @return object same as origin take()
     * @throws InterruptedException same as origin take()
     */
    @Override
    public Object take() throws InterruptedException
    {
        System.out.println("heyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy2");

        if(super.size() > 1)
        {
            this.currMax.set(((Task<?>) super.stream().toList().get(this.size() - 2)).getPriority().getPriorityValue());
        }

        return super.take();
    }
}
