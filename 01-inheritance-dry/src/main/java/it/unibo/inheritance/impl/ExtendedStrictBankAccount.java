package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount{

    private static final double TRANSACTION_FEE = 0.1;

    private int transactions;
    private double balance;

    public ExtendedStrictBankAccount(int id, double balance) { //costruttore
        super(id, balance);
        this.transactions = 0;
    }

    private void transactionOp(final int id, final double amount) { 
        if (checkUser(id)) {
            this.balance += amount;
            this.incrementTransactions();
        } 
    } 

    private boolean isWithdrawAllowed(final double amount) { 
        return balance >= amount; 
    }

    @Override 
    public void withdraw(final int id, final double amount) { 
        if (this.isWithdrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }

    @Override
    public void chargeManagementFees(final int id) {
        final double feeAmount = MANAGEMENT_FEE + transactions * TRANSACTION_FEE;
        if (super.checkUser(id) && this.isWithdrawAllowed(feeAmount)) {
            balance -= feeAmount;
            transactions = 0;
        }
    }

}
