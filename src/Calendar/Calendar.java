package Calendar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) throws IOException
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please enter the year ");
		int year = kb.nextInt();
		printCalendar(year);
	}
	
	public static String Calendar(int month)
	{
		String [] array = {"January", "Feburary", "March", "April", "May","June","July","Angust","September","October","November","December"};
		return array[month-1];
	}
	public static boolean isLeap(int year)
	{
		boolean result = (year%4 == 0 && year %100 !=0)||(year%400 == 0)?true:false;
		return result;
	}
	public static int getNumberOfDay (int month, int year)
	{	int day = 0 ;
		switch(month)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;
			case 2:
				day = (isLeap(year))?29:28;
				break;
			default:
				day = 30;
		}
		return day;
	}
	public static int getDayOfTheWeek(int day, int month, int year)
	{
		int sum = 0 ;
		for(int i = 1900; i < year ; i++)
		{
			if(isLeap(i))
			{
				sum += 366;
			}
			else
			{
				sum += 365;
			}
		}
		
		for(int i = 1; i<= month; i++ )
		{
			sum += getNumberOfDay(i, year);
		}
		
		sum += day;
		
		return (sum%7);
	}
	
	public static void printCalendar(int year)throws IOException
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter your output file name");
		String fileName = kb.next();
		
		PrintWriter output = new PrintWriter(fileName);
		output.println("**********" + year +"'s calendar*******");
		
	for(int i = 1; i <= 12 ; i++)
	{		output.println("\t"+ Calendar(i));
	output.println("  Sun Mon Tue Wed Thr Fri Sat ");
		int startDay = getDayOfTheWeek(1, i, year);
		for(int j = 1 ; j <= startDay; j++ )
		{
			output.print("    ");
		}
		int numberOfDay = getNumberOfDay(i, year);
		for(int j = 1 ; j <= numberOfDay ; j++)
		{
			output.printf("%4d", j);
			if((startDay + j)%7 == 0)
			{
				output.println();
			}
		}
		output.println();
		output.println();
	}
	 output.close();
		
	}
	
}
	
	

