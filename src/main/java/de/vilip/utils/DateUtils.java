package de.vilip.utils;

import java.time.LocalDate;

public class DateUtils
{
	private static final LocalDate TODAY = LocalDate.now();

	public static String getCurrentYear()
	{
		return String.valueOf(TODAY.getYear());
	}

	public static String getCurrentMonth()
	{
		String month = String.valueOf(TODAY.getMonthValue());
		if (month.length() == 1)
		{
			return "0" + month;
		}
		return month;
	}

	public static String getCurrentDay()
	{
		String day = String.valueOf(TODAY.getDayOfMonth());
		if (day.length() == 1)
		{
			return "0" + day;
		}
		return day;
	}
}
