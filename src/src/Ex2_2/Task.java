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


    /**
     * A factory method for creating a Task
     * @param task type Callable
     * @return the created Task
     * @param <T> type return from Callable call function.
     */
    public static <T> Task<T> createTask(Callable<T> task)
    {
        return createTask(task, defaultPriority) ;
    }


    /**
     * A factory method for creating a Task
     * @param task type Callable
     * @param priority for assign to the new Task
     * @return the created Task
     * @param <T> type return from Callable call function.
     */
    public static <T> Task<T> createTask(Callable<T> task, TaskType priority)
    {
        return new Task<T>(task, priority);
    }


    /**
     * function getter
     * @return the priority of THIS Task
     */
    public TaskType getPriority()
    {
        return this.priority;
    }


    /**
     * function for comparable functionality.
     * @param o the object to be compared.
     * @return 1 if other priority number bigger than THIS,
     * because the smallest numbers needs to be first in the
     * priority queue. so result from this function is 'by reverse'.
     * @return 0 if priority of THIS Task and other are equals.
     * @return -1 if THIS priority number bigger than other,
     * from the same reason explain above.
     */
    @Override
    public int compareTo(Task o)
    {
        // prioryty is from lower number to higher number
        return -Integer.compare(this.priority.getPriorityValue(), o.getPriority().getPriorityValue());
    }


    /**
     * function call override call of Callable
     * @return the number of lines of file.
     * @throws Exception if something go wrong in calculate.
     */
    @Override
    public T call() throws Exception
    {
        return this.task.call();
    }


    /**
     * override toString of this object
     * @return String represent the Task object.
     */
    @Override
    public String toString()
    {
        return "Task{" +
                "priority=" + priority +
                ", task=" + task +
                '}';
    }


    /**
     * function give users option to exam if two Task are the same.
     * @param o is the other object to exam.
     * @return True for equal, False for not.
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Task<?> task1)) return false;
        return getPriority() == task1.getPriority() && task.equals(task1.task);
    }


    /**
     * function create Hash value for Task object.
     * @return the integer Hash value.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(getPriority(), task);
    }
}
