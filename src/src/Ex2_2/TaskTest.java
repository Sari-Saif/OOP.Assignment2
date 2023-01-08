package Ex2_2;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void createTask()
    {
        Callable<Integer> callable1 = ()-> {
            return 1000 ;
        };
        TaskType taskType = TaskType.COMPUTATIONAL;
        Task<Integer> task = Task.createTask(callable1,taskType);
        Task<Integer> task0 = Task.createTask(callable1);
        TaskType taskType1 = task.getPriority();
        TaskType taskType2 = task0.getPriority();

        int pr = taskType1.getPriorityValue();
        int pr1 = taskType2.getPriorityValue();
        assertEquals(3, pr1);
        assertNotEquals(2, pr1);
        assertEquals( pr,1 );

    }

    @Test
    void testCreateTask()
    {
        Callable<Integer> callable1 = ()-> {
            return 1000*2 ;
        };

        TaskType task = TaskType.IO;
        TaskType taskType = TaskType.COMPUTATIONAL;

        Task<Integer> task0 = Task.createTask(callable1,taskType);
        Task<Integer> task1 = Task.createTask(callable1,task);
        Task<Integer> task2 = Task.createTask(callable1);

        TaskType taskType1 = task0.getPriority();
        TaskType taskType2 = task1.getPriority();
        TaskType taskType3 = task2.getPriority();

        int pr = taskType1.getPriorityValue();
        int pr1 = taskType2.getPriorityValue();
        int pr2 = taskType3.getPriorityValue();

        assertNotEquals(pr, pr1);
        assertNotEquals(pr2, pr1);
        assertEquals(2, pr1);
    }

    @Test
    void getPriority() {
        Callable<Integer> callable1 = ()-> {
         int sum = 0 ;
         for (int i=0 ; i<1000 ; i++)
         {
             sum += i*3;
         }
            return sum ;
        };

        TaskType task = TaskType.IO;//2
        TaskType taskType = TaskType.COMPUTATIONAL;//1

        Task<Integer> task0 = Task.createTask(callable1,taskType);//1
        Task<Integer> task1 = Task.createTask(callable1,task); //2
        Task<Integer> task2 = Task.createTask(callable1);

        TaskType taskType1 = task0.getPriority();//1
        TaskType taskType2 = task1.getPriority();//2
        TaskType taskType3 = task2.getPriority();//3

        int pr = taskType1.getPriorityValue();//1
        int pr1 = taskType2.getPriorityValue();//2
        int pr2 = taskType3.getPriorityValue();//3

        assertEquals(pr +1 , pr1);
        assertNotEquals(pr2, pr1);
        assertEquals(3, pr2);

    }

    @Test
    void compareTo()
    {
        Callable<Integer> callable2 = ()->{
            int sum = 10;
            int i = 10;
            while (i>0)
            {
                sum*=sum;
            }
            return sum;
        };
        TaskType taskType = TaskType.IO;
        TaskType taskType1 = TaskType.COMPUTATIONAL;
        TaskType taskType2 = TaskType.COMPUTATIONAL;

        int compare = taskType.compareTo(taskType1);
        int compare1 = taskType1.compareTo(taskType2);
        //Task<Integer> task = Task.createTask(callable2,taskType);
        assertNotEquals(0,compare);
        assertEquals(0,compare1);
    }

    @Test
    void call()
    {
        Callable<Integer> callable = ()->{
            int sum = 10;
            int i = 10;
            while (i>0)
            {
                sum+=1;
                i-=1;
            }
            return sum;
        };
        TaskType taskType = TaskType.COMPUTATIONAL;
        Task<Integer> task = Task.createTask(callable,taskType); // initial
        CustomExecutor customExecutor = new CustomExecutor();
        int call;
        try
        {
            call = task.call();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        assertEquals(20,call);
    }
}