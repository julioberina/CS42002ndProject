public class Timer
{
    private int size;
    private long totalCost;
    private long totalTime;
    private long temp;
    private int successCount;

    public Timing()
    {
        size = 0;
        totalCost = 0;
        totalTime = 0;
        temp = 0;
    }
    public long getAveCost()
    {
        return totalCost/size;
    }

    public void incTotalCostBy(int num)
    {
        totalCost += num;
    }

    public void incSize()
    {
        ++size;
    }

    public void startTime()
    {
        temp = System.nanoTime();
    }

    public void endTime()
    {
        totalTime += temp - System.nanoTime();
    }

    public void incSuccessCount()
    {
        ++successCount;
    }

    public long getAveTime()
    {
        return totalTime / size;
    }

    public double successRate()
    {
        return ((double)successCount/(double)size)*100;
    }

    public double successCount()
    {
        return successCount;
    }
}
