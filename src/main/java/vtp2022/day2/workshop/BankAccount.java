package vtp2022.day2.workshop;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
//package to generate uuid
import java.util.UUID;

public class BankAccount {
    //bank account
    private String name = "";
    //this is a generated account id from java util UUIS class
    private String acctId = UUID.randomUUID().toString().substring(0,8);
    //holds the bank acc balance
    private float balance = 0f;
    //list of transaction history in the event of anyth done on the bankacc obj
    private List<String> transaction = new LinkedList<>();
    //whether account is closed or not
    private boolean isClosed = false;
    //accountcreation&closingdate
    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

    //constructor with bank acc name
    public BankAccount(String name){
        this.name = name;
        this.balance = 0;
    }

    //2nd constructor with bank acc name & initial bal
    public BankAccount(String name, float initialBal){
        this.name = name;
        this.balance = initialBal;
    }

    //get and set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    

    public float withdraw(String withdrawAmt){
        Float withdrawAmtF = null;

        //if a non-number is passed in, hit exception
        try{
            withdrawAmtF = Float.parseFloat(withdrawAmt);
            //check deposit amount cannot be less than or equal to 0
            if (withdrawAmtF.floatValue() <= 0){
                throw new IllegalArgumentException("Withdrawal Amount cannot be negative or zero");
            };

            //if account is closed, throw error, keyword this means belong to this class
            if(this.isClosed()){
                throw new IllegalArgumentException("Account is closed");
            }

            if(withdrawAmtF.floatValue() > this.balance){
                throw new IllegalArgumentException("Withdrawal Amount cannot be greater than account balance");
            }
            
            //update the class variable of the deposit amount
            this.balance = this.balance - withdrawAmtF.floatValue();
            //print "Withdraw $100 at -datetime-"
            //Construct transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Withdraw $");
            txnStrbld.append(withdrawAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            //save the event log into the txn linkedlist
            transaction.add(txnStrbld.toString());
            
        }
        catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }

        return withdrawAmtF.floatValue();
    }


    public void deposit(String depositAmt){
        //if a non-number is passed in, hit exception
        try{
            Float depositAmtF = Float.parseFloat(depositAmt);

            //check deposit amount cannot be less than or equal to 0
            if (depositAmtF.floatValue() <= 0){
                throw new IllegalArgumentException("Amount cannot be negative or zero");
            };

            //if account is closed, throw error, keyword this means belong to this class
            if(this.isClosed()){
                throw new IllegalArgumentException("Account is closed");
            }

            //update the class variable of the deposit amount
            this.balance = this.balance + depositAmtF.floatValue();
            //print "Desposit $100 at -datetime-"
            //Construct transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            //save the event log into the txn linkedlist
            transaction.add(txnStrbld.toString());
            
        }
        catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        

    }

}
