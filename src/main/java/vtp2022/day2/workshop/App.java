package vtp2022.day2.workshop;

import vtp2022.day2.workshop.account.BankAccount;
import vtp2022.day2.workshop.account.FixedDepositAccount;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My ATM Machine - POSSBank" );
        //initialize bank acc
        BankAccount bkAcc = new BankAccount("My Bank Account");
        bkAcc.deposit("1000");
        System.out.println("My new account balance > " + bkAcc.getBalance());
        //bkAcc.withdraw("200");
        System.out.println("Withdraw 50 -> My new account balance > " + bkAcc.withdraw("50"));

        //fixed deposit account
        FixedDepositAccount fdAcc = new FixedDepositAccount("My FD Acc", 1000);
        System.out.println("1. Fixed Deposit Acc Balance: " + fdAcc.getBalance());
        fdAcc.setDurationAndInterest(4, 12);
        System.out.println("2. Fixed Deposit Acc Balance: " + fdAcc.getBalance());
        //fdAcc.setDurationAndInterest(4, 12);
    }
}
