package Ex2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main
{
public static  void main(String[] args)
{
    String customExecutor=null ;
    CustomExecutor customExecutor1 = new CustomExecutor();

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

    Future<String> futurestr = customExecutor1.submit(callablestr);
    Future<Integer> future = customExecutor1.submit(callable);
    customExecutor = customExecutor1.toString();
    System.out.println("before get operations  : " + customExecutor);
    try
    {
        customExecutor = customExecutor1.toString();
        System.out.println("active tasks : " + customExecutor);
        str = futurestr.get();
        customExecutor = customExecutor1.toString();
        System.out.println("task number one is done  : " + customExecutor);
        sum = future.get();
        customExecutor = customExecutor1.toString();
        System.out.println("after tasks : " + customExecutor);
    } catch (InterruptedException e)
    {
        throw new RuntimeException(e);
    } catch (ExecutionException e)
    {
        throw new RuntimeException(e);
    }
    customExecutor = customExecutor1.toString();
    System.out.println( "after task  " + customExecutor);
    customExecutor1.gracefullyTerminate();

}
}
