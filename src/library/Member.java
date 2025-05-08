package library;

import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class Member {
    private String memberId;
    private String name;
    CustomLinkedList<Transaction> transactions;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        transactions = new CustomLinkedList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        try {
            transactions.add(transaction);
        }catch (NullPointerException e) {
            throw new NullPointerException("Transaction cannot be null");
        }

    }

    public Transaction getLastTransaction() {
        try {
            return transactions.getLast();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
