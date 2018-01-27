package runnable;

import mutate.MutateSome;
import mutate.MutateTools;

/**
 *Class to test the MutateSome function. Configured in this instance to compare 5 number 
 *arrays with 1, 2 and 3 mutated items per generation.
 *
 *Evolutionary goal is lowest result.
 */
public class MutateSomeTest 
{
	static MutateTools m = new MutateTools();
	
	public static void main(String[] args) 
	{
		//5 numbers, ten thousand generations, 5% mutation, 1 array item mutated per generation.
		MutateSome m1 = new MutateSome(5, 10000, 5, 1);
		m.printMutate(m1);
		
		//5 numbers, ten thousand generations, 5% mutation, 2 array items mutated per generation.
		MutateSome m2 = new MutateSome(5, 10000, 5, 2);
		m.printMutate(m2);
		
		//5 numbers, ten thousand generations, 5% mutation, 3 array items mutated per generation.
		MutateSome m3 = new MutateSome(5, 10000, 5, 3);
		m.printMutate(m3);
	}
}
