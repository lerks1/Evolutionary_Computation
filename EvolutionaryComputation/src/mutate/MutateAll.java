package mutate;

import nz.ac.vuw.kol.OptimisationFunction;

/**
 This class generates a best output (and corresponding values) against the unknown function. The constructor is
 parameterized to allow for customizable size, generations and mutation percentage. Getters are available for the values.
*/
public class MutateAll implements Mutate
{
	private MutateTools m = new MutateTools();
	private double[] values;
	private double output;
	
	/**Constructor - Simulates successive generations of mutation as per the size, generations and percentage parameters.
	 * 
	 * @param size - Quantity of numbers in the input arrays.
	 * @param generations - Number of successive generations to simulate.
	 * @param percentage - Percentage limit on mutations.
	 */
	public MutateAll(int size, int generations, double percentage)
	{
		double[] bestValues = m.getRandomValues(size);
		double bestOutput = OptimisationFunction.unknownFunction(bestValues);
		
		for (int i = 0; i < generations; i++)
		{
			values = m.mutateAllByBounds(bestValues, percentage);
			output = OptimisationFunction.unknownFunction(values);
			
			if (output < bestOutput)
			{
				bestValues = m.copyArray(values);
				bestOutput = output;
			}
		}
		
		//Assigns best values to fields 'values' and 'output' for later use (accessed via getters).
		values = m.copyArray(bestValues);
		output = bestOutput;
	}
	
	//Returns the input numbers that resulted in the best unknown function output.
	public double[] getValues()
	{
		return values;
	}

	//Returns the best unknown function output.
	public double getOutput()
	{
		return output;
	}
	
}
