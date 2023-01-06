package Ex2_2;

import java.util.concurrent.*;

public class CustomExecutor
{
    private ThreadPoolExecutor threadPool;

    CustomExecutor()
    {
        int numOfCores = Runtime.getRuntime().availableProcessors();
        this.threadPool = new ThreadPoolExecutor(numOfCores/2,
                numOfCores-1,
                300,
                TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<>());
    }


    public Future<?> submit(Task<?> task)
    {
        return this.threadPool.submit(task);
    }


    public Future<?> submit(Callable<?> c, TaskType tt)
    {
        return submit(Task.createTask(c, tt));
    }


    public Future<?> submit(Callable<?> c)
    {
        return submit(Task.createTask(c));
    }


    // TODO: public static TaskType getCurrentMax()


    public void gracefullyTerminate()
    {
        this.threadPool.shutdown();
    }
}
