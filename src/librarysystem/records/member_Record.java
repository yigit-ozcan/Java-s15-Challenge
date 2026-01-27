package librarysystem.records;

import librarysystem.enums.MemberType;

import java.time.LocalDate;

public abstract class member_Record {

    protected int memberID;
    protected MemberType type;
    protected LocalDate dateOfMembership;
    protected int noBookIssued;
    protected int maxBookLimit;
    protected String name;
    protected String address;
    protected String phoneNo;
    protected int balance;

    public void getMember() {

    }

    public int getNoBookIssued() {
        return noBookIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }


    public void incBookIssued() {

        if(noBookIssued < maxBookLimit) {
            noBookIssued++;
        }
    }

    public void decBookIssued() {

        if(noBookIssued > 0) {
            noBookIssued--;
        }
    }

    public void payBill() {
        balance = 0;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

}
