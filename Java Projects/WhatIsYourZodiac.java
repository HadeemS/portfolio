/* Hadeem Secka
 * 
 */
	import java.util.Scanner;
	public class WhatIsYourZodiac {


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Prompt the user to enter the month and day
	        System.out.println("What is your zodiac? ");
	        System.out.println("Enter your birthday -- Month followed by Day as numbers");
	        int month = scanner.nextInt();
	        int day = scanner.nextInt();

	        // Check if the month is valid
	        if (month < 1 || month > 12) {
	            System.out.println("Invalid month. Please enter a value between 1 and 12.");
	            return;
	        }

	        // Check if the day is valid based on the month
	        if (!isValidDay(month, day)) {
	            System.out.println("Invalid day for the given month.");
	            return;
	        }

	        // Determine and print the Zodiac sign
	        String zodiacSign = getZodiacSign(month, day);
	        System.out.println("Your Zodiac sign is: " + zodiacSign);
	    }

	    // Method to check the validity of the day based on the month
	    private static boolean isValidDay(int month, int day) {
	        int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        return day > 0 && day <= daysInMonth[month];
	    }

	    // Method to determine the Zodiac sign
	    private static String getZodiacSign(int month, int day) {
	        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "Aries";
	        if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "Taurus";
	        if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) return "Gemini";
	        if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) return "Cancer";
	        if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return "Leo";
	        if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return "Virgo";
	        if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return "Libra";
	        if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) return "Scorpio";
	        if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) return "Sagittarius";
	        if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) return "Capricorn";
	        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return "Aquarius";
	        if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) return "Pisces";
	        return "Unknown";
	    }
	}

