package Ex2_2;

import java.util.Objects;
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
                new LinkedBlockingQueue<>());

    }


    public <T> Future<T> submit(Task<T> task)
    {
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


    // TODO: public static TaskType getCurrentMax()


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
