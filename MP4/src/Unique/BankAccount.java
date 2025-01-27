package Unique;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BankAccount {
    private String accountHoldersFullName;
    private double balance;
    private long accountNumber;

    private static Map<String, Set<Object>> uniqueValues = new HashMap<>();

    public BankAccount(String accountHoldersFullName, double balance, long accountNumber) {
        this.accountHoldersFullName = accountHoldersFullName;
        this.balance = balance;
        setAccountNumber(accountNumber);
    }

    public void checkUniquenessOfTheValue(String attribute, Object value) throws IllegalArgumentException {
        String attributeKey = this.getClass().getName() + "." + attribute;

        if (uniqueValues.containsKey(attributeKey)) {
            for (Object bankAccount : uniqueValues.get(attributeKey)) {
                if (bankAccount.equals(value)) {
                    throw new IllegalArgumentException("The attribute: [" + attributeKey + "] with the value [" + value + "] already exists");
                }
            }
        } else {
            uniqueValues.put(attributeKey, new HashSet<>());
        }

        uniqueValues.get(attributeKey).add(value);
    }

    public String getAccountHoldersFullName() {
        return accountHoldersFullName;
    }

    public void setAccountHoldersFullName(String accountHoldersFullName) {
        this.accountHoldersFullName = accountHoldersFullName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        checkUniquenessOfTheValue("accountNumber", accountNumber);
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "fullName='" + accountHoldersFullName + '\'' +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
