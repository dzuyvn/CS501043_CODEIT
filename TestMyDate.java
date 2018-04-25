// TestMyDate class.
// Fill in the parts that are marked "WRITE YOUR CODE HERE."

import java.util.*;

public class TestMyDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Enter the year, month and day (as integers): ");
       
        int year, month, day;

        try {
            year = scanner.nextInt();
            month = scanner.nextInt();
            day = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid integer input.");
            return;
        }

        // Read the integers year, month and day from the input using 
        // Scanner's nextInt(). 
        // If nextInt() throws an InputMismatchException, then print an
        // error message "Invalid integer input." and terminate program.
       
        // =======================
        // WRITE YOUR CODE HERE.
        // =======================
        
        MyDate date;
        try {
            date = new MyDate(year, month, day);
        } catch (InvalidDateException e) {
            System.out.println("MyDate: Invalid date.");
            return;
        }
        // Create a MyDate instance with the input year, month and day.
        // If MyDate constructor throws an InvalidDateException, then print
        // the message in the exception and terminate program.
       
        // =======================
        // WRITE YOUR CODE HERE.
        // =======================
       
        
        // Print out the date input by the user.
        System.out.println("The date you entered is " + date + ".");
    }
}

//InvalidDateException class.
//Fill in the parts that are marked "WRITE YOUR CODE HERE."

class InvalidDateException extends Exception {
 
 // =======================
 // WRITE YOUR CODE HERE.
 // =======================

 
 /************** Constructors **********************/ 
 
 public InvalidDateException(String s) {
     // =======================
     // WRITE YOUR CODE HERE.
     // =======================
     super(s);
 }

}


//MyDate class.
//Fill in the parts that are marked "WRITE YOUR CODE HERE."

class MyDate {

 /************** Data Members **********************/
 
 private int year;
 private int month;
 private int day;    
 private static int[] numDaysInMonth = 
                      {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

 
 /************** Constructors **********************/

 // Construct a MyDate instance from the input parameters year, month and day.
 // If year, month and day are not in the following valid ranges, 
 // an InvalidDateException will be thrown:
 //   year >= 1. 
 //   1 <= month <= 12.
 //   1 <= day <= X, where X is the number of days in that month.
 //
 // The InvalidDateException is thrown with the message "MyDate: Invalid date."
 
public MyDate(int year, int month, int day) throws InvalidDateException { 
     
     // =======================
     // WRITE YOUR CODE HERE.
     // =======================

    if (year < 1 || !(1 <= month && month <= 12) || day < 1) {
        throw new InvalidDateException("MyDate: Invalid date.");
    }

    if (month != 2 && day > numDaysInMonth[month - 1]) 
            throw new InvalidDateException("MyDate: Invalid date.");

    if (month == 2) {
            if (isLeapYear(year)) {  
                if (day > 29)
                    throw new InvalidDateException("MyDate: Invalid date.");
            } else {
                if (day > 28)
                    throw new InvalidDateException("MyDate: Invalid date.");
            }
        }

    this.year = year;
    this.month = month;
    this.day = day;
}
 
 
 /**************** Helper Methods ***********************/
 
 // Return true iff year is a leap year.
 // A year is a leap year if it is divisible by 400, or
 // it is divisible by 4 but not by 100.

 private static boolean isLeapYear(int year) {
     if (year < 1) return false;
     return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
 }

 
 /**************** Accessors ***********************/
 
 public int getYear() {
     return year;
 }
 
 public int getMonth() {
     return month;
 }   
 
 public int getDay() {
     return day;
 }    
 
 
 /***************** Overriding Methods ******************/
 
 public String toString() {
     return year + "-" + month + "-" + day;
 }
}
