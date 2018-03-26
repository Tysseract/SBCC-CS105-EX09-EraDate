package unittest.cs105;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.sbcc.cs105.EraDate;

public class EraDateTester {
	private static final int maximumScore = 8;
	private static final int maximumAssignmentScore = 16;
	private static int totalScore;

	@BeforeClass
	public static void beforeTesting() {
		totalScore = 0;
	}

	@AfterClass
	public static void afterTesting() {
		System.out.printf("Your program's functionality scores %d out of %d.\n\n", totalScore, maximumScore);

		int difference = maximumAssignmentScore - maximumScore;
		String correctedPoint = (difference == 1) ? "point" : "points";

		System.out.printf("The assignment is worth a total of %d where the remainder of %d %s\n",
				maximumAssignmentScore, difference, correctedPoint);
		System.out.println("comes from grading related to documentation, algorithms, and other");
		System.out.println("criteria.");
	}

	@Test
	public void testJapaneseMeijiEra() {
		assertEquals("Era should be Meiji", "Meiji", EraDate.getEra(23, 10, 1868));
		assertEquals("Check your months to make sure you are subtracting 1 in the constructor.", "Meiji", EraDate.getEra(29, 7, 1912));		
		assertEquals("Check your months to make sure you are subtracting 1 in the constructor.", "Meiji", EraDate.getEra(1, 1, 1900));
		
		totalScore += 2;
	}

	@Test
	public void testJapaneseTaishoEra() {
		assertEquals("Check the month in the constructor", "Taisho", EraDate.getEra( 1,  8, 1912));
		assertEquals("Check the month in the constructor", "Taisho", EraDate.getEra(24, 12, 1926));
		assertEquals("Check the month in the constructor", "Taisho", EraDate.getEra( 1,  1, 1922));
		
		totalScore += 2;
	}

	@Test
	public void testJapaneseShowaEra() {
		assertEquals("Check the month in the constructor", "Showa", EraDate.getEra(26, 12, 1926));
		assertEquals("Check the month in the constructor", "Showa", EraDate.getEra( 7,  1, 1989));
		assertEquals("Check the month in the constructor", "Showa", EraDate.getEra( 1,  1, 1950));
		
		totalScore += 2;
	}

	/**
	 * Returns the Japanese era for the internal date structure. We use the
	 * following dates: Meiji - 9/8/1868 - 7/30/1912 Taisho - 8/1/1912 -
	 * 12/25/1926 Showa - 12/26/1926 - 1/7/1989 Heisei - 1/8/1989 - present Note
	 * that these dates are not the actual dates since those dates overlap by a
	 * day
	 *
	 */
	@Test
	public void testJapaneseHeiseiEra() {
		assertEquals("Check the month in the constructor", "Heisei", EraDate.getEra(8, 1, 1989));
		assertEquals("Check the month in the constructor", "Heisei", EraDate.getEra(1, 1, 2014));
		
		totalScore += 2;
	}
}
