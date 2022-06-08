package vtp2022.day2.workshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vtp2022.day2.workshop.account.BankAccount;
import vtp2022.day2.workshop.account.FixedDepositAccount;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testBankAccount(){
        System.out.println( "My ATM Machine - POSSBank" );
        //initialize bank acc
        BankAccount bkAcc = new BankAccount("My Bank Account");
        bkAcc.deposit("1000");
        float finalBalance = bkAcc.withdraw("500");
        assertEquals(500, finalBalance, .1);

    }

    @Test
    public void testFixedDepositAccountChangeInterestAndDuration(){
        try{
            FixedDepositAccount fdAcc = new FixedDepositAccount("My FD Acc", 1000);
            System.out.println("1. Fixed Deposit Acc Balance: " + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(4, 12);
            System.out.println("2. Fixed Deposit Acc Balance: " + fdAcc.getBalance());
        }
        catch(IllegalArgumentException e){
           assertTrue("Only can set duration and interest once.".equals(e.getMessage()));
        }
    }

    
    @Test
    public void testFixedDepositAccountChangeInterestAndDurationOnce(){
        
            FixedDepositAccount fdAcc = new FixedDepositAccount("My FD Acc", 1000);
            System.out.println("1. Fixed Deposit Acc Balance: " + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(4, 12);
            System.out.println("2. Fixed Deposit Acc Balance: " + fdAcc.getBalance());
            assertEquals(12, fdAcc.getDuration(), .1);
    }

    
    
}
