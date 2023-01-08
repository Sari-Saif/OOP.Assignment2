package Ex2_2;

import java.util.Objects;
import java.util.concurrent.Callable;

public class Task<T> implements Callable<T>, Comparable<Task<T>>
{
    private final static TaskType defaultPriority = TaskType.OTHER;
    private TaskType priority;
    private Callable<T> task;


    /**
     * function constructor
     * @param task type Callable
     * @param priority to set for the new task
     */
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
        // prioryty is from lower number to higher number
        return -Integer.compare(this.priority.getPriorityValue(), o.getPriority().getPriorityValue());
    }


    @Override
    public T call() throws Exception
    {
        return this.task.call();
    }
    @Override
    public String toString() {
        return "Task{" +
                "priority=" + priority +
                ", task=" + task +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task<?> task1)) return false;
        return getPriority() == task1.getPriority() && task.equals(task1.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPriority(), task);
    }



}
