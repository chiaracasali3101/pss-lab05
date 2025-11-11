package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount{

    private static final double TRANSACTION_FEE = 0.1;

    public ExtendedStrictBankAccount(int id, double balance) { //costruttore
        super(id, balance);
        super.resetTransactions();
    }

    private void transactionOp(final int id, final double amount) { 
        if (checkUser(id)) {
            setBalance(getBalance() + amount);
            this.incrementTransactions();
        } 
    } 

    private boolean isWithdrawAllowed(final double amount) { 
        return getBalance() >= amount; 
    }

    @Override 
    public void withdraw(final int id, final double amount) { 
        if (this.isWithdrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }

    @Override
    public void chargeManagementFees(final int id) {
        final double feeAmount = MANAGEMENT_FEE + super.getTransactionsCount() * TRANSACTION_FEE; //super.getTransactionsCount() perchè voglio il suo valore
        if (super.checkUser(id) && this.isWithdrawAllowed(feeAmount)) {
            setBalance(getBalance() -feeAmount);
            super.resetTransactions();
        }
    }

}
