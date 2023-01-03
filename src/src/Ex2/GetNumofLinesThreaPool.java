package Ex2;

import java.util.concurrent.Callable;

public class GetNumofLinesThreaPool implements Callable<Integer>
{
     private String filename;

    public GetNumofLinesThreaPool(String filename)
    {
        this.filename = filename;

    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception
    {

        return null;
    }
}
