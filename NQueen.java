import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class NQueen
{
    private int n;
    private int[] state;
    private int clashes;
    private int age = 0;
    private static Random rand = new Random();

    public NQueen (int[] state)
    {
        this.state = state;
        this.n = state.length;
        this.clashes = calcClashes();
    }

    public NQueen(int size)
    {
        this.state = new int[size];
        this.n = size;

        ArrayList<Integer> test = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i)
            test.add(i);

        Collections.shuffle(test, rand);

        for (int j = 0; j < test.size(); ++j)
            state[j] = test.get(j);

        this.clashes = calcClashes();
    }

    public NQueen randomChild()
    {
        int col = rand.nextInt(n);
        int row = rand.nextInt(n);

        while (row == state[col])
            row = rand.nextInt(n);

        int [] newState = state.clone();
        newState[col] = row;

        return new NQueen(newState);
    }

    public int age()
    {
        return this.age;
    }

    public int clashes()
    {
        return this.clashes;
    }

    public int[] getState()
    {
        return state;
    }

    private int calcClashes()
    {
        int clash = 0;

        for (int i = 0; i < state.length; ++i)
        {
            for (int j = 0; j < state.length; ++j)
            {
                if (i==j)   continue;
                else if (state[i] == state[j] || Math.abs(j-i) == Math.abs(state[j] - state[i]))
                {
                    ++clash;
                    break;
                }
            }
        }

        return clash;
    }

    public void print()
    {
        for (int i = 0; i < state.length; ++i)
        {
            for (int j = 0; j < state.length; ++j)
                System.out.print(state[j] == i ? "Q " : "- ");

            System.out.print('\n');
        }
    }

    public void mutate()
    {
        int pos = rand.nextInt(n);
        int val = rand.nextInt(n);

        while (state[pos] == val)
            val = rand.nextInt(n);

        state[pos] = val;
    }

    public void mature()
    {
        ++age;
    }

    public NQueen reproduce(NQueen mate)
    {
        int roll = rand.nextInt(n);

        int[] mateState = mate.getState();
        int[] child = new int[n];

        for (int i=0; i<n; i++)
            child[i] = (i < roll) ? state[i] : mateState[i];

        return new NQueen(child);
    }
}
