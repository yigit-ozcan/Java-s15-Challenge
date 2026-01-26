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

    public void getMember() {

    }

    public void incBookIssued() {

    }

    public void decBookIssued() {

    }

    public void payBill() {

    }
}
