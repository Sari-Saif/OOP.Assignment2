package Ex2_2;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void createTask()
    {
        Callable<Integer> callable1 = ()-> {
            return 1000 ;
        };
        TaskType taskType = TaskType.COMPUTATIONAL;
        Task<Integer> task = Task.createTask(callable1,taskType); // initial
        Task<Integer> task0 = Task.createTask(callable1); // default
        TaskType taskType1 = task.getPriority();
        TaskType taskType2 = task0.getPriority();

        int pr = taskType1.getPriorityValue();
        int pr1 = taskType2.getPriorityValue();
        assertTrue(3 ==  pr1);
        assertFalse(3 !=  pr1);
        assertEquals( pr,1 );

    }

    @Test
    void testCreateTask() {
    }

    @Test
    void getPriority() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void call() {
    }
}