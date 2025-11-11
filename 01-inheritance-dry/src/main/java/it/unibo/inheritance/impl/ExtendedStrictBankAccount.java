package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount{

    private static final double TRANSACTION_FEE = 0.1;

    private int transactions;
    private double balance;

    public ExtendedStrictBankAccount(int id, double balance) { //costruttore
        
    }

    private void transactionOp(final int id, final double amount) { //uguali
        if (checkUser(id)) {
            this.balance += amount;
            this.incrementTransactions();
        } 
    } 

    private boolean isWithdrawAllowed(final double amount) { //uguale
        return balance >= amount; 
    }

    @Override 
    public void withdraw(final int id, final double amount) { 
        if (isWithdrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }
}
