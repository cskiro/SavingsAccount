/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthlysavingsaccountbalance;

import java.time.Month;
import java.util.Scanner;

/**
 * Chapter 4 Exercise 2
 * 
 * Develop an algorithm to compute the month-by-month balance in your savings
 * account. 
 * 
 * You can make one (1) transaction per month. (a deposit or withdrawal)
 * Interest is added to the account and the beginning of the month.
 * The monthly interest rate is the yearly percentage rate divided by 12.
 * @author skiroc
 */
public class MonthlySavingsAccountBalance {
    
    private enum Months {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, 
    SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER}
    
    // TODO: Allow the user to enter in their own annual interest rate
    /**
     * Hard-coding the annual interest rate for testing purposes. 
     * The annual interest rate is expressed as a percentage (e.g. 0.078 = 7.8%)
     */
    private static final double ANNUAL_INTEREST_RATE = 0.078;
    private static final double NUMBER_OF_MONTHS = 12;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        // Instance variables
        boolean isEndOfYear = false;
        double balance, balanceAfterInterest;
        double monthlyInterestRate = (ANNUAL_INTEREST_RATE / NUMBER_OF_MONTHS);
        String decision;
        
        /**
         * Prompting the user to enter in their account balance at the beginning 
         * of the year
         */
        System.out.println("Please enter your savings account balance:");
        balance = kb.nextDouble();
        
        while (!isEndOfYear) {
           
            // Loop through the months 
            for (Months months : Months.values()) {
                String currentMonth = months.name().toString();
                System.out.println("The current month is: " + currentMonth);
                
                /**
                 * Monthly interest is applied at the beginning of each month. 
                 * The user will start earning interest at the beginning of February.
                 */
                if (months != Months.JANUARY) {
                    // Calculating the balance after interest has been applied
                    balanceAfterInterest = ((balance * monthlyInterestRate) + balance);
                    System.out.println("Your balance after interest is $" + balanceAfterInterest);
                    balance = balanceAfterInterest;
                } else {
                    System.out.println("Your current balance is $" + balance);
                } //end if-else
                
                System.out.println("Would you like to: " + "\r\n " + 
                        "A) Withdraw money" + "\r\n " 
                        + "B) Deposit money" + "\r\n " + "C) Exit");
                
                decision = kb.next().toLowerCase();
                
                switch (decision) {
                    case "a":
                        System.out.println("How much would you like to withdrawl?");
                        double withdrawalAmount = kb.nextDouble();
                        balance = balance - withdrawalAmount;
                        System.out.println("You deposited $" + withdrawalAmount +
                                "\r\n " + "Your balance is $" + balance);
                        break;
                    case "b":
                        System.out.println("How much would you like to deposit?");
                        double depositAmount = kb.nextDouble();
                        balance = balance + depositAmount;
                        System.out.println("You deposited $" + depositAmount +
                                "\r\n " + "Your balance is $" + balance);
                        break;
                    case "c":
                         break;
                    default:
                        // TODO: Re-display banking options 
                        System.out.println("Error: You entered an invalid key. "
                                + "Please try again.");
                        System.exit(0);
                } // end switch
                
                isEndOfYear = false;
                
                if (months == Months.DECEMBER) {
                    isEndOfYear = true;
                } // end if
                
            } //end for
            
        } // end while
        
    } // end main
    
} // end class
