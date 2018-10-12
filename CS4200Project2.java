
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class CS4200Project2
{
    public static void main(String[] args)
    {
        int n = 21;

        SimulatedAnnealing sa = new SimulatedAnnealing();
        GeneticAlgorithm ga = new GeneticAlgorithm();

        if (args.length > 0 && args[0].equals("test"))
        {
            int testCount = 1000;

            System.out.println("Testing Simulated Annealing...");
            for(int i = 0; i < testCount; ++i)
                sa.execute(new NQueen(n));

            System.out.println("Testing Genetic Algorithm...");
            for(int i = 0; i < testCount; ++i)
            {
                System.out.println("Iteration " + i);
                ga.execute();
            }

            System.out.println("Simulated Annealing average cost: " + sa.timer.getAveCost() + "\n");
            System.out.println("Genetic Algorithm average cost: " + ga.timer.getAveCost());
            System.out.println("Genetic Algorithm success rate: " + ga.timer.successRate() + "%");
            System.out.println("Genetic Algorithm success total: " + ga.timer.successCount());
        }
        else
        {
            System.out.println("Simulated Annealing Final Configuration:");
            sa.execute(new NQueen(n)).print();

            System.out.print("\n");
            System.out.println("------------------------------------------------------\n");

            System.out.println("Genetic Algorithm Final Configuration:");
            ga.execute().print();
        }
    }
}
