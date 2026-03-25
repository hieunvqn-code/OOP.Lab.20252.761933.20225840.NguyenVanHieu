import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String monthInput;
        int year = -1;
        int month = -1;

        
        while (true) {
            System.out.print("Enter month (Full name, Abbreviation, 3 letters, or Number): ");
            monthInput = sc.nextLine().trim();
            month = getMonthNumber(monthInput);
            
            if (month != -1) break;
            System.out.println("Invalid month. Please try again.");
        }

                while (true) {
            System.out.print("Enter year (non-negative number with all digits): ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year >= 0) break;
            } else {
                sc.next();             }
            System.out.println("Invalid year. Please enter a non-negative integer (e.g., 1999).");
        }

        
        int days = calculateDays(month, year);
        System.out.println("The number of days in the chosen month/year is: " + days);
        
        sc.close();
    }

    
    private static int getMonthNumber(String input) {
        String lower = input.toLowerCase();
        return switch (lower) {
            case "january", "jan.", "jan", "1" -> 1;
            case "february", "feb.", "feb", "2" -> 2;
            case "march", "mar.", "mar", "3" -> 3;
            case "april", "apr.", "apr", "4" -> 4;
            case "may", "5" -> 5;
            case "june", "jun.", "jun", "6" -> 6;
            case "july", "jul.", "jul", "7" -> 7;
            case "august", "aug.", "aug", "8" -> 8;
            case "september", "sept.", "sep", "9" -> 9;
            case "october", "oct.", "oct", "10" -> 10;
            case "november", "nov.", "nov", "11" -> 11;
            case "december", "dec.", "dec", "12" -> 12;
            default -> -1;
        };
    }

    
    private static int calculateDays(int month, int year) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            default -> 31;
        };
    }
}