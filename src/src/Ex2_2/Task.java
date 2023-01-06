package Ex2_2;

import java.util.Objects;
import java.util.concurrent.Callable;

public class Task<T> implements Callable<T>, Comparable<Task<T>>
{
    private final static TaskType defaultPriority = TaskType.OTHER;
    private TaskType priority;
    private Callable<T> task;


    private Task(Callable<T> task, TaskType priority)
    {
        this.task = task;
        this.priority = priority;
    }


    public static <T> Task<T> createTask(Callable<T> task)
    {
        return createTask(task, defaultPriority) ;
    }


    public static <T> Task<T> createTask(Callable<T> task, TaskType priority)
    {
        return new Task<T>(task, priority);
    }


    public TaskType getPriority()
    {
        return this.priority;
    }


    @Override
    public int compareTo(Task o)
    {
        return Integer.compare(this.priority.getPriorityValue(), o.getPriority().getPriorityValue());
    }


    @Override
    public T call() throws Exception
    {
        return this.task.call();
    }
}
