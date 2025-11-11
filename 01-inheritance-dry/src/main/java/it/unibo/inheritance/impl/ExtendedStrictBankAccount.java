package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount{

    private static final double TRANSACTION_FEE = 0.1;

    private int transactions;

    public ExtendedStrictBankAccount(int id, double balance) { //costruttore
        super (id, balance);
        this.transactions = 0;
    }

    public void withdraw(final int id, final double amount) { 
        if (isWithdrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }
}
