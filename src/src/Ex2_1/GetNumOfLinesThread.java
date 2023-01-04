package Ex2_1;

public class GetNumOfLinesThread extends Thread
{
    int numberOflines;
    String filename;
    public GetNumOfLinesThread(String fileName)
    {
        this.filename = fileName;
    }
    public int get_numOfLines()
    {
        return this.numberOflines;
    }

    @Override
    public void run()
    {
        String[] arrWithOneFilename = new String[1];
        arrWithOneFilename[0] = this.filename;
        numberOflines = Ex2_1.getNumOfLines(arrWithOneFilename);
    }
}
