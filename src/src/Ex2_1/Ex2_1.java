package Ex2_1;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex2_1
{
    public static String[] createTextFiles(int n, int seed, int bound)
    {
        String[] textFileNames = new String[n];

        // create random generator for number of lines in each file
        Random rand = new Random(seed);

        // create n files
        for(int i = 0; i < n; i++)
        {
            int numOfLines = rand.nextInt(bound);

            try
            {
                // create new file
                FileWriter fileWriter_i = new FileWriter("text_files\\file_" + (i+1) + ".txt");

                // append random nunber of lines to the file.
                for(int j = 0; j < numOfLines; j++)
                {
                    fileWriter_i.write("Line number " + (j+1) + "\n");
                }

                fileWriter_i.close();

                // save the file name.
                textFileNames[i] = "text_files\\file_" + (i+1) + ".txt";

            }catch (Exception e){}
        }

        return textFileNames;
    }

    public static int getNumOfLines(String[] fileNames)
    {
        int numOfLines = 0 ;
        for ( String name : fileNames)
        {
           try
           {
               // read the specific file
               BufferedReader fileReader = new BufferedReader(new FileReader(name));
               // get number of files by streaming
               numOfLines += fileReader.lines().count();
               fileReader.close();
           }

           catch (Exception e)
           {
               System.out.println(e.getMessage());
           }

        }
        return numOfLines;
    }

    public static int getNumOfLinesThreads(String[] fileNames)
    {
        int counterNumOfLines = 0;

        GetNumOfLinesThread[]  arrGetNumOfLinesThread = new GetNumOfLinesThread[fileNames.length];

       for(int i = 0; i < fileNames.length; i++)
       {
           arrGetNumOfLinesThread[i] = new GetNumOfLinesThread(fileNames[i]);
           arrGetNumOfLinesThread[i].start();
       }

        for(int i = 0; i < fileNames.length; i++)
        {
            try
            {
                arrGetNumOfLinesThread[i].join();
                counterNumOfLines += arrGetNumOfLinesThread[i].get_numOfLines();
            }catch(Exception e){}
        }

        return counterNumOfLines;
    }

    public static int getNumOfLinesThreadPool(String[] fileNames)
    {
        int numOfLines = 0;

        // create ThreadPool with length of filenames.length
        ExecutorService pool = Executors.newFixedThreadPool(fileNames.length);

        // create array of Future<int> with length of filename.length
        Future<Integer>[] numOfLinesPerThread = new Future[fileNames.length];

        // create array that submit all our-callable with the filename
        for(int i = 0; i < fileNames.length; i++)
        {
            numOfLinesPerThread[i] = pool.submit(new GetNumOfLinesThreadPool(fileNames[i]));
        }

        // for each Future<int> in the arr, get and sum the value.
        for(Future<Integer> numOfLinesCurrThread: numOfLinesPerThread)
        {
            try {
                numOfLines += numOfLinesCurrThread.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return numOfLines;
    }
}
