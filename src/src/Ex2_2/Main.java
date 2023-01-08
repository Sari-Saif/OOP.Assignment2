package Ex2_2;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import java.util.concurrent.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
//        Task task = Task.createTask(()->
//        {
//            return "heyyyyyyyyyyyyyyyy";
//        },TaskType.COMPUTATIONAL.getType());
//
//        ExecutorService pool = Executors.newFixedThreadPool(3);
//        Future<String> futurehey = pool.submit(task);
//        String hey;
//
//        try {
//            hey = futurehey.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("sum is: " + hey);
//        pool.shutdown();

//        TaskType tt1 = TaskType.COMPUTATIONAL;
//        System.out.println(tt1);
//
//        TaskType tt2 = TaskType.IO;
//        System.out.println(tt2);
//
//        TaskType tt3 = TaskType.OTHER;
//        System.out.println(tt3);
//
//        System.out.println(tt1.getPriorityValue());
//        System.out.println(tt2.getPriorityValue());
//        System.out.println(tt3.getPriorityValue());
//
//        tt1.setPriority(9);
//        System.out.println(tt1.getPriorityValue());
//        System.out.println(tt1);
//        System.out.println(tt1.getType());
 }
}
