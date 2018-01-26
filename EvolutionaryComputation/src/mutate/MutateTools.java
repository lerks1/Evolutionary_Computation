package mutate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Class which contains various methods utilised by the implementations of the Mutation interface. General tools of sorts.
 */
public class MutateTools 
{
	private Random r = new Random();
	
	//Represents the largest (abs value) and smallest value of doubles to be generated.
    private int bounds = -1;
	
    //Returns a random double within the bounds as defined above.
    public double getRandom()
	{
		return bounds + (Math.abs(bounds) * 2) * r.nextDouble();
	}
	
    //Returns an array of random values (doubles) of a specified size (parameter).
    //Range of values determined by the getRandom method currently set to bounds.
	public double[] getRandomValues(int qty)
	{
		double[] out = new double[qty];
		
		for (int i = 0; i < qty; i ++)
		{
			out[i] = getRandom();
		}
		return out;
	}
	
	//Mutates a value (positively or negatively alters) by a random percentage
	//between 0 and a specified value as a percentage of the bounds (for mutation size consistency).
	public double mutateByBounds(double value, double percentage)
	{
		double changeRange = Math.abs(bounds) * (percentage / 100);
		return value + (-changeRange + (changeRange * 2) * r.nextDouble());
	}
		
	//Mutates all items in an array by a specified percentage of the bounds.
	public double[] mutateAllByBounds(double[] values, double percentage)
	{
		double [] out = copyArray(values);
		for (int i = 0; i < values.length; i ++)
		{
			out[i] = mutateByBounds(values[i], percentage);
		}
		return out;
	}
	
	//Mutates a designated number of array items (selected randomly) by a specified percentage of the bounds.
	public double[] mutateNumByBounds(double[] values, double percentage, double num)
	{
		double[] out = copyArray(values);
		ArrayList <Integer> numbers = new ArrayList<Integer>();
			
		//Adds random indexes in a quantity specified by the 'num' parameter.
		for (int i = 0; i < num; i++)
		{
			int index = (int)(Math.random() * values.length);
			//Checks for double ups.
			while (numbers.contains(index))
			{
				index = (int)(Math.random() * values.length);
			}
			numbers.add(index);
		}
			
		for (int i = 0; i < values.length; i ++)
		{
			if (numbers.contains((Integer)i))
			{
				out[i] = mutateByBounds(values[i], percentage);
			}
		}
		return out;
	}
	
	//Used to copy arrays between generations.
	public double[] copyArray(double[] toCopy)
	{
		double[] out = new double[toCopy.length];
		
	    for (int i = 0; i < toCopy.length; i++)
	    {
	    	out[i] = toCopy[i];
	    }
	    return out;
	}
	
	//Prints values in an array to the console.
	public void printMutate(Mutate m)
	{
		System.out.print("Lowest Result: " + m.getOutput() + " from values: ");
		for (double d : m.getValues())
		{
			System.out.print(d + " ");
		}
		System.out.println("");
	}
}
