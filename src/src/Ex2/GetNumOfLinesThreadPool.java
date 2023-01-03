package Ex2;

import java.util.concurrent.Callable;

public class GetNumOfLinesThreadPool implements Callable<Integer>
{
     private String filename;

    public GetNumOfLinesThreadPool(String filename)
    {
        this.filename = filename;

    }
    
    @Override
    public Integer call() throws Exception
    {

        return null;
    }
}
