public class SimulatedAnnealing
{
    public static Timer timer = new Timer();

    public NQueen execute(NQueen n)
    {
        NQueen nextState;
        NQueen currentState = n;

        int count = 0;
        double delta, probability, rand;

        timer.startTime();

        while (currentState.clashes() != 0)
        {
            for (double time = 1.0; time < 1000.0; ++time)
            {
                nextState = currentState.randomChild();
                delta = currentState.clashes() - nextState.clashes();
                probability = Math.exp(delta / schedule(time));
                rand = Math.random();

                if (delta > 0 || rand <= probability)
                    currentState = nextState;

                ++count;
            }
        }

        timer.incTotalCostBy(count);
        timer.endTime();
        timer.incSize();
        return currentState;
    }

    private static double schedule(double x)
    {
        return 1.0 / x;
    }
}
