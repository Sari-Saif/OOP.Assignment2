package Ex2_2;

import java.util.Objects;
import java.util.concurrent.*;

public class CustomExecutor
{
    private ThreadPoolExecutor threadPool;
    private int currentMax;


    /**
     * function C'TOR.
     * init the threadPool as explain us in lecture 9,
     * with the correct values was needed for this assignment.
     */
    CustomExecutor()
    {
        int numOfCores = Runtime.getRuntime().availableProcessors();
        this.threadPool = new ThreadPoolExecutor(numOfCores/2,
                numOfCores-1,
                300,
                TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<>()); // LinkedBlockingQueue<>()
        this.currentMax = Integer.MAX_VALUE;
    }


    public <T> Future<T> submit(Task<T> task)
    {
        if(task.getPriority().getPriorityValue() < this.currentMax)
        {
            this.currentMax = task.getPriority().getPriorityValue();
        }
        return this.threadPool.submit(task);
    }


    public <T> Future<T> submit(Callable<T> c, TaskType tt)
    {
        return submit(Task.createTask(c, tt));
    }


    public <T> Future<T> submit(Callable<T> c)
    {
        return submit(Task.createTask(c));
    }


    // TODO: public int getCurrentMax() better!
    public int getCurrentMax()
    {
        return this.currentMax;
    }


    public void gracefullyTerminate()
    {
        this.threadPool.shutdown();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomExecutor that)) return false;
        return threadPool.equals(that.threadPool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(threadPool);
    }

    @Override
    public String toString() {
        return "CustomExecutor{" +
                "threadPool=" + threadPool +
                '}';
    }
}
