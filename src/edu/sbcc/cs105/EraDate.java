/**
 * CS 105 Theory & Practice I
 * CRN: 62499
 * Assignment: EraDate
 * 
 * Statement of code ownership: I hereby state that I have written all of this
 * code and I have not copied this code from any other person or source.
 * 
 * @author Mattys C vanZeyl
 */
package edu.sbcc.cs105;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class EraDate {
	public static String getEra(int day, int month, int year) {
		//Initialise era string
		String nengou;
		
		//translate date Ints to calendar
		GregorianCalendar testDate = new GregorianCalendar(year, month - 1, day);
		
		//define each era start time
		GregorianCalendar Heisei = new GregorianCalendar(1989, 0, 8); //actually January 8 (0, 8)
		GregorianCalendar Showa = new GregorianCalendar(1926, 11, 26); //actually Dec 25 (11, 25)
		GregorianCalendar Taisho = new GregorianCalendar(1912, 7, 1); //actually July 30 (7, 30)
		GregorianCalendar Meiji = new GregorianCalendar(1868, 0, 25); //actually October 23 (9, 23)
		GregorianCalendar EdoPeriod = new GregorianCalendar(1603, 2, 24); 
		GregorianCalendar AzuchiMomoyamaPeriod = new GregorianCalendar(1573, 0, 1); //approximate
		GregorianCalendar MuromachiPeriod = new GregorianCalendar(1336, 0, 1); //approximate
		
		//find the era
		if(testDate.getTimeInMillis() + 1000 > Heisei.getTimeInMillis()) nengou = "Heisei";
		else if(testDate.getTimeInMillis() + 1000 >= Showa.getTimeInMillis()) nengou = "Showa";
		else if(testDate.getTimeInMillis() + 1000 >= Taisho.getTimeInMillis()) nengou = "Taisho";
		else if(testDate.getTimeInMillis() + 1000 >= Meiji.getTimeInMillis()) nengou = "Meiji";
		else if(testDate.getTimeInMillis() + 1000 >= EdoPeriod.getTimeInMillis()) nengou = "Edo Period";
		else if(testDate.getTimeInMillis() + 1000 >= AzuchiMomoyamaPeriod.getTimeInMillis()) nengou = "Azuchi-Momoyama Period";
		else if(testDate.getTimeInMillis() + 1000 >= MuromachiPeriod.getTimeInMillis()) nengou = "Muromachi Period";
		else nengou = "Outside of Program Scope";
		
		return nengou;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print("Enter Day: ");
        int day = in.nextInt();
        System.out.print("Enter Month: ");
        int month = in.nextInt();
        System.out.print("Enter Year: ");
        int year = in.nextInt();
        in.close();
        System.out.println(getEra(day, month, year));
	}
}
