package Ex2_2;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

class CustomExecutorTest {

    @Test
    void submit()
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
        Callable<String> callablestr = ()->{
            String str = "";
            for (int i = 0;i<4;i++){
                if (i == 0)
                {
                    str +='s';
                }
                if (1 ==i)
                {
                    str +='a';
                }
                if (i == 2)
                {
                    str +='r';
                }
                if (i == 3)
                {
                    str +='i';
                }
            }
            return str;
        };
        Callable<Integer> callable2 = ()->{
            int sum = 10;
            int i = 10;
            while (i>0)
            {
                sum*=10;
                i-=1;
            }
            return sum;
        };

        //TaskType taskType0 = TaskType.COMPUTATIONAL;
        //  TaskType taskType1 = TaskType.COMPUTATIONAL;
       // TaskType taskType2 = TaskType.COMPUTATIONAL;

        Task<Integer> task0 = Task.createTask(callable);
        Task<Integer> task1= Task.createTask(callable);
        Task<String> task2 = Task.createTask(callablestr);


        CustomExecutor customExecutor = new CustomExecutor();
        Future<Integer> future0 =  customExecutor.submit(task0);
        Future<Integer> future1 = customExecutor.submit(task1);
        Future<String> future2  = customExecutor.submit(task2);




        try
        {

        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }


    }


    @Test
    void testSubmit() {
    }

    @Test
    void testSubmit1() {
    }

    @Test
    void gracefullyTerminate() {
    }
}