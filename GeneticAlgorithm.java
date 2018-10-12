import java.util.PriorityQueue;
import java.util.Random;

public class GeneticDriver
{
    private static Random rand = new Random();
    private static Timer timer = new Timer();
    private static PriorityQueue<NQueen> population = new PriorityQueue<NQueen>(10, (NQueen a, NQueen b)
           ->{
           a.mature();
           if(a.clashes() == b.clashes()){

               return a.age() - b.age();
           }
           return a.clashes() - b.clashes();
    });

    public NQueen execute()
    {
        population.clear();

        for(int j = 0; j < 500; ++j)
            population.add(new NQueen(n));

        NQueen current = population.peek();

        timer.startTime();
        int max = 1000000;
        while (current.clashes() != 0 && max > 0)
        {
            --max;
            timer.incTotalCostBy(1);
            NQueen x = pop.poll();
            NQueen y = pop.poll();
            NQueen child = x.reproduce(y);

            if (child.clashes() == 0)
            {
                current = child;
                break;
            }
            if (rand.nextInt(100) < 5)
                child.mutate();
            if (child.clashes() == 0)
            {
                current = child;
                break;
            }

            pop.add(x);
            pop.add(y);
            pop.add(child);
        }

        timer.endTime();
        if (current.clashes()==0)   timer.incSuccessCount();
        return current;
    }
}
