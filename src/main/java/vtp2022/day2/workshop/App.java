package vtp2022.day2.workshop;

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
        bkAcc.withdraw("200");
        System.out.println("My new account balance > " + bkAcc.getBalance());
    }
}
