package week05;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Week05JUnitTest
{
	private int side1 = 0;
	private int side2 = 0;
	private int side3 = 0;
	private int side4 = 0;
	private int side5 = 0;
	private int side6 = 0;
	private double sumOfNumbers = 0;
	private ArrayList<Integer> percentageSides = new ArrayList<>();

	@Test
	public void testMultipleDie()
	{
		Die die = new Die(true);
		Die die2 = new Die(true);

		assertFalse(die.equals(die2));
		assertFalse(die2.equals(die));
	}

	@Test
	public void testRandomDie()
	{

		for(int x = 0; x < 1000; x++)
		{

			Die die = new Die(true);
			int dieNum = die.getNumber();
			if(dieNum == 1)
			{
				side1++;
			}
			else if(dieNum == 2)
			{
				side2++;
			}
			else if(dieNum == 3)
			{
				side3++;
			}
			else if(dieNum == 4)
			{
				side4++;
			}
			else if(dieNum == 5)
			{
				side5++;
			}
			else if(dieNum == 6)
			{
				side6++;
			}
			else
			{
				System.out.println("Die Not Rolled" + dieNum);
			}
		}
		// Loading ArrayList<Integer> with side roll totals.
		ArrayList<Integer> dieSides = new ArrayList<>(
				Arrays.asList(side1, side2, side3, side4, side5, side6));

		// Calculating Sum with of total sides.
		int sum = dieSides.stream().mapToInt(Integer::intValue).sum();

		// Calculating mean of side totals.
		int meanOfSides = (side1 + side2 + side3 + side4 + side5 + side6) / 6;

		/*
		 * Formatting standard deviation result
		 */
		String stdDeviationResult = String.format("%.2f",
				stdDeviation(dieSides, meanOfSides));

		System.out.println(" side totals (1-6): " + dieSides + "\n"
				+ " Distribution Percent: " + calcPercentages(dieSides, sum)
				+ "\n " + "Mean: " + meanOfSides + ", Standard Deviation: "
				+ stdDeviationResult);
	}

	/*
	 * Calculating Percentage of Sum of ArrayList<Integer>
	 */
	private ArrayList<Integer> calcPercentages(ArrayList<Integer> dieSides,
			int sum)
	{

		for(int i = 0; i < dieSides.size(); i++)
		{
			int percent = dieSides.get(i) * 100 / sum;
			percentageSides.add(percent);
		}
		return percentageSides;
	}

	/*
	 * Calculating Standard Deviation of ArrayList<Integer> no formatting
	 */
	private double stdDeviation(ArrayList<Integer> dieSides, int mean)
	{
		for(int i = 0; i < dieSides.size(); i++)
		{
			int newNumber = (int)Math.pow(dieSides.get(i) - mean, 2);
			sumOfNumbers += newNumber;
		}
		double meanOfSquaredDiff = sumOfNumbers / 6;
		return Math.sqrt(meanOfSquaredDiff);
	}
}
