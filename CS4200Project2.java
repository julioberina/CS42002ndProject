
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

        SimulatedAnnealing sa = new SimulatedAnnealing();
        GeneticAlgorithm da = new GeneticAlgorithm();

        int testCount = 1000;

        System.out.println("Testing Simulated Annealing...");
        for(int i = 0; i < testCount; ++i)
            sa.execute(new NQueen(n));

        System.out.println("Testing Genetic Algorithm...");
        for(int i = 0; i < testCount; ++i)
        {
            System.out.println("Iteration " + i);
            da.execute();
        }

        System.out.println("Simulated Annealing average cost: " + sa.getAveCost() + "\n");
        System.out.println("Genetic Algorithm average cost: " + da.getAveCost());
        System.out.println("Genetic Algorithm success rate: " + da.successRate() + "%");
        System.out.println("Genetic Algorithm success total: " + da.successCount());
    }
}
