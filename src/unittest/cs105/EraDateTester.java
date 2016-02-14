package unittest.cs105;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.sbcc.cs105.Main;

public class EraDateTester {
	private static final int maximumScore = 8;
	private static final int maximumAssignmentScore = 16;
	private static int totalScore;

	private PrintStream oldOut;
	private InputStream oldIn;
	private ByteArrayOutputStream baos;
	private ByteArrayInputStream bais;

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

	@Before
	public void setUp() {
		this.baos = new ByteArrayOutputStream();
		this.oldOut = System.out;
		this.oldIn  = System.in;
		System.setOut(new PrintStream(baos));

	}

	@After
	public void tearDown() {
		System.setOut(this.oldOut);
		System.setIn(this.oldIn);
		
		this.baos.reset();
	}
	
	private void runTest(int year, int month, int day) {
		this.bais = new ByteArrayInputStream((year + "\n" + month + "\n" + day + "\n").getBytes());
		System.setIn(this.bais);	
		
		Main.main(null);
		System.out.flush();
	}


	@Test
	public void testJapaneseMeijiEra() {
		runTest(1868, 9, 8);
		assertEquals("Era should be Meiji", "Enter a year: Enter a month: Enter a day: Meiji\n", this.baos.toString());
		this.baos.reset();
		
		runTest(1912, 7, 30);
		assertEquals("Check your months to make sure you are subtracting 1 in the constructor.", "Enter a year: Enter a month: Enter a day: Meiji\n",
				this.baos.toString());
		this.baos.reset();
		
		runTest(1900, 1, 1);
		assertEquals("Check your months to make sure you are subtracting 1 in the constructor.", "Enter a year: Enter a month: Enter a day: Meiji\n",
				this.baos.toString());
		
		totalScore += 2;
	}

	@Test
	public void testJapaneseTaishoEra() {
		runTest(1912, 8, 1);
		assertEquals("Check the month in the constructor", "Enter a year: Enter a month: Enter a day: Taisho\n", this.baos.toString());
		this.baos.reset();
		
		runTest(1926, 12, 25);
		assertEquals("Check the month in the constructor", "Enter a year: Enter a month: Enter a day: Taisho\n", this.baos.toString());
		this.baos.reset();
		
		runTest(1922, 1, 1);
		assertEquals("Check the month in the constructor", "Enter a year: Enter a month: Enter a day: Taisho\n", this.baos.toString());
		
		totalScore += 2;
	}

	@Test
	public void testJapaneseShowaEra() {
		runTest(1926, 12, 26);
		assertEquals("Check the month in the constructor", "Enter a year: Enter a month: Enter a day: Showa\n", this.baos.toString());
		this.baos.reset();
		
		runTest(1989, 1, 7);
		assertEquals("Check the month in the constructor", "Enter a year: Enter a month: Enter a day: Showa\n", this.baos.toString());
		this.baos.reset();
		
		runTest(1950, 1, 1);
		assertEquals("Check the month in the constructor", "Enter a year: Enter a month: Enter a day: Showa\n", this.baos.toString());
		
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
		runTest(1989, 1, 8);
		assertEquals("Check the month in the constructor", "Enter a year: Enter a month: Enter a day: Heisei\n", this.baos.toString());
		this.baos.reset();
		
		runTest(2014, 1, 1);
		assertEquals("Check the month in the constructor", "Enter a year: Enter a month: Enter a day: Heisei\n", this.baos.toString());
		
		totalScore += 2;
	}
}
