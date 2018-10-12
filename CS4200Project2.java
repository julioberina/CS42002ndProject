
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class Cs420Project2
{
    public static void main(String[] args)
    {
        int n = 21;

          // PriorityQueue<Nqueen> population = new PriorityQueue<Nqueen>(10,(Nqueen a, Nqueen b)
          //         ->{
          //         a.staleCount++;
          //         if(a.value() == b.value()){
          //
          //             return a.staleCount - b.staleCount;
          //         }
          //         return a.value() - b.value();
          //     }) ;


        SimulatedAnnealing sa = new SimulatedAnnealing();
        GeneticAlgorithm da = new GeneticAlgorithm();

        int testCount =1000;

        System.out.println("Testing Simulated Annealing");
        for(int i = 0; i < testCount; ++i)
            d1.execute(new Nqueen(n));

        for(int i=0; i<testCount; ++i)
        {
            System.out.println("Working on Genetic Algorithm");
            System.out.println("Iteration " + i);

            // population.clear()
            for(int j=0; j<500; j++)
            {
                population.add(new Nqueen(n));
            }
            da.execute(population);
        }

        System.out.println("Simulated Annealing average cost: " + sa.getAveCost() + "\n");
        System.out.println("Genetic Algorithm average cost: " + da.getAveCost());
        System.out.println("Genetic Algorithm success rate: " + da.successRate() + "%");
        System.out.println("Genetic Algorithm success total: " + da.successCount());
    }
}
