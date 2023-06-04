package model;

public class BankAccount {


    private Double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deposit(Double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }
        balance += amount;
    }

    public void withdraw(Double amount) {
        if(amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }
}
