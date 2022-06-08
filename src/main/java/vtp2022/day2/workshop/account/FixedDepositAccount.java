package vtp2022.day2.workshop.account;

public class FixedDepositAccount extends BankAccount{
    private float interest = 3;
    private int duration = 6;
    private int durationandInterestCounter = 0;
    

    public FixedDepositAccount(String name, float initialAmount){
        super(name, initialAmount);
        this.durationandInterestCounter = 0;
    }

    public FixedDepositAccount(String name, float initialAmount, float interest){
        super(name, initialAmount);
        //belong to this class
        this.interest = interest;
        this.durationandInterestCounter = 0;
    }

    public FixedDepositAccount(String name, float initialAmount, float interest, int duration){
        super(name, initialAmount);
        this.interest = interest;
        this.duration = duration;
        this.durationandInterestCounter = 0;
    }

    public int getDuration() {
        return duration;
    }

    private void setDuration(int duration) {
        if (duration < 0){
            throw new IllegalArgumentException("Unsupported duration");
        }

        // if (durationCounter > 1){
        //     throw new IllegalArgumentException("Only can set duration once.");
        // }
       
        this.duration = duration;
        //durationCounter++;
    }

    private void setInterest(float interest) {
        if (interest < 0){
            throw new IllegalArgumentException("Unsupported duration");
        }

        // if (durationCounter > 1){
        //     throw new IllegalArgumentException("Only can set duration once.");
        // }
       
        this.interest = interest;
        //durationCounter++;
    }

    public void setDurationAndInterest(float interest, int duration){
        if (durationandInterestCounter >= 1){
            throw new IllegalArgumentException("Only can set duration and interest once.");
        }
        setDuration(duration);
        setInterest(interest);
        durationandInterestCounter++;
    }

    @Override
    public float getBalance(){
        return super.getBalance() + interest;
    }

    @Override
    public float withdraw(String withdrawAmt){
        //NOP
        return 0;
    }

    @Override
    public void deposit(String depositAmt){
        //NOP 
    }
}
