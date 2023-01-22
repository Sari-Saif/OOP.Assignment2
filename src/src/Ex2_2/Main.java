package Ex2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main
{
    public static  void main(String[] args)
    {
        CustomExecutor customExecutor1 = new CustomExecutor();
        TaskType tt1 = TaskType.COMPUTATIONAL;
        tt1.setPriority(1);
        TaskType tt2 = TaskType.COMPUTATIONAL;
        tt2.setPriority(2);
        TaskType tt3 = TaskType.COMPUTATIONAL;
        tt3.setPriority(3);
        TaskType tt4 = TaskType.COMPUTATIONAL;
        tt4.setPriority(4);
        TaskType tt5 = TaskType.COMPUTATIONAL;
        tt5.setPriority(5);

        Task<Integer> t1 = Task.createTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception
            {
                System.out.println("priority 1 start");
                Thread.sleep(3000);
                System.out.println("priority 1 end");
                return 1;
            }
        }, tt1);

        Task<Integer> t2 = Task.createTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception
            {
                System.out.println("priority 2 start");
                Thread.sleep(3000);
                System.out.println("priority 2 end");
                return 2;
            }
        }, tt2);


        Task<Integer> t3 = Task.createTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception
            {
                System.out.println("priority 3 start");
                Thread.sleep(3000);
                System.out.println("priority 3 end");
                return 3;
            }
        }, tt3);


        Task<Integer> t4 = Task.createTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception
            {
                System.out.println("priority 4 start");
                Thread.sleep(3000);
                System.out.println("priority 4 end");
                return 4;
            }
        }, tt4);


        Task<Integer> t5 = Task.createTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception
            {
                System.out.println("priority 5 start");
                Thread.sleep(3000);
                System.out.println("priority 5 end");
                return 5;
            }
        }, tt5);


        //customExecutor1.submit(t5);
        customExecutor1.submit(t4);
        customExecutor1.submit(t3);
        customExecutor1.submit(t2);
        customExecutor1.submit(t1);



        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(customExecutor1.getCurrentMax());
        customExecutor1.gracefullyTerminate();
    }
}

