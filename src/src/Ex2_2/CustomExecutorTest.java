package Ex2_2;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
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


        Task<Integer> task0 = Task.createTask(callable);
        Task<Integer> task1= Task.createTask(callable2);
        Task<String> task2 = Task.createTask(callablestr);


        CustomExecutor customExecutor = new CustomExecutor();
        Future<Integer> future0 =  customExecutor.submit(task0);
        Future<Integer> future1 = customExecutor.submit(task1);
        Future<String> future2  = customExecutor.submit(task2);

        final String str;
        final int sumOftens;
        final int orginalSum;
        try
        {
            orginalSum = future0.get();
            sumOftens = future1.get();
             str = future2.get();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        } catch (ExecutionException e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("sari",str);
        assertEquals(1215752192,sumOftens);
        assertEquals(20,orginalSum);

    }


    @Test
    void testSubmit()
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
            for (int i = 1;i<10;i++){
                str +='a';
            }
            return str;
        };
        final String str;
        final int sum;

        TaskType taskoth = TaskType.OTHER;
        TaskType taskcomp = TaskType.COMPUTATIONAL;

        CustomExecutor customExecutor = new CustomExecutor();
        Future<String> futurestr = customExecutor.submit(callablestr, taskoth);
        Future<Integer> future = customExecutor.submit(callable, taskcomp);

        try
        {
            str = futurestr.get();
            sum = future.get();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        } catch (ExecutionException e)
        {
            throw new RuntimeException(e);
        }


        assertEquals("aaaaaaaaa",str);
        assertEquals(20,sum);


    }

    @Test
    void testSubmit1()
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
            for (int i = 1;i<10;i++){
                str +='a';
            }
            return str;
        };
        final String str;
        final int sum;

        CustomExecutor customExecutor = new CustomExecutor();
        Future<String> futurestr = customExecutor.submit(callablestr);
        Future<Integer> future = customExecutor.submit(callable);

        try
        {
            str = futurestr.get();
            sum = future.get();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        } catch (ExecutionException e)
        {
            throw new RuntimeException(e);
        }


        assertEquals("aaaaaaaaa",str);
        assertEquals(20,sum);

    }

    @Test
    void gracefullyTerminate()
    {


        Callable<Double> callable =()->{
            double kilm = 67;
             return kilm*0.62137;
        };
        Callable<Integer> callable1 = ()->{
            String projectname = "Customer Threadpool";
            int sumOfAsciiValues =0 ;
            for (int i =0;i<projectname.length();i++)
            {
                char c = projectname.charAt(i);
                int asciivalue = (int)c;
                sumOfAsciiValues+=asciivalue;
            }
            return sumOfAsciiValues;
        };
        final int ascii;
        final double km ;
        boolean isShutDown;


        CustomExecutor customExecutor = new CustomExecutor();
        Future<Double> futureKm = customExecutor.submit(callable);
        Future<Integer> futureAscii = customExecutor.submit(callable1);
        customExecutor.gracefullyTerminate();

        try
        {
            km = futureKm.get();
            ascii = futureAscii.get();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        } catch (ExecutionException e)
        {
            throw new RuntimeException(e);
        }
        isShutDown = customExecutor.isShutDown();
        assertEquals(1924,ascii);
        assertEquals(41.631789999999995,km);
        assertTrue(isShutDown);


    }


}