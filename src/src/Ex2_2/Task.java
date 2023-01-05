package Ex2_2;

import java.util.concurrent.Callable;

public class Task implements Callable<V>,Comparable<Task>
{

    private TaskType priority;
    private  Callable<V> task;

    private final static TaskType DefualtPriority = TaskType.OTHER;

    private Task(Callable<V> task, TaskType priority)
    {
        this.task = task;
        this.priority = priority;
    }
    public static Task createTask(Callable<V> task)
    {
        return createTask(task, DefualtPriority) ;
    }
    public static Task createTask(Callable<V> task, TaskType priority)
    {
        return new Task(task, priority);
    }
    public TaskType getPriority()
    {
        return this.priority;
    }
    @Override
    public int compareTo(Task o)
    {
        return Integer.compare(this.priority.getPriorityValue(),o.getPriority().getPriorityValue());
    }

    @Override
    public V call() throws Exception
    {
        return this.task.call();
    }
}
