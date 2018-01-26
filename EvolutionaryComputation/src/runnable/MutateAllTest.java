package runnable;

import mutate.MutateAll;
import mutate.MutateTools;

/**
 *Class to test the MutateAll function. Configured in this instance to compare 1, 2 and 3 number arrays.
 *
 *Evolutionary goal is lowest result.
 */
public class MutateAllTest 
{
	static MutateTools m = new MutateTools();
	
	public static void main(String[] args) 
	{
		//1 number, ten thousand generations, 5% mutation.
		MutateAll m1 = new MutateAll(1, 10000, 5);
		m.printMutate(m1);
		
		//2 numbers, ten thousand generations, 5% mutation.
		MutateAll m2 = new MutateAll(2, 10000, 5);
		m.printMutate(m2);
		
		//3 numbers, ten thousand generations, 5% mutation.
		MutateAll m3 = new MutateAll(3, 10000, 5);
		m.printMutate(m3);
	}
}
