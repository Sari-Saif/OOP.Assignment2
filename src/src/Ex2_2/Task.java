package Ex2_2;

import java.util.Objects;
import java.util.concurrent.Callable;

public class Task implements Callable,Comparable<Task>
{
    private final static TaskType defualtPriority = TaskType.OTHER;
    private TaskType priority;
    private Callable task;


    private Task(Callable task, TaskType priority)
    {
        this.task = task;
        this.priority = priority;
    }


    public static Task createTask(Callable task)
    {
        return createTask(task, defualtPriority) ;
    }


    public static Task createTask(Callable task, TaskType priority)
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
        return Integer.compare(this.priority.getPriorityValue(), o.getPriority().getPriorityValue());
    }


    @Override
    public Object call() throws Exception
    {
        return this.task.call();
    }
}
